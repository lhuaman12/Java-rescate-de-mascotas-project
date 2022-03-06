package server;

import spark.Spark;
import spark.debug.DebugScreen;

import static config.Config.sparkPort;

public class Server {
    public static void main(String[] args) {
        Spark.port(sparkPort);
        Router.init();
        DebugScreen.enableDebugScreen();
    }
}