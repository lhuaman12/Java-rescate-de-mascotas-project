package server;

import domain.controllers.LoginController;
import domain.controllers.MascotaController;
import domain.controllers.RescateController;
import domain.controllers.UsuarioController;
import domain.middleware.AuthMiddleware;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.BooleanHelper;
import spark.utils.HandlebarsTemplateEngineBuilder;

public class Router {

    public static HandlebarsTemplateEngine engine;

    private static void initEngine() {
        Router.engine = HandlebarsTemplateEngineBuilder
                .create()
                .withDefaultHelpers()
                .withHelper("isTrue", BooleanHelper.isTrue)
                .build();
    }

    public static void init() {
        Router.initEngine();
        Spark.staticFileLocation("/public");
        Router.configure();
    }

    private static void configure() {
        LoginController loginController = new LoginController();
        AuthMiddleware authMiddleware = new AuthMiddleware();
        UsuarioController usuarioController = new UsuarioController();
        MascotaController mascotaController = new MascotaController();
        RescateController rescateController = new RescateController();

        // Login controller
        Spark.get("/", loginController::inicio, Router.engine);
        Spark.before("/", authMiddleware::verificarSesion);
        Spark.post("/login", loginController::login);
        Spark.get("/logout", loginController::logout);
        // Test
        Spark.get("/logins", loginController::mostrarTodos, Router.engine);

        // Usuario controller
        Spark.get("/user/:id", usuarioController::mostrar, Router.engine);
        Spark.get("/user/:id/contactos", usuarioController::mostrarContactos, Router.engine);

        // Mascota controller
        Spark.get("/mascota/:id", mascotaController::mostrar, Router.engine);

        // Rescate controller
        Spark.get("/rescate/:token", rescateController::rescateQR, Router.engine);
        Spark.get("/rescate", rescateController::rescateSinQR, Router.engine);
    }
}

