package server;

import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.BooleanHelper;
import spark.utils.HandlebarsTemplateEngineBuilder;


public class Router {
    private static HandlebarsTemplateEngine engine;
    public static void initEngine(){
        Router.engine = HandlebarsTemplateEngineBuilder.create().withDefaultHelpers().withHelper("isTrue", BooleanHelper.isTrue).build();

    }
    public static void init(){
        Router.initEngine();
        Spark.staticFileLocation("/public");
        Router.configure();
    }
    private static void configure(){
        /* Middlewares y controllers
        UsuarioRestControllerEjemplo usuarioRestControllerEjemplo = new UsuarioRestControllerEjemplo();
        UsuarioController usuarioController = new UsuarioController();
        LoginController loginController     = new LoginController();
        AuthMiddleware authMiddleware       = new AuthMiddleware();

         */
        Spark.get("/",(req,res)->{
            return "hola";
        });
    }
}
