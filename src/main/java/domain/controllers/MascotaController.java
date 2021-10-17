package domain.controllers;

import domain.entities.mascotas.Mascota;
import domain.repositories.Repositorio;
import domain.repositories.factories.FactoryRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;

public class MascotaController {

    private Repositorio<Mascota> repositorio;

    public MascotaController() {
        this.repositorio = FactoryRepositorio.get(Mascota.class);
    }

    public ModelAndView mostrar(Request request, Response response) {
        return new ModelAndView(new HashMap<>(), "mascota.hbs");
    }
}
