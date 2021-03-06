package server;


import domain.controllers.*;
import domain.middleware.AuthMiddleware;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.BooleanHelper;
import spark.utils.HandlebarsTemplateEngineBuilder;
import spark.utils.helpers.ConditionalHelpers;

public class Router {

    public static HandlebarsTemplateEngine engine;

    private static void initEngine() {
        Router.engine = HandlebarsTemplateEngineBuilder
                .create()
                .withDefaultHelpers()
                .withHelper("isTrue", BooleanHelper.isTrue)
                .withHelper("eq", ConditionalHelpers.eq)
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
        OrganizacionController organizacionController = new OrganizacionController();

        Spark.get("/index/:id",usuarioController::inicio,Router.engine);
        Spark.get("/index",usuarioController::inicio,Router.engine);


        // Login
        Spark.get("/", loginController::inicio, Router.engine);
        //Spark.before("/", authMiddleware::verificarSesion);
        Spark.post("/", loginController::login);
        Spark.get("/logout", loginController::logout);

/*        Spark.get("/", loginController::inicio, Router.engine);
        Spark.before("/", authMiddleware::verificarSesion);
        Spark.post("/login", loginController::login);
        Spark.get("/logout", loginController::logout);*/
/*

        // Sign up
        Spark.get("/sign_up/:id",usuarioController::registrarUsuario,Router.engine);
        Spark.post("/sign_up",loginController::enviarRegistroDeUsuario);

        // Test
        Spark.get("/logins", loginController::mostrarTodos, Router.engine);
*/

        // Usuarios
        //Spark.get("/usuarios", usuarioController::mostrarTodos, Router.engine);
        Spark.get("/registrar_duenio", usuarioController::registrarDuenio, Router.engine);
        Spark.post("/registrar_duenio", usuarioController::guardarNuevoDuenio);
        //Spark.get("/usuario/:id", usuarioController::mostrarUsuario, Router.engine);
        //Spark.post("/usuario/:id", usuarioController::modificar);

        // Mascotas
        Spark.get("/usuario/:id/registrar_mascota", mascotaController::registrarMascota, Router.engine);
        Spark.post("/usuario/:id/registrar_mascota",mascotaController::guardarMascota);
        //Spark.post("/mascota", mascotaController::guardarRegistroMascota);
        //
        Spark.get("/dar_en_adopcion",mascotaController::darEnAdopcion,Router.engine);
        Spark.post("/dar_en_adopcion",mascotaController::handleDarEnAdopcion);
        Spark.get("/usuario/:id/dar_en_adopcion",mascotaController::usuarioDarEnAdopcion,Router.engine);
        Spark.post("/usuario/:id/dar_en_adopcion",mascotaController::handleUsuarioDarEnAdopcion);
        //
        Spark.get("/adoptar",mascotaController::intencionDeAdopcion,Router.engine);
        Spark.post("/adoptar",mascotaController::handleIntencionDeAdopcion);
        Spark.get("/usuario/:id/adoptar",mascotaController::usuarioAdoptar,Router.engine);
        Spark.post("/usuario/:id/adoptar",mascotaController::handleUsuarioAdoptar);

        //
        Spark.get("/mascotas", mascotaController::mostrarTodas, Router.engine);
        Spark.get("/mascota/:id", mascotaController::mostrar, Router.engine);
        Spark.post("/mascota/:id", mascotaController::modificar);
        //
        Spark.get("/usuario/:id/registrar_mascota/success",mascotaController::registroDeMascotaExitoso,Router.engine);

        // Rescates
        Spark.get("/rescate/:rescate_token", rescateController::rescateQR, Router.engine);
        Spark.post("/rescate/enviar_form",rescateController::handleMascotaConQR);
        Spark.get("/rescate", rescateController::rescateSinQR, Router.engine);
        // usuario registrado rescate
        Spark.get("/usuario/:id/rescate", mascotaController::rescateSinQrUsuario, Router.engine);
        Spark.post("/usuario/:id/rescate",mascotaController::HandleRescateMascotaSinQRUsuario);
        Spark.post("/rescate",rescateController::handleRescateSinQR);
        //Spark.get("/rescate/:id", rescateController::mostrarRescateSinQR, Router.engine);
        Spark.get("/adoptar/eliminar/:id", mascotaController::eliminarPublicacionAdopcion);

        // Organizaciones

        Spark.get("/usuario/:id_usuario/panel", organizacionController::panelDeAdmnistrador, Router.engine);
        Spark.get("/usuario/:id_usuario/editar_atributo/:id_atributo",organizacionController::editarAtributo,Router.engine);
        Spark.post("/usuario/:id_usuario/editar_atributo/:id_atributo",organizacionController::handleEditarAtributo);
        Spark.delete("/usuario/:id_usuario/eliminar_atributo/:id_atributo",organizacionController::handleEliminarAtributo);
        Spark.get("/usuario/:id_usuario/agregar_atributo",organizacionController::agregarAtributo,Router.engine);
        Spark.post("/usuario/:id_usuario/agregar_atributo",organizacionController::handleAgregarAtributo);

        /*
        // Contactos
        Spark.get("/usuario/:id/contactos", usuarioController::mostrarContactos, Router.engine);
        Spark.get("/usuario/:id/contacto", usuarioController::crearContacto, Router.engine);
        Spark.post("/usuario/:id/contacto", usuarioController::guardarConctacto);
        Spark.get("/usuario/:idUsuario/contacto/:idContacto", usuarioController::mostrarContacto, Router.engine);
        Spark.post("/usuario/:idUsuario/contacto/:idContacto", usuarioController::modificarContacto);
        */

    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }

        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }


}

