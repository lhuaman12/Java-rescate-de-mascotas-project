package domain.repositories.testMemoData;

import domain.entities.EntidadPersistente;
import domain.entities.usuarios.Login;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataLogin {
    
    private static List<Login> logins = new ArrayList<>();
    public static List<EntidadPersistente> getList() {
    
        if (logins.size() == 0) {
            
            Login admin = new Login();
            admin.setUsername("admin");
            admin.setPassword("123456");

            Login voluntario = new Login();
            voluntario.setUsername("voluntario");
            voluntario.setPassword("123456");

            Login usuario = new Login();
            usuario.setUsername("usuario");
            usuario.setPassword("123456");

            addAll(admin, voluntario, usuario);
        }
        return (List<EntidadPersistente>)(List<?>) logins;
    }

    private static void addAll(Login ... logins) {
        Collections.addAll(DataLogin.logins, logins);
    }
}
