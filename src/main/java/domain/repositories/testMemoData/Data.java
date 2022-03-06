package domain.repositories.testMemoData;

import domain.entities.EntidadPersistente;
import domain.entities.usuarios.Login;
import domain.entities.usuarios.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<EntidadPersistente> getData(Class type){
        List<EntidadPersistente> entidades = new ArrayList<>();

        if(type.getName().equals(Login.class.getName())){
            entidades = DataLogin.getList();
        }
/*        else{
            if(type.getName().equals(Usuario.class.getName())){
                entidades = DataUsuario.getList();
            }
        }*/
        return entidades;
    }
}
