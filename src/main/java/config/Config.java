package config;

public class Config {
    // Database
    public static boolean useDataBase = false;
    // Spark
    public static int sparkPort = 9002;
    // SecretToken
    public static String secretToken = "wLLPnHGIMfTj2F/jbqCpgykBVzQhJUk1cj6FkGgZ05o="; // TODO: variable de entorno
    //public static String secretToken = System.getenv("SecretToken");
}