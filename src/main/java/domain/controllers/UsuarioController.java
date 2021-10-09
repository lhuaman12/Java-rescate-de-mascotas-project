package domain.controllers;

import domain.entities.usuarios.Usuario;
import domain.repositories.Repositorio;
import domain.repositories.factories.FactoryRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;

public class UsuarioController {

    private Repositorio<Usuario> repositorio;

    public UsuarioController() {
        this.repositorio = FactoryRepositorio.get(Usuario.class);
    }

    public ModelAndView mostrar(Request request, Response response) {
        return new ModelAndView(new HashMap<>(), "usuario.hbs");
    }

    public ModelAndView mostrarContactos(Request request, Response response) {
        return new ModelAndView(new HashMap<>(), "contacto.hbs");
    }
}
