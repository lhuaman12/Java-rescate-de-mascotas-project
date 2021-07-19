package domain.Organizaciones.Caracterisiticas;

import domain.Organizaciones.Caracterisiticas.Color;
import domain.Organizaciones.Caracterisiticas.InterfazValor;

public class TipoColor implements InterfazValor {
    Color valor;

    @Override
    public void notificar() {

    }

    public TipoColor(Color valor) {
        this.valor = valor;
    }
}
