package domain.InstanciadorCuentas;

public class ValidadorPass {
    private static ValidadorPass validadorPass;
    private ValidadorPass() {}
    public static ValidadorPass getValidadorPass(){
        if(validadorPass==null){
            validadorPass=new ValidadorPass();
        }
        return validadorPass;
    }

    public Boolean validarPassword(String pass) {
        return validadorPass.esSegura(pass);
    }

    private boolean esSegura(String pass) {
        return !pass.contains("X");
    }
}
