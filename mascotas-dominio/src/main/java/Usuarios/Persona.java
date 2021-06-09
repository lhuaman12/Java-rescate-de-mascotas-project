package Usuarios;

import InstanciadorCuentas.InterfazValidacion;

import java.util.Date;
import java.util.Map;

public abstract class Persona implements ImplementacionUser{

    protected Cuenta cuenta;

    public Persona getPersona(){
        return this;
    }

    @Override
    public void crearPerfil(Cuenta cuenta) {
        this.cuenta=cuenta;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }
}
