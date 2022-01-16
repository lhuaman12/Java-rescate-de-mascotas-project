package domain.controllers;

import domain.entities.domicilio.Domicilio;
import domain.entities.domicilio.Municipio;
import domain.entities.domicilio.Provincia;
import domain.entities.usuarios.Contacto;
import domain.entities.usuarios.MedioDeNotificacion;
import domain.entities.usuarios.Usuario;
import domain.repositories.Repositorio;
import domain.repositories.factories.FactoryRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuarioController {

    private Repositorio<Usuario> repositorio;
    private Repositorio<Contacto> repositorioContacto;

    public UsuarioController() {
        this.repositorio = FactoryRepositorio.get(Usuario.class);
        this.repositorioContacto = FactoryRepositorio.get(Contacto.class);
    }
    //crear usuario
    public ModelAndView crear(Request request, Response response) {
        return new ModelAndView(new HashMap<>(), "usuario.hbs");
    }
    //guardar el usuario
    public Response guardar(Request request, Response response) {

        System.out.println(request.queryParams());
        // System.out.println(request.queryParams("registrar_ok"));

        // instanciamiento de datos usuario,contacto
        Usuario usuario = new Usuario();
        Municipio municipioTemp = new Municipio();
        Provincia provinciaTemp = new Provincia();
        Domicilio domicilio = new Domicilio();

        Contacto contacto = new Contacto();

        //Usuario values
        String nombre = request.queryParams("nombre");
        String apellido = request.queryParams("apellido");
        String calle = request.queryParams("calle");
        String municipio = request.queryParams("municipio");
        String provincia = request.queryParams("provincia");
        String tipoDeDocumento = request.queryParams("tipo_de_doc");
        System.out.println(tipoDeDocumento);
        String nro_documento = request.queryParams("nro_documento");
        String codigoPostal = request.queryParams("codigo_postal");

        //String fecha_de_nacimiento = request.queryParams("fechaNacimiento"); Tipo?


        // Contacto values
        String nombre_contacto = request.queryParams("nombre_contacto");
        String apellido_contacto = request.queryParams("apellido_contacto");
        String tel_contacto = request.queryParams("tel_contacto");
        String email_contacto = request.queryParams("email_contacto");
        String medio_notif = request.queryParams("medio_notif");

        //asignacion
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setNroDocumento(nro_documento);

        usuario.agregarContacto(contacto);

        domicilio.setCalle(calle);
        domicilio.setCodPostal(codigoPostal);
        municipioTemp.setNombre(municipio);
        provinciaTemp.setNombre(provincia);

        municipioTemp.setProvincia(provinciaTemp);
        usuario.setDomicilio(domicilio);
        domicilio.setMunicipio(municipioTemp);

        contacto.setNombre(nombre_contacto);
        contacto.setApellido(apellido_contacto);
        contacto.setEmail(email_contacto);
        contacto.setTelefono(tel_contacto);

        System.out.println(medio_notif);
        switch(medio_notif){
            case "Whatsapp":
                contacto.setMedioDeNotificacion(MedioDeNotificacion.WHATSAPP);
                break;
            case "SMS":
                contacto.setMedioDeNotificacion(MedioDeNotificacion.SMS);
                break;
            case "email":
                contacto.setMedioDeNotificacion(MedioDeNotificacion.EMAIL);
                break;
            default:
                response.status(404);
                response.body("Error al cargar contacto");
                return response;
        }



        this.repositorio.agregar(usuario);


        response.redirect("/usuarios");
        return response;


        /*
        if(request.queryParams("registrar_ok")=="registrar_ok"){

        }

        // contacto usuario
        //Contacto contacto = new Contacto();

        response.redirect("/usuarios");
        return response;


         */

    }

    public ModelAndView mostrarTodos(Request request, Response response) {
        List<Usuario> usuarios = this.repositorio.buscarTodos();
        Map<String, Object> params = new HashMap<>();
        params.put("usuarios", usuarios);
        return new ModelAndView(params, "logins.hbs");

    }

    public ModelAndView mostrarUsuario(Request request, Response response) {
        Usuario usuario = this.repositorio.buscar(new Integer(request.params("id")));
        Map<String, Object> params = new HashMap<>();
        params.put("usuario", usuario);

        return new ModelAndView(params, "usuario.hbs");
    }

    public Response modificar(Request request, Response response) {

        String id = request.params("id");
        String nombre = request.queryParams("nombre");
        String apellido = request.queryParams("apellido");

        Usuario usuario = this.repositorio.buscar(new Integer(id));
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        this.repositorio.modificar(usuario);

        response.redirect("/usuarios");
        return response;
    }

    public ModelAndView crearContacto(Request request, Response response) {
        Usuario usuario = this.repositorio.buscar(new Integer(request.params("id")));
        Map<String, Object> params = new HashMap<>();
        params.put("usuario", usuario);

        return new ModelAndView(params, "contacto.hbs");
    }

    public Response guardarConctacto(Request request, Response response) {

        String nombre = request.queryParams("nombre");
        String apellido = request.queryParams("apellido");
        String telefono = request.queryParams("telefono");
        String email = request.queryParams("email");

        Contacto contacto = new Contacto();
        contacto.setNombre(nombre);
        contacto.setApellido(apellido);
        contacto.setTelefono(telefono);
        contacto.setEmail(email);

        String id = request.params("id");
        Usuario usuario = this.repositorio.buscar(new Integer(id));
        usuario.setContactos(contacto);
        this.repositorio.modificar(usuario);

        response.redirect("/usuario/" + id + "/contactos");
        return response;
    }

    public ModelAndView mostrarContacto(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();

        Contacto contacto = this.repositorioContacto.buscar(new Integer(request.params("idContacto")));
        parametros.put("contacto", contacto);

        return new ModelAndView(parametros, "contacto.hbs");
    }

    public Response modificarContacto(Request request, Response response) {

        Contacto contacto = this.repositorioContacto.buscar(new Integer(request.params("idContacto")));

        String nombre = request.queryParams("nombre");
        String apellido = request.queryParams("apellido");
        String telefono = request.queryParams("telefono");
        String email = request.queryParams("email");

        contacto.setNombre(nombre);
        contacto.setApellido(apellido);
        contacto.setTelefono(telefono);
        contacto.setEmail(email);

        this.repositorioContacto.modificar(contacto);

        response.redirect("/usuarios");
        return response;
    }

    public ModelAndView mostrarContactos(Request request, Response response) {

        Usuario usuario = this.repositorio.buscar(new Integer(request.params("id")));
        List<Contacto> contactos = usuario.getContactos();
        Map<String, Object> params = new HashMap<>();
        params.put("usuario", usuario);
        params.put("contactos", contactos);

        return new ModelAndView(params, "contactos.hbs");
    }

}

