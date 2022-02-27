package domain.controllers;

import domain.controllers.utils.UtilsRequest;
import domain.entities.adopcion.Adopcion;
import domain.entities.adopcion.PeticionDeAdopcion;
import domain.entities.domicilio.Domicilio;
import domain.entities.domicilio.Municipio;
import domain.entities.domicilio.Provincia;
import domain.entities.mascotas.*;
import domain.entities.organizaciones.Organizacion;
import domain.entities.organizaciones.PreguntasONG.Atributo;
import domain.entities.publicacion.EstadoDePublicacion;
import domain.entities.publicacion.EstadoPosible;
import domain.entities.publicacion.PublicacionDarEnAdopcion;
import domain.entities.publicacion.PublicacionIntencionAdopcion;
import domain.entities.usuarios.*;
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
import javax.servlet.ServletException;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MascotaController {

    private Repositorio<Mascota> repo;
    private Repositorio<MascotaRegistrada> repoMascotaRegistrada;
    private Repositorio<MascotaPerdida> repoMascotaPerdida;
    private Repositorio<Usuario> repoUsuarios;
    private Repositorio<Organizacion> organizaciones;
    private Repositorio<PublicacionDarEnAdopcion> publicacionesDeAdopcion;
    private Repositorio<PublicacionIntencionAdopcion> publicacionesIntencionDeAdopcion;
    private Repositorio<MascotaEnAdopcion> mascotasEnAdopcion;
    private Repositorio<Virtud> repoVirtudes;
    private Repositorio<PeticionDeAdopcion> repoPeticiones;
    private List<Virtud> virtudes;


    public MascotaController() {
        this.repo = FactoryRepositorio.get(Mascota.class);
        this.repoMascotaRegistrada = FactoryRepositorio.get(MascotaRegistrada.class);
        this.repoMascotaPerdida = FactoryRepositorio.get(MascotaPerdida.class);
        this.repoUsuarios = FactoryRepositorio.get(Usuario.class);
        this.organizaciones= FactoryRepositorio.get(Organizacion.class);
        this.publicacionesDeAdopcion = FactoryRepositorio.get(PublicacionDarEnAdopcion.class);
        this.mascotasEnAdopcion = FactoryRepositorio.get(MascotaEnAdopcion.class);
        this.repoVirtudes = FactoryRepositorio.get(Virtud.class);
        this.publicacionesIntencionDeAdopcion=FactoryRepositorio.get(PublicacionIntencionAdopcion.class);
        this.repoPeticiones = FactoryRepositorio.get(PeticionDeAdopcion.class);
        virtudes = repoVirtudes.buscarTodos();
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

                    CaracteristicaRegistroDeMascota caracteristica = new CaracteristicaRegistroDeMascota();
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

        response.redirect("/usuario/"+usuario.getId()+"/registrar_mascota/success");
        return response;

    }

    public ModelAndView registroDeMascotaExitoso(Request request,Response response){

        String idUsuario = request.params("id");
        HashMap<String,Object> params = new HashMap<>();
        params.put("id",idUsuario);

        return new ModelAndView(params,"mascota_register_success.hbs");
    }

    public ModelAndView darEnAdopcion(Request request , Response response){

        return new ModelAndView(null,"dar_en_adopcion.hbs");
    }

    public Response handleDarEnAdopcion(Request request, Response response) throws ServletException, IOException {
        request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
        // Instanciacion
        Usuario duenioDeAdopcion = new Usuario();
        MascotaEnAdopcion mascotaEnAdopcion = new MascotaEnAdopcion();
        Adopcion adopcion = new Adopcion();
        PublicacionDarEnAdopcion publicacionDarEnAdopcion = new PublicacionDarEnAdopcion();
        Rol rol = new Rol();
        Domicilio domicilio = new Domicilio();
        Municipio municipio = new Municipio();
        Provincia provincia = new Provincia();
        Contacto contacto = new Contacto();
        //
        adopcion.setDuenioDeAdopcion(duenioDeAdopcion);
        adopcion.setMascota(mascotaEnAdopcion);
        publicacionDarEnAdopcion.setAdopcion(adopcion);
        domicilio.setMunicipio(municipio);
        municipio.setProvincia(provincia);
        duenioDeAdopcion.getContactos().add(contacto);
        rol.setNombre("duenio_de_adopcion"); // ??
        duenioDeAdopcion.getRoles().add(rol);
        duenioDeAdopcion.setDomicilio(domicilio);
        //
        Collection<Part> part = request.raw().getParts();
        Iterator<Part> iterator = part.iterator();
        Part partAux;
        while(iterator.hasNext()) {
            partAux = iterator.next();
            String name = partAux.getName();
            String value = IOUtils.toString(partAux.getInputStream(), StandardCharsets.UTF_8);

            switch(name){
                case "nombre":
                    duenioDeAdopcion.setNombre(value);
                    break;
                case "apellido":
                    duenioDeAdopcion.setApellido(value);
                    break;
                case "tipo_de_doc":
                    switch(value){
                        case "DNI":
                            duenioDeAdopcion.setTipoDocumento(TipoDocumento.DNI);
                            break;
                        case "libreta_civica":
                            duenioDeAdopcion.setTipoDocumento(TipoDocumento.LC);
                            break;
                        case "cedula_de_identidad":
                            duenioDeAdopcion.setTipoDocumento(TipoDocumento.CI);
                            break;
                        case "pasaporte":
                            duenioDeAdopcion.setTipoDocumento(TipoDocumento.PAS);
                            break;
                        case "libreta_de_enrolamiento":
                            duenioDeAdopcion.setTipoDocumento(TipoDocumento.LE);
                            break;
                    }
                    break;
                case "nro_documento":
                    duenioDeAdopcion.setNroDocumento(value);
                    break;
                case "provincia":
                    provincia.setNombre(value);
                    break;
                case "municipio":
                    municipio.setNombre(value);
                    break;
                case "calle":
                    domicilio.setCalle(value);
                    break;
                case "codigo_postal":
                    domicilio.setCodPostal(value);
                    break;
                case "nombre_contacto":

                    contacto.setNombre(value);
                    break;
                case "apellido_contacto":
                    contacto.setApellido(value);
                    break;
                case "tel_contacto":
                    contacto.setTelefono(value);
                    break;
                case "email_contacto":
                    contacto.setEmail(value);
                    break;
                case "files":
                    break;
                case "medio_notif":
                    switch(value){
                        case "Whatsapp":
                            contacto.setMedioDeNotificacion(MedioDeNotificacion.WHATSAPP);
                            break;
                        case "SMS":
                            contacto.setMedioDeNotificacion(MedioDeNotificacion.SMS);
                            break;
                        case "email":
                            contacto.setMedioDeNotificacion(MedioDeNotificacion.EMAIL);
                            break;
                    }
                    break;

                case "tipo_de_mascota":
                    if(value.equals("gato"))
                        mascotaEnAdopcion.setTipoMascota(TipoMascota.GATO);
                    if(value.equals("perro"))
                        mascotaEnAdopcion.setTipoMascota(TipoMascota.PERRO);
                    break;
                case "sexo_mascota":
                    if(value.equals("macho"))
                        mascotaEnAdopcion.setSexo(Sexo.MACHO);
                    if(value.equals("hembra"))
                        mascotaEnAdopcion.setSexo(Sexo.HEMBRA);
                    break;
                case "tamanio_mascota":
                    if(value.equals("pequenio"))
                        mascotaEnAdopcion.setTamanioMascota(TamanioMascota.PEQUENIO);
                    if(value.equals("mediano"))
                        mascotaEnAdopcion.setTamanioMascota(TamanioMascota.MEDIANO);
                    if(value.equals("grande"))
                        mascotaEnAdopcion.setTamanioMascota(TamanioMascota.GRANDE);
                    break;
                case "edad_mascota":
                    if(value.equals("cachorro"))
                        mascotaEnAdopcion.setEdadAproximada(EdadAproximada.CACHORRO);
                    if(value.equals("joven"))
                        mascotaEnAdopcion.setEdadAproximada(EdadAproximada.JOVEN);
                    if(value.equals("adulto"))
                        mascotaEnAdopcion.setEdadAproximada(EdadAproximada.ADULTO);
                    if(value.equals("abuelo"))
                        mascotaEnAdopcion.setEdadAproximada(EdadAproximada.ABUELO);
                    break;
                case "tiene_vacunas":
                    if(value.equals("si"))
                        mascotaEnAdopcion.setTieneTodasLasVacunas(Boolean.TRUE);
                    else
                        mascotaEnAdopcion.setTieneTodasLasVacunas(Boolean.FALSE);
                    break;
                case "virtud_1":
                case "virtud_2":
                case "virtud_3":
                case "virtud_4":
                case "virtud_5":
                case "virtud_6":
                    if(value!=null){
                        Virtud virtud = virtudes.stream().filter( v -> v.getNombre().equals(value)).collect(Collectors.toList()).get(0);
                        mascotaEnAdopcion.getVirtudes().add(virtud);
                    }
                    break;
                case "mascota_latitud":
                    domicilio.setLatitud(Double.valueOf(value));
                    break;
                case "mascota_longitud":
                    domicilio.setLongitud(Double.valueOf(value));
                    break;
                default :
                    System.out.println(name);
                    System.out.println(value);
            }

        }

        List <Organizacion> orgs = organizaciones.buscarTodos();
        Organizacion organizacionMasCercana = duenioDeAdopcion.getOrganizacionMasCercana(orgs);
        mascotaEnAdopcion.setOrganizacion(organizacionMasCercana);
        publicacionDarEnAdopcion.setOrganizacion(organizacionMasCercana);
        //
        EstadoDePublicacion estadoDePublicacion = new EstadoDePublicacion();
        estadoDePublicacion.setPublicacion(publicacionDarEnAdopcion);
        estadoDePublicacion.setEstadoPosible(EstadoPosible.EN_REVISION);
        mascotaEnAdopcion.setFueAdoptada(Boolean.FALSE);
        publicacionDarEnAdopcion.getEstadoDePublicacions().add(estadoDePublicacion);

        repoUsuarios.agregar(duenioDeAdopcion);

        mascotasEnAdopcion.agregar(mascotaEnAdopcion);

        publicacionesDeAdopcion.agregar(publicacionDarEnAdopcion);


        return response;
    }

    public ModelAndView intencionDeAdopcion(Request request,Response response){

        return new ModelAndView(null,"intencion_de_adopcion.hbs");
    }

    public Response handleIntencionDeAdopcion(Request request, Response response){
        // usuario
        Usuario usuario = new Usuario();
        MascotaEnAdopcion mascotaPreferida = new MascotaEnAdopcion();
        Municipio municipioTemp = new Municipio();
        Provincia provinciaTemp = new Provincia();
        Domicilio domicilio = new Domicilio();
        Contacto contacto = new Contacto();
        PeticionDeAdopcion peticionDeAdopcion = new PeticionDeAdopcion();

        //Usuario values
        String nombre = request.queryParams("nombre");
        String apellido = request.queryParams("apellido");
        String calle = request.queryParams("calle");
        String municipio = request.queryParams("municipio");
        String provincia = request.queryParams("provincia");
        String tipo_de_doc = request.queryParams("tipo_de_doc");
        String nro_documento = request.queryParams("nro_documento");
        String codigoPostal = request.queryParams("codigo_postal");
        String fecha_de_nacimiento = request.queryParams("fechaNacimiento");
        String latitud = request.queryParams("latitud");
        String longitud = request.queryParams("longitud");

        LocalDate fechaDeNacimiento = LocalDate.parse(fecha_de_nacimiento);


        // Contacto values
        String nombre_contacto = request.queryParams("nombre_contacto");
        String apellido_contacto = request.queryParams("apellido_contacto");
        String tel_contacto = request.queryParams("tel_contacto");
        String email_contacto = request.queryParams("email_contacto");
        String medio_notif = request.queryParams("medio_notif");

        //publicacion
        PublicacionIntencionAdopcion publicacion = new PublicacionIntencionAdopcion();


        // datos sobre mascota deseada
        TipoMascota tipoDeMascota = request.queryParams("tipo_de_mascota").equals("perro") ? TipoMascota.PERRO : TipoMascota.GATO;
        EdadAproximada edadMascota;
        switch (request.queryParams("edad_mascota")){
            case "cachorro":
                mascotaPreferida.setEdadAproximada(EdadAproximada.CACHORRO);
                break;
            case "joven":
                mascotaPreferida.setEdadAproximada(EdadAproximada.JOVEN);
                break;
            case "adulto":
                mascotaPreferida.setEdadAproximada(EdadAproximada.ADULTO);
                break;
            case "abuelo":
                mascotaPreferida.setEdadAproximada(EdadAproximada.ABUELO);
                break;
        }

        mascotaPreferida.setTieneTodasLasVacunas(request.queryParams("tiene_vacunas").equals("Si"));
        Sexo sexo = request.queryParams("sexo_mascota").equals("macho") ? Sexo.MACHO : Sexo.HEMBRA;
        mascotaPreferida.setSexo(sexo);

        switch(request.queryParams("tamanio_mascota")){
            case "pequenio":
                mascotaPreferida.setTamanioMascota(TamanioMascota.PEQUENIO);
                break;
            case "mediano":
                mascotaPreferida.setTamanioMascota(TamanioMascota.MEDIANO);
                break;
            case "grande":
                mascotaPreferida.setTamanioMascota(TamanioMascota.GRANDE);
                break;
        }

        for(int i = 1 ; i<=6 ; i++){
            String valueVirtud = request.queryParams("virtud_"+ i);
            if(valueVirtud!=null){
                Virtud virtud = virtudes.stream().filter( v -> v.getNombre().equals(valueVirtud)).collect(Collectors.toList()).get(0);
                mascotaPreferida.getVirtudes().add(virtud);
            }
            else break;
        }

        String titulo = request.queryParams("titulo");
        String descripcion = request.queryParams("descripcion");

        EstadoDePublicacion estado = new EstadoDePublicacion();
        estado.setEstadoPosible(EstadoPosible.EN_REVISION);

        publicacion.getEstadoDePublicacions().add(estado);
        publicacion.setTitulo(titulo);
        publicacion.setContenido(descripcion);


        //asignacion
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setNroDocumento(nro_documento);
        usuario.agregarContacto(contacto);
        usuario.setFechaNacimiento(fechaDeNacimiento);

        peticionDeAdopcion.setUsuario(usuario);
        peticionDeAdopcion.setMascotaPreferida(mascotaPreferida);
        publicacion.setPeticionDeAdopcion(peticionDeAdopcion);

        //usuario.setTipoDocumento(); TODO

        domicilio.setCalle(calle);
        domicilio.setCodPostal(codigoPostal);
        domicilio.setLatitud(Double.valueOf(latitud));
        domicilio.setLongitud(Double.valueOf(longitud));

        municipioTemp.setNombre(municipio);
        provinciaTemp.setNombre(provincia);

        municipioTemp.setProvincia(provinciaTemp);
        usuario.setDomicilio(domicilio);
        domicilio.setMunicipio(municipioTemp);

        contacto.setNombre(nombre_contacto);
        contacto.setApellido(apellido_contacto);
        contacto.setEmail(email_contacto);
        contacto.setTelefono(tel_contacto);

        switch(medio_notif){
            case "SMS":
                contacto.setMedioDeNotificacion(MedioDeNotificacion.SMS);
                break;
            case "Whatsapp":
                contacto.setMedioDeNotificacion(MedioDeNotificacion.WHATSAPP);
                break;
            case "Email":
                contacto.setMedioDeNotificacion(MedioDeNotificacion.EMAIL);
                break;
        }

        List<Organizacion> organizacionesActuales = organizaciones.buscarTodos();
        Organizacion organizacionMasCercana = usuario.getOrganizacionMasCercana(organizacionesActuales);
        publicacion.setOrganizacion(organizacionMasCercana);

        // persistir
        repoUsuarios.agregar(usuario);
        mascotasEnAdopcion.agregar(mascotaPreferida);
        repoPeticiones.agregar(peticionDeAdopcion);
        publicacionesIntencionDeAdopcion.agregar(publicacion);

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
