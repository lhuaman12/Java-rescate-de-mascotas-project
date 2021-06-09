package InstanciadorCuentas;

import Plataforma.Plataforma;
import Usuarios.Cuenta;
import Usuarios.ImplementacionUser;

public class InstanciadorCuenta {
    private static InstanciadorCuenta instanciadorCuenta;
    private InterfazValidacion interfazValidacion;
    private Plataforma plataforma;
    private ImplementacionUser usuario;


    private InstanciadorCuenta() { }
    public static InstanciadorCuenta getInstanciadorCuenta(){
        if(instanciadorCuenta==null){
            instanciadorCuenta= new InstanciadorCuenta();
        }
        return instanciadorCuenta;
    }
    public InstanciadorCuenta setConfiguraciones(Plataforma plataforma, InterfazValidacion interfazValidacion) {
        this.plataforma=plataforma;
        this.interfazValidacion=interfazValidacion;
        return instanciadorCuenta;
    }
    
    public Boolean validarCreacionCuenta(String user, String pass){
        return this.interfazValidacion.validarDatosCuenta(user,pass);
    }

    public void crearCuenta(String user,String pass,ImplementacionUser usuario){
        Boolean validCuenta = this.validarCreacionCuenta(user,pass);
        if(validCuenta==true){
            Cuenta cuentaPreliminar = new Cuenta(user,pass);
            usuario.crearPerfil(cuentaPreliminar);
            this.plataforma.addCuenta(cuentaPreliminar);
        }else{
            System.out.println("Error en la creacion de usuario. Intente más tarde");
        }
        
    }
}