package config;

import domain.entities.mascotas.Virtud;
import domain.repositories.Repositorio;
import domain.repositories.factories.FactoryRepositorio;

public class Config {
    // Database
    public static boolean useDataBase = true;
    // Spark
    public static int sparkPort = 9002;
    // SecretToken
    public static String secretToken = "wLLPnHGIMfTj2F/jbqCpgykBVzQhJUk1cj6FkGgZ05o=";
    //public static String secretToken = System.getenv("SecretToken");

    public void persistirCaracteristicas(){
        Repositorio<Virtud> virtudes = FactoryRepositorio.get(Virtud.class);

        Virtud virtud1 = new Virtud();
        Virtud virtud2 = new Virtud();
        Virtud virtud3 = new Virtud();
        Virtud virtud4 = new Virtud();
        Virtud virtud5 = new Virtud();

        virtud1.setNombre("carinioso"); //CARINIOSO,MANSO,PROTECTOR,TIMIDO,ALEGRE,CARACTER_FUERTE
        virtud1.setNombre("manso");
        virtud1.setNombre("protector");
        virtud1.setNombre("timido");
        virtud1.setNombre("alegre");
        virtud1.setNombre("caracter_fuerte");

        virtudes.agregar(virtud1);
        virtudes.agregar(virtud2);
        virtudes.agregar(virtud3);
        virtudes.agregar(virtud4);
        virtudes.agregar(virtud5);

    }
}