package domain.controllers;

import domain.controllers.utils.UtilsRequest;
import domain.entities.mascotas.*;
import domain.entities.organizaciones.Organizacion;
import domain.entities.organizaciones.PreguntasONG.Atributo;
import domain.entities.usuarios.Usuario;
import domain.entities.utils.QR.GeneradorQRRescate;
import domain.entities.utils.QR.QR;
import domain.entities.utils.normalizador.NormalizadorDeImagen.NormalizarImagen;
import domain.repositories.Repositorio;
import domain.repositories.factories.FactoryRepositorio;
import org.apache.commons.io.IOUtils;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.Part;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class MascotaController {

    private Repositorio<Mascota> repo;
    private Repositorio<MascotaRegistrada> repoMascotaRegistrada;
    private Repositorio<MascotaPerdida> repoMascotaPerdida;
    private Repositorio<Usuario> repoUsuarios;
    private Repositorio<Organizacion> organizaciones;


    public MascotaController() {
        this.repo = FactoryRepositorio.get(Mascota.class);
        this.repoMascotaRegistrada = FactoryRepositorio.get(MascotaRegistrada.class);
        this.repoMascotaPerdida = FactoryRepositorio.get(MascotaPerdida.class);
        this.repoUsuarios = FactoryRepositorio.get(Usuario.class);
        this.organizaciones= FactoryRepositorio.get(Organizacion.class);
    }

    public ModelAndView registrarMascota(Request request, Response response) {
        String idUsuario  = request.params("id");
        Map<String,Object> params = new HashMap<>();

        Usuario usuario = this.repoUsuarios.buscar(Integer.valueOf(idUsuario));
        List<Organizacion> organizaciones= this.organizaciones.buscarTodos();
        Organizacion organizacionMasCercana = usuario.getOrganizacionMasCercana(organizaciones);
        params.put("usuario", usuario);
        params.put("org",organizacionMasCercana);
        return new ModelAndView(params, "registro_mascota.hbs");
    }

    public Response guardarMascota(Request request, Response response) throws Exception {
        request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
        List<InputStream> streamDeFotos = new ArrayList<>();

        String idDuenio = request.params("id");
        String idOrganizacion = UtilsRequest.ObtainAttributeByName(request,"organizacion");
        Usuario usuario = this.repoUsuarios.buscar(Integer.valueOf(idDuenio));
        Organizacion organizacion = this.organizaciones.buscar(Integer.valueOf(idOrganizacion));
        ///////
        MascotaRegistrada mascota = new MascotaRegistrada();
        mascota.setDuenio(usuario);
        mascota.setOrganizacion(organizacion);
        ///
        Collection<Part> part = request.raw().getParts();
        Iterator<Part> iterator = part.iterator();
        Part partAux;
        while(iterator.hasNext()){
            partAux  =iterator.next();
            String name = partAux.getName();
            String value = IOUtils.toString(partAux.getInputStream(),StandardCharsets.UTF_8);
            //System.out.println("Name:"+name);
            //System.out.println("Valor:"+value);

            switch (name){
                case "nombre":
                    mascota.setNombre(value);
                    break;
                case "apodo":
                    mascota.setApodo(value);
                    break;
                case "tipo_de_mascota":
                    if(value.equals("gato"))
                        mascota.setTipoMascota(TipoMascota.GATO);
                    if(value.equals("perro"))
                        mascota.setTipoMascota(TipoMascota.PERRO);
                    break;
                case "sexo_mascota":
                    if(value.equals("macho"))
                        mascota.setSexo(Sexo.MACHO);
                    if(value.equals("hembra"))
                        mascota.setSexo(Sexo.HEMBRA);
                    break;
                case "tamanio_mascota":
                    if(value.equals("pequenio"))
                        mascota.setTamanioMascota(TamanioMascota.PEQUENIO);
                    if(value.equals("mediano"))
                        mascota.setTamanioMascota(TamanioMascota.MEDIANO);
                    if(value.equals("grande"))
                        mascota.setTamanioMascota(TamanioMascota.GRANDE);
                    break;
                case "esta_castrado" :
                    if(value.equals("Si"))
                        mascota.setEstaCastrado(Boolean.TRUE);
                    if(value.equals("No"))
                        mascota.setEstaCastrado(Boolean.FALSE);
                    break;
                case "files":
                        streamDeFotos.add(partAux.getInputStream()); //guardamos las fotos hasta que persistamos las mascota y obtengamos un ID
                        break;
                case "edad_mascota":
                    if(value.equals("cachorro"))
                    mascota.setEdadAproximada(EdadAproximada.CACHORRO);
                    if(value.equals("joven"))
                        mascota.setEdadAproximada(EdadAproximada.JOVEN);
                    if(value.equals("adulto"))
                        mascota.setEdadAproximada(EdadAproximada.ADULTO);
                    if(value.equals("abuelo"))
                        mascota.setEdadAproximada(EdadAproximada.ABUELO);
                    break;
                case "organizacion":
                    // no hacer nada
                    break;

                // Si no son atributos de plataforma son caracteristicas de organizacion
                default:

                    String idAtributo = name.substring(9); //TODO: recorta el string "pregunta_x" y devuelve x, esta medio hardcodeado xd

                    CaracteristicasONG caracteristica = new CaracteristicasONG();
                    Atributo atributo = organizacion.getPreguntasRequeridas().stream().filter( a -> a.getId()==Integer.valueOf(idAtributo)).findFirst().get();
                    caracteristica.setMascotaRegistrada(mascota);
                    caracteristica.setNombreCaracteristica(atributo.getCaracteristicaNombre());
                    caracteristica.setRespuesta(value);
                    mascota.getCaracteristicas().add(caracteristica);
                    break;


            }

        }

           repoMascotaRegistrada.agregar(mascota); // A partir de aca tiene una id unica en la DB, con eso se puede crear rutas unicas para las fotos y QRs

            // Normalizar fotos
            for (int i = 0 ; i<streamDeFotos.size(); i++){
                FotoMascota foto = new FotoMascota();
                foto.setEsRutaLocal(Boolean.TRUE);
                foto.guardarFoto(mascota,IOUtils.toByteArray(streamDeFotos.get(i)),i+1);
                NormalizarImagen normalizador = new NormalizarImagen(foto,organizacion.getEstandarImagen().getCalidadImagen(),organizacion.getEstandarImagen().getTamanioImagen());
                normalizador.normalizar();
                mascota.getFotosMascota().add(foto);
            }
            //QR
            QR qrMascota = new QR();
            GeneradorQRRescate generadorQR = new GeneradorQRRescate();
            qrMascota.setURL(generadorQR.crearQR(mascota,mascota.getDuenio()));
            mascota.setQrMascota(qrMascota);
            //
            repoMascotaRegistrada.agregar(mascota);

            /*
            System.out.println(mascota.getNombre());
            System.out.println(mascota.getApodo());
            System.out.println(mascota.getTipoMascota());
            System.out.println("duenio nombre : "+mascota.getDuenio().getNombre());
            System.out.println(mascota.getEdadAproximada());
            System.out.println("id de la mascota!!!"+mascota.getId());
             */

        return response;

    }

    public ModelAndView darEnAdopcion(Request request , Response response){

        return new ModelAndView(null,"dar_en_adopcion.hbs");
    }

    public Response handleDarEnAdopcion(Request request, Response response){


        return response;
    }



    public ModelAndView mostrar(Request request, Response response) {
        Mascota mascota = this.repo.buscar(Integer.valueOf(request.params("id")));
        Map<String, Object> params = new HashMap<>();
        params.put("mascota", mascota);

        return new ModelAndView(new HashMap<>(), "mascota.hbs");
    }

    public ModelAndView mostrarTodas(Request request, Response response) {
        return null;
    }

    public Response guardarRegistroMascota(Request request, Response response) {


        return response;
    }

    public Response modificar(Request request, Response response) {

        String id = request.params("id");
        String nombre = request.params("nombre");
        String apodo = request.params("apodo");

        MascotaRegistrada mascota = this.repoMascotaRegistrada.buscar(Integer.valueOf(id));
        mascota.setNombre(nombre);
        mascota.setApodo(apodo);
        this.repoMascotaRegistrada.modificar(mascota);

        response.redirect("/mascotas");
        return response;
    }
}
