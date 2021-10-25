package domain.controllers;

import domain.entities.rescate.Rescate;
import domain.entities.rescate.RescateConQR;
import domain.entities.rescate.RescateSinQR;
import domain.entities.usuarios.Usuario;
import domain.repositories.Repositorio;
import domain.repositories.factories.FactoryRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class RescateController {

    private Repositorio<Rescate> repositorio;
    private Repositorio<RescateConQR> repositorioQR;
    private Repositorio<RescateSinQR> repositorioSinQR;

    public RescateController() {
        this.repositorio = FactoryRepositorio.get(Rescate.class);
        this.repositorioQR = FactoryRepositorio.get(RescateConQR.class);
        this.repositorioSinQR = FactoryRepositorio.get(RescateSinQR.class);
    }

    public ModelAndView rescateQR(Request request, Response response) {
        // ToDo: validar si el QR es válido; si no es válido, redirigir (por ejemplo) a "Mascota perdida sin QR" o 404
        return new ModelAndView(new HashMap<>(), "mascota_perdida_con_qr.hbs");
    }

    public ModelAndView rescateSinQR(Request request, Response response) {
        return new ModelAndView(new HashMap<>(), "mascota_perdida_sin_qr.hbs");
    }

    public ModelAndView mostrarRescateSinQR(Request request, Response response) {
        RescateSinQR rescate = this.repositorioSinQR.buscar(new Integer(request.params("id")));
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("rescate", rescate);

        return new ModelAndView(parametros, "mascota_perdida_sin_qr.hbs");
    }

}
