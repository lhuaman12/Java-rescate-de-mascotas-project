package domain.InstanciadorCuentas;

import domain.Usuarios.Cuenta;

public interface InterfazValidacion {
    Boolean validarDatosCuenta(String user, String pass);

}
