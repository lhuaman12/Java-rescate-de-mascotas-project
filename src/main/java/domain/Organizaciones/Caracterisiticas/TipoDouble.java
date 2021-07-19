package domain.Organizaciones.Caracterisiticas;

import domain.Organizaciones.Caracterisiticas.InterfazValor;

public class TipoDouble implements InterfazValor {
    Double valor;

    @Override
    public void notificar() {

    }

    public TipoDouble(Double valor) {
        this.valor = valor;
    }

}
