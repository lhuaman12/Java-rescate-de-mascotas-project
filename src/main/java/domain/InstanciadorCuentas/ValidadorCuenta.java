package InstanciadorCuentas;

import Usuarios.Cuenta;

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

    /* public ValidadorCuenta(InterfazValidacion interfaz, ValidadorUser v_user, ValidadorPass v_pass) {
        this.interfaz = interfaz;
        this.v_user = v_user;
        this.v_pass = v_pass;
    }*/

    @Override
    public Boolean validarDatosCuenta(String user, String pass) {
        Boolean validUser,validPass;

        validUser=v_user.validarUsuario(user);
        validPass=v_pass.validarPassword(pass);

        return (validUser && validPass);

    }

}
