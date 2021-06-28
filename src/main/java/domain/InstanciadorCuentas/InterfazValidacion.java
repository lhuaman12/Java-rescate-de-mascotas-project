package domain.InstanciadorCuentas;

import domain.Usuarios.Cuenta;

import java.io.IOException;

public interface InterfazValidacion {
    Boolean validarDatosCuenta(String user, String pass) throws IOException;

}
