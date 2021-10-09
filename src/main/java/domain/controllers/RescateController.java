package domain.controllers;

import domain.entities.rescate.Rescate;
import domain.repositories.Repositorio;
import domain.repositories.factories.FactoryRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;

public class RescateController {

    private Repositorio<Rescate> repositorio;

    public RescateController() {
        this.repositorio = FactoryRepositorio.get(Rescate.class);
    }

    public ModelAndView rescateQR(Request request, Response response) {
        // ToDo: validar si el QR es válido; si no es válido, redirigir (por ejemplo) a "Mascota perdida sin QR" o 404
        return new ModelAndView(new HashMap<>(), "mascota_perdida_con_qr.hbs");
    }

    public ModelAndView rescateSinQR(Request request, Response response) {
        return new ModelAndView(new HashMap<>(), "mascota_perdida_sin_qr.hbs");
    }
}
