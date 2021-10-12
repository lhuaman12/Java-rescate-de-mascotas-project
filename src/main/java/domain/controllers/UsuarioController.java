package domain.controllers;

import domain.entities.domicilio.Domicilio;
import domain.entities.domicilio.Localidad;
import domain.entities.domicilio.Municipio;
import domain.entities.domicilio.Provincia;
import domain.entities.usuarios.Contacto;
import domain.entities.usuarios.UsuarioAlternativo;
import domain.repositories.Repositorio;
import domain.repositories.factories.FactoryRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuarioController {

    private Repositorio<UsuarioAlternativo> repositorio;
    private Repositorio<Contacto> repositorioContacto;

    public UsuarioController() {
        this.repositorio = FactoryRepositorio.get(UsuarioAlternativo.class);
        this.repositorioContacto = FactoryRepositorio.get(Contacto.class);
    }

    public ModelAndView crear(Request request, Response response) {
        return new ModelAndView(new HashMap<>(), "usuario.hbs");
    }


    public ModelAndView mostrarTodos(Request request, Response response) {
        List<UsuarioAlternativo> usuariosAlternativos = this.repositorio.buscarTodos();
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("usuarios", usuariosAlternativos);
        return new ModelAndView(parametros, "logins.hbs");

    }

    public ModelAndView mostrarUsuario(Request request, Response response) {
        UsuarioAlternativo usuarioAlternativo = this.repositorio.buscar(new Integer(request.params("id")));
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("usuario", usuarioAlternativo);

        return new ModelAndView(parametros, "usuario.hbs");
    }

    public Response modificar(Request request, Response response) {
        UsuarioAlternativo usuarioAlternativo = this.repositorio.buscar(new Integer(request.params("id")));

        String nombre = request.queryParams("nombre");
        String apellido = request.queryParams("apellido");

        usuarioAlternativo.setNombre(nombre);
        usuarioAlternativo.setApellido(apellido);

        this.repositorio.modificar(usuarioAlternativo);

        response.redirect("/logins");
        return response;
    }

    public Response guardar(Request request, Response response) {
        UsuarioAlternativo usuarioAlternativo = new UsuarioAlternativo();
        Domicilio domicilio = new Domicilio();
        Localidad localidadTemp = new Localidad();
        Municipio municipioTemp = new Municipio();
        Provincia provinciaTemp = new Provincia();

        String nombre = request.queryParams("nombre");
        String apellido = request.queryParams("apellido");
        String calle = request.queryParams("calle");
        String localidad = request.queryParams("localidad");
        String municipio = request.queryParams("municipio");
        String provincia = request.queryParams("provincia");

        usuarioAlternativo.setNombre(nombre);
        usuarioAlternativo.setApellido(apellido);
        domicilio.setCalle(calle);
        localidadTemp.setLocalidad(localidad);
        municipioTemp.setMunicipio(municipio);
        provinciaTemp.setProvincia(provincia);

        municipioTemp.setProvincia(provinciaTemp);
        localidadTemp.setMunicipio(municipioTemp);
        domicilio.setLocalidad(localidadTemp);
        usuarioAlternativo.setDomicilio(domicilio);
        this.repositorio.agregar(usuarioAlternativo);

        response.redirect("/usuarios");
        return response;

    }

    public ModelAndView crearContacto(Request request, Response response) {
        return new ModelAndView(new HashMap<>(), "contacto.hbs");
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

        this.repositorio.agregar(contacto);

        response.redirect("/usuarios");
        return response;
    }

    public ModelAndView mostrarContacto(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();

        UsuarioAlternativo usuarioAlternativo = this.repositorio.buscar(new Integer(request.params("idUsuario")));
        parametros.put("usuario", usuarioAlternativo);

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
}
