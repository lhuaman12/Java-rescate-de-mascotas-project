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
    //TODO: agregar partials para reutilizar plantillas
    private static void configure() {
        LoginController loginController = new LoginController();
        AuthMiddleware authMiddleware = new AuthMiddleware();
        UsuarioController usuarioController = new UsuarioController();
        MascotaController mascotaController = new MascotaController();
        RescateController rescateController = new RescateController();

        // Login
        Spark.get("/", loginController::inicio, Router.engine);
        Spark.before("/", authMiddleware::verificarSesion);
        Spark.post("/login", loginController::login);
        Spark.get("/logout", loginController::logout);
        // Test
        Spark.get("/logins", loginController::mostrarTodos, Router.engine);

        // Usuarios
        Spark.get("/usuarios", usuarioController::mostrarTodos, Router.engine);
        Spark.get("/usuario", usuarioController::crear, Router.engine);
        Spark.post("/usuario", usuarioController::guardar);
        Spark.get("/usuario/:id", usuarioController::mostrarUsuario, Router.engine);
        Spark.post("/usuario/:id", usuarioController::modificar);

        // Contactos
        Spark.get("/usuario/:id/contactos", usuarioController::mostrarContactos, Router.engine);
        Spark.get("/usuario/:id/contacto", usuarioController::crearContacto, Router.engine);
        Spark.post("/usuario/:id/contacto", usuarioController::guardarConctacto);
        Spark.get("/usuario/:idUsuario/contacto/:idContacto", usuarioController::mostrarContacto, Router.engine);
        Spark.post("/usuario/:idUsuario/contacto/:idContacto", usuarioController::modificarContacto);

        // Mascotas
        Spark.get("/mascotas", mascotaController::mostrarTodas, Router.engine);
        Spark.get("/mascota", mascotaController::crear, Router.engine);
        Spark.post("/mascota", mascotaController::guardar);
        Spark.get("/mascota/:id", mascotaController::mostrar, Router.engine);
        Spark.post("/mascota/:id", mascotaController::modificar);

        // Rescates
        Spark.get("/rescate/:token", rescateController::rescateQR, Router.engine);
        Spark.get("/rescate", rescateController::rescateSinQR, Router.engine);
        Spark.get("/rescate/:id", rescateController::mostrarRescateSinQR, Router.engine);

        // Publicaciones de mascotas perdidas


    }
}

