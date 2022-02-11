package domain.controllers;

import domain.entities.domicilio.Domicilio;
import domain.entities.domicilio.Municipio;
import domain.entities.domicilio.Provincia;
import domain.entities.mascotas.*;
import domain.entities.organizaciones.Organizacion;
import domain.entities.publicaciones.PublicacionRescate;
import domain.entities.rescate.Rescate;
import domain.entities.usuarios.*;
import domain.entities.utils.QR.JWTUtil;
import domain.entities.utils.notificador.estrategias.NotificarEmail;
import domain.repositories.Repositorio;
import domain.repositories.factories.FactoryRepositorio;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.apache.commons.io.IOUtils;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class RescateController {

    private Repositorio<Rescate> repositorioRescastes;
    private Repositorio<MascotaRegistrada> repositorioMascotasRegistradas;
    private Repositorio<PublicacionRescate> repositorioPublicacionesRescate;
    private Repositorio <MascotaPerdida> repositorioMascotasPerdidas;
    private Repositorio<Organizacion> repositorioOrganizaciones;

    public RescateController() {
        this.repositorioRescastes = FactoryRepositorio.get(Rescate.class);
        this.repositorioPublicacionesRescate = FactoryRepositorio.get(PublicacionRescate.class);
        this.repositorioMascotasRegistradas = FactoryRepositorio.get(MascotaRegistrada.class);
        this.repositorioMascotasPerdidas = FactoryRepositorio.get(MascotaPerdida.class);
        this.repositorioOrganizaciones = FactoryRepositorio.get(Organizacion.class);
    }

    public ModelAndView rescateQR(Request request, Response response) {
        Map<String,Object> param = new HashMap<>();

        String rescateToken = request.params("rescate_token");
        JWTUtil JWT = new JWTUtil();
        Jws<Claims> parsed =JWT.leerToken(rescateToken);

        if(rescateToken==null || parsed==null) // Si el el param esta vacio o la clave es invalida
            return new ModelAndView(new HashMap<>(),"error.hbs");

        // el token esta ligado al ID de la base de datos, se deberia hashear para evitar usos malintencionados como usar IDs al azar

        param.put("token",rescateToken);

        return new ModelAndView(param, "mascota_perdida_con_qr.hbs");
    }

    public Response handleMascotaConQR(Request request, Response response) throws IOException, ServletException {

        request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));

        String mascotaEncontradaId = new String();
        Domicilio domicilio = new Domicilio();
        Usuario rescatista = new Usuario();
        Contacto contacto = new Contacto();
        Municipio municipioTemp = new Municipio();
        Provincia provinciaTemp = new Provincia();
        Rol rol = new Rol();
        MensajeMascotaPerdida mensaje = new MensajeMascotaPerdida();
        ///
        rescatista.setDomicilio(domicilio);
        rescatista.getContactos().add(contacto);
        domicilio.setMunicipio(municipioTemp);
        municipioTemp.setProvincia(provinciaTemp);
        rol.setNombre("rescatista");
        rescatista.getRoles().add(rol);
        ///
        Collection<Part> part = request.raw().getParts();
        Iterator<Part> iterator = part.iterator();
        Part partAux;
        while(iterator.hasNext()) {
            partAux = iterator.next();
            String name = partAux.getName();
            String value = IOUtils.toString(partAux.getInputStream(), StandardCharsets.UTF_8);

            switch(name){
                case "nombre":
                    rescatista.setNombre(value);
                    break;
                case "apellido":
                    rescatista.setApellido(value);
                    break;
                case "tipo_de_doc":
                    switch(value){
                        case "DNI":
                            rescatista.setTipoDocumento(TipoDocumento.DNI);
                            break;
                        case "libreta_civica":
                            rescatista.setTipoDocumento(TipoDocumento.LC);
                            break;
                        case "cedula_de_identidad":
                            rescatista.setTipoDocumento(TipoDocumento.CI);
                            break;
                        case "pasaporte":
                            rescatista.setTipoDocumento(TipoDocumento.PAS);
                            break;
                        case "libreta_de_enrolamiento":
                            rescatista.setTipoDocumento(TipoDocumento.LE);
                            break;
                    }
                    break;
                case "nro_documento":
                    rescatista.setNroDocumento(value);
                    break;
                case "provincia":
                    provinciaTemp.setNombre(value);
                    break;
                case "municipio":
                    municipioTemp.setNombre(value);
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
                    //normalizar o que hacer con las fotos?

                    break;
                case "descripcion_mascota":
                    mensaje.setEstadoDeLaMascota(value);
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

                case "token":
                    JWTUtil JWT = new JWTUtil();
                    Jws<Claims> parsed =JWT.leerToken(value);
                    mascotaEncontradaId = parsed.getBody().getId();
                    break;
            }

        }

        // Si esta ok mandar el mensaje al duenio
        MascotaRegistrada mascota = repositorioMascotasRegistradas.buscar(Integer.valueOf(mascotaEncontradaId)); //
        mensaje.setRescatista(rescatista);
        mensaje.setMascota(mascota);
        System.out.println("Mascota encontrada: " + mascota.getNombre());
        mensaje.setContacto(mascota.getDuenio().getContactos().get(0));
        NotificarEmail notificarEmail = new NotificarEmail();
        //TODO: notificar al email
        //notificarEmail.notificar(mensaje);

        return response;
    }

    public ModelAndView rescateSinQR(Request request, Response response) {
        return new ModelAndView(new HashMap<>(), "mascota_perdida_sin_qr.hbs");
    }

    public Response handleRescateSinQR(Request request, Response response) throws ServletException, IOException {
        request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));

        Domicilio domicilioRescatista = new Domicilio();
        Domicilio lugarMascotaEncontrada = new Domicilio();
        Usuario rescatista = new Usuario();
        Contacto contacto = new Contacto();
        Municipio municipioTemp = new Municipio();
        Provincia provinciaTemp = new Provincia();
        Rol rol = new Rol();
        Rescate rescate = new Rescate();
        MascotaPerdida mascotaPerdida = new MascotaPerdida();
        ///
        rescatista.setDomicilio(domicilioRescatista);
        rescatista.getContactos().add(contacto);
        domicilioRescatista.setMunicipio(municipioTemp);
        municipioTemp.setProvincia(provinciaTemp);
        rol.setNombre("rescatista");
        rescatista.getRoles().add(rol);
        //
        rescate.setMascotaPerdida(mascotaPerdida);
        rescate.setDomicilio(lugarMascotaEncontrada);
        rescate.setRescatista(rescatista);
        ///
        Collection<Part> part = request.raw().getParts();
        Iterator<Part> iterator = part.iterator();
        Part partAux;
        while(iterator.hasNext()) {
            partAux = iterator.next();
            String name = partAux.getName();
            String value = IOUtils.toString(partAux.getInputStream(), StandardCharsets.UTF_8);

            switch(name){
                case "nombre":
                    rescatista.setNombre(value);
                    break;
                case "apellido":
                    rescatista.setApellido(value);
                    break;
                case "tipo_de_doc":
                    switch(value){
                        case "DNI":
                            rescatista.setTipoDocumento(TipoDocumento.DNI);
                            break;
                        case "libreta_civica":
                            rescatista.setTipoDocumento(TipoDocumento.LC);
                            break;
                        case "cedula_de_identidad":
                            rescatista.setTipoDocumento(TipoDocumento.CI);
                            break;
                        case "pasaporte":
                            rescatista.setTipoDocumento(TipoDocumento.PAS);
                            break;
                        case "libreta_de_enrolamiento":
                            rescatista.setTipoDocumento(TipoDocumento.LE);
                            break;
                    }
                    break;
                case "nro_documento":
                    rescatista.setNroDocumento(value);
                    break;
                case "provincia":
                    provinciaTemp.setNombre(value);
                    break;
                case "municipio":
                    municipioTemp.setNombre(value);
                    break;
                case "calle":
                    domicilioRescatista.setCalle(value);
                    break;
                case "codigo_postal":
                    domicilioRescatista.setCodPostal(value);
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
                    //normalizar o que hacer con las fotos?

                    break;
                case "descripcion_mascota":
                    rescate.setDescripcion(value);
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
                case "mascota_latitud":
                    lugarMascotaEncontrada.setLatitud(Double.valueOf(value));
                    break;
                case "mascota_longitud":
                    lugarMascotaEncontrada.setLongitud(Double.valueOf(value));
                    break;
                case "tipo_de_mascota":
                    if(value.equals("gato"))
                        mascotaPerdida.setTipoMascota(TipoMascota.GATO);
                    if(value.equals("perro"))
                        mascotaPerdida.setTipoMascota(TipoMascota.PERRO);
                    break;
                case "sexo_mascota":
                    if(value.equals("macho"))
                        mascotaPerdida.setSexo(Sexo.MACHO);
                    if(value.equals("hembra"))
                        mascotaPerdida.setSexo(Sexo.HEMBRA);
                    break;
                case "tamanio_mascota":
                    if(value.equals("pequenio"))
                        mascotaPerdida.setTamanioMascota(TamanioMascota.PEQUENIO);
                    if(value.equals("mediano"))
                        mascotaPerdida.setTamanioMascota(TamanioMascota.MEDIANO);
                    if(value.equals("grande"))
                        mascotaPerdida.setTamanioMascota(TamanioMascota.GRANDE);
                    break;
                case "edad_mascota":
                    if(value.equals("cachorro"))
                        mascotaPerdida.setEdadAproximada(EdadAproximada.CACHORRO);
                    if(value.equals("joven"))
                        mascotaPerdida.setEdadAproximada(EdadAproximada.JOVEN);
                    if(value.equals("adulto"))
                        mascotaPerdida.setEdadAproximada(EdadAproximada.ADULTO);
                    if(value.equals("abuelo"))
                        mascotaPerdida.setEdadAproximada(EdadAproximada.ABUELO);
                    break;

            }

        }

        List<Organizacion> organizaciones= this.repositorioOrganizaciones.buscarTodos();
        Organizacion organizacionMasCercana = rescate.getOrganizacionMasCercana(organizaciones);
        rescate.setOrganizacion(organizacionMasCercana);
        PublicacionRescate publicacion = new PublicacionRescate();
        publicacion.setRescate(rescate);
        publicacion.generarTitulo();
        publicacion.generarContenido();

        System.out.println(publicacion.getTitulo());
        System.out.println(publicacion.getContenido());

        //repositorioPublicacionesRescate.agregar(publicacion);


        return response;
    }

}
