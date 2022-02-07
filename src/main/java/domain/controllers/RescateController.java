package domain.controllers;

import domain.entities.mascotas.MascotaRegistrada;
import domain.entities.rescate.Rescate;
import domain.entities.rescate.RescateConQR;
import domain.entities.rescate.RescateSinQR;
import domain.entities.usuarios.Usuario;
import domain.entities.utils.QR.JWTUtil;
import domain.repositories.Repositorio;
import domain.repositories.factories.FactoryRepositorio;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class RescateController {

    private Repositorio<Rescate> repositorio;
    private Repositorio<RescateConQR> repositorioQR;
    private Repositorio<RescateSinQR> repositorioSinQR;
    private Repositorio<MascotaRegistrada> mascotasRegistradas;

    public RescateController() {
        this.repositorio = FactoryRepositorio.get(Rescate.class);
        this.repositorioQR = FactoryRepositorio.get(RescateConQR.class);
        this.repositorioSinQR = FactoryRepositorio.get(RescateSinQR.class);
        this.mascotasRegistradas = FactoryRepositorio.get(MascotaRegistrada.class);
    }

    public ModelAndView rescateQR(Request request, Response response) {
        Map<String,Object> param = new HashMap<>();

        String rescateToken = request.params("rescate_token");
        JWTUtil JWT = new JWTUtil();
        Jws<Claims> parsed =JWT.leerToken(rescateToken);

        if(rescateToken==null || parsed==null) // Si el el param esta vacio o la clave es invalida
            return new ModelAndView(new HashMap<>(),"error");

        // el token esta ligado al ID de la base de datos, se deberia hashear para evitar usos malintencionados como usar IDs al azar

        param.put(rescateToken,"token");

        return new ModelAndView(param, "mascota_perdida_con_qr.hbs");
    }

    public Response handleMascotaConQR(Request request, Response response){
        /*
        String rescateToken = request.params("rescate_token");
        JWTUtil JWT = new JWTUtil();
        Jws<Claims> parsed =JWT.leerToken(rescateToken);


        if(parsed==null || rescateToken==null)
            return new ModelAndView(new HashMap<>(),"error");

        // Si esta ok mandar el mensaje al cliente
        String idMascota = parsed.getBody().getId();
        MascotaRegistrada mascota = mascotasRegistradas.buscar(Integer.valueOf(idMascota)); //
        Usuario duenio = mascota.getDuenio();


        return new ModelAndView(param,"mensaje_enviado_exitosamente.hbs");
        */
        return null;
    }

    public ModelAndView rescateSinQR(Request request, Response response) {
        return new ModelAndView(new HashMap<>(), "mascota_perdida_sin_qr.hbs");
    }

    public ModelAndView mostrarRescateSinQR(Request request, Response response) {
        RescateSinQR rescate = this.repositorioSinQR.buscar(Integer.valueOf("id"));
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("rescate", rescate);

        return new ModelAndView(parametros, "mascota_perdida_sin_qr.hbs");
    }

}
