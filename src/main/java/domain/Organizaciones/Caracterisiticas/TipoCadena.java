package domain.Organizaciones.Caracterisiticas;

import domain.Organizaciones.Caracterisiticas.InterfazValor;

public class TipoCadena implements InterfazValor {
    String valor;

    @Override
    public void notificar() {

    }

    public TipoCadena(String valor) {
        this.valor = valor;
    }
}
