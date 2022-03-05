package domain.controllers;

//import com.mysql.jdbc.log.Log;
import db.EntityManagerHelper;
import domain.entities.usuarios.Login;
import domain.entities.usuarios.Usuario;
import domain.repositories.Repositorio;
import domain.repositories.factories.FactoryRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class LoginController {

    private Repositorio<Login> loginRepositorio;
    private Repositorio<Usuario> usuarioRepositorio;

    public LoginController() {
        this.loginRepositorio = FactoryRepositorio.get(Login.class);
        this.usuarioRepositorio = FactoryRepositorio.get(Usuario.class);
    }

    public ModelAndView inicio(Request request, Response response) {
        HashMap<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros, "login.hbs");
    }

    public Response login(Request request, Response response) {

        String username = request.queryParams("username");
        String password1 = request.queryParams("password");
        Repositorio<Usuario> usuarioRepositorio = FactoryRepositorio.get(Usuario.class);
        List<Usuario> usuarios = this.usuarioRepositorio.buscarTodos();
        String password2 = "";
        int id = 0;

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getUsername().equals(username)) {
                password2 = usuarios.get(i).getPassword();
                id = usuarios.get(i).getId();
                break;
            }
        }
        //Usuario usuario = this.usuarioRepositorio.buscar(new Integer(username));
        if (password1.equals(password2) && !password2.isEmpty()) {
            request.session(true);
            request.session().attribute("id", id);
            response.redirect("/home/" + id);
        } else {
            response.redirect("/");
        }
        return response;
    }

    public Object logout(Request request, Response response) {
        request.session().invalidate();
        response.redirect("/");
        return response;
    }
}









/* LO QUE HABÌA ANTES DE PISARLO

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
        */
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
        *//*

        return response;
    }

    public ModelAndView mostrarTodos(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();
        List<Login> logins = this.repositorio.buscarTodos();
        parametros.put("logins", logins);
        return new ModelAndView(parametros, "logins.hbs");
    }
}
*/
