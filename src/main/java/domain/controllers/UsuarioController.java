package domain.controllers;

import domain.entities.domicilio.Domicilio;
import domain.entities.domicilio.Localidad;
import domain.entities.domicilio.Municipio;
import domain.entities.domicilio.Provincia;
import domain.entities.usuarios.Contacto;
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

        // datos usuario
        Usuario usuario = new Usuario();
        Localidad localidadTemp = new Localidad();
        Municipio municipioTemp = new Municipio();
        Provincia provinciaTemp = new Provincia();
        Domicilio domicilio = new Domicilio();
        // contacto usuario
        Contacto contacto = new Contacto();


        String nombre = request.queryParams("nombre");
        String apellido = request.queryParams("apellido");
        String calle = request.queryParams("calle");
        String localidad = request.queryParams("localidad");
        String municipio = request.queryParams("municipio");
        String provincia = request.queryParams("provincia");

        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        domicilio.setCalle(calle);
        localidadTemp.setLocalidad(localidad);
        municipioTemp.setMunicipio(municipio);
        provinciaTemp.setProvincia(provincia);

        municipioTemp.setProvincia(provinciaTemp);
        localidadTemp.setMunicipio(municipioTemp);
        domicilio.setLocalidad(localidadTemp);
        usuario.setDomicilio(domicilio);

        this.repositorio.agregar(usuario);

        //response.redirect("/usuarios");
        return response;

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

