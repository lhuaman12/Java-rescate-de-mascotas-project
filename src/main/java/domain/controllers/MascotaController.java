package domain.controllers;

import domain.entities.mascotas.Mascota;
import domain.entities.mascotas.MascotaPerdida;
import domain.entities.mascotas.MascotaRegistrada;
import domain.repositories.Repositorio;
import domain.repositories.factories.FactoryRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class MascotaController {

    private Repositorio<Mascota> repo;
    private Repositorio<MascotaRegistrada> repoMascotaRegistrada;
    private Repositorio<MascotaPerdida> repoMascotaPerdida;


    public MascotaController() {
        this.repo = FactoryRepositorio.get(Mascota.class);
        this.repoMascotaRegistrada = FactoryRepositorio.get(MascotaRegistrada.class);
        this.repoMascotaPerdida = FactoryRepositorio.get(MascotaPerdida.class);
    }

    public ModelAndView crear(Request request, Response response) {
        return new ModelAndView(new HashMap<>(), "mascota.hbs");
    }

    public ModelAndView mostrar(Request request, Response response) {
        Mascota mascota = this.repo.buscar(new Integer(request.params("id")));
        Map<String, Object> params = new HashMap<>();
        params.put("mascota", mascota);

        return new ModelAndView(new HashMap<>(), "mascota.hbs");
    }

    public ModelAndView mostrarTodas(Request request, Response response) {
        return null;
    }

    public Response guardar(Request request, Response response) {
        return null;
    }

    public Response modificar(Request request, Response response) {

        String id = request.params("id");
        String nombre = request.params("nombre");
        String apodo = request.params("apodo");

        MascotaRegistrada mascota = this.repoMascotaRegistrada.buscar(new Integer(id));
        mascota.setNombre(nombre);
        mascota.setApodo(apodo);
        this.repoMascotaRegistrada.modificar(mascota);

        response.redirect("/mascotas");
        return response;
    }
}
