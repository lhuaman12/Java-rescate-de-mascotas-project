package domain.Organizaciones.Caracterisiticas;

import domain.Organizaciones.Caracterisiticas.InterfazValor;

public class TipoBool implements InterfazValor {
    Boolean valor;

    @Override
    public void notificar() {

    }

    public TipoBool(Boolean valor) {
        this.valor = valor;
    }

}
