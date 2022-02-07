package domain.controllers;

import com.mysql.jdbc.log.Log;
import db.EntityManagerHelper;
import domain.entities.usuarios.Login;
import domain.repositories.Repositorio;
import domain.repositories.factories.FactoryRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginController {

    private Repositorio<Login> repositorio;

    public LoginController() {
        this.repositorio = FactoryRepositorio.get(Login.class);
    }

    public ModelAndView inicio(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros,"login.hbs");
    }

    public ModelAndView login(Request request, Response response) {
        return new ModelAndView(new HashMap<>(), "login.hbs");
    }

    public Response logout(Request request, Response response){
        request.session().invalidate();
        response.redirect("/");
        return response;
    }

    // TODO: sirve para registrarse, puede estar aca?
    public Response enviarRegistroDeUsuario(Request request,Response response){
        String id = request.params("id");
        String nombreUsuario = request.queryParams("nombre_usuario");
        String contrasenia = request.queryParams("contrasenia");
        Login login = (Login) EntityManagerHelper.getEntityManager().createQuery("from login where username="+nombreUsuario).getSingleResult();
        /*
        if(login != null)
            response.redirect("/sign_up/"+id+"?user_error=1.jpg");
        else {
            if(validarContrasenia(contrasenia)){
                //crear contrasenia
            }
            else
                response.redirect("/sign_up/"+id+"?password_error=1.jpg");
        }
        */
        return response;
    }

    public ModelAndView mostrarTodos(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();
        List<Login> logins = this.repositorio.buscarTodos();
        parametros.put("logins", logins);
        return new ModelAndView(parametros, "logins.hbs");
    }
}
