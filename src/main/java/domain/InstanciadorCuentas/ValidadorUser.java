package domain.InstanciadorCuentas;

import domain.Plataforma.Plataforma;

public class ValidadorUser {
    private static ValidadorUser validadorUser;
    Plataforma p = Plataforma.getPlataforma();
    private ValidadorUser() {}

    public static ValidadorUser getValidadorUser(){
        if(validadorUser==null){
            validadorUser= new ValidadorUser();
        }
        return validadorUser;
    }

    public Boolean validarUsuario(String user) {
        if(!p.userExists(user)){
            return true;
        }else{
            return false;
        }
    }
}
