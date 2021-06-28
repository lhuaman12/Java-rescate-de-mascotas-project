package domain.InstanciadorCuentas;
import password.PasswordCriteria;
import password.PasswordMain;
import password.ValidatePassword;

import java.io.IOException;

public class ValidadorPass{
    private static ValidadorPass validadorPass;
    private ValidatePassword validador;
    private ValidadorPass() {
    }

    public void setValidador(ValidatePassword validador) {
        this.validador = validador;
    }

    public static ValidadorPass getValidadorPass(){
        if(validadorPass==null){
            validadorPass=new ValidadorPass();
        }
        return validadorPass;
    }

    public Boolean validarPassword(String pass){
        return validadorPass.validador.validatePassword(pass);
    }

    private boolean esSegura(String pass) {
        return !pass.contains("X");
    }

}
