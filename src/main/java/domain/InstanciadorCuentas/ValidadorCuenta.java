package domain.InstanciadorCuentas;

import domain.Usuarios.Cuenta;

import java.io.IOException;

public class ValidadorCuenta implements InterfazValidacion{
   // InterfazValidacion interfaz;
    private static ValidadorCuenta validadorCuenta;
    private ValidadorUser v_user;
    private ValidadorPass v_pass;

    private ValidadorCuenta() { }

    public static ValidadorCuenta getValidadorCuenta() {
        if(validadorCuenta==null){
            validadorCuenta= new ValidadorCuenta();
        }
        return validadorCuenta;
    }
    public ValidadorCuenta setValidadores(ValidadorUser validadorUser, ValidadorPass validadorPass) {
        this.v_user=validadorUser;
        this.v_pass=validadorPass;
        return validadorCuenta;
    }

    @Override
    public Boolean validarDatosCuenta(String user, String pass) throws IOException {
        Boolean validUser,validPass;

        validUser=v_user.validarUsuario(user);
        validPass=v_pass.validarPassword(pass);

        return (validUser && validPass);

    }

}
