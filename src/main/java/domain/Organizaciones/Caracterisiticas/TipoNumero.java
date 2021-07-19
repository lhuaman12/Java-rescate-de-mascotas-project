package domain.Organizaciones.Caracterisiticas;

import domain.Organizaciones.Caracterisiticas.InterfazValor;

public class TipoNumero implements InterfazValor {
    Integer valor;

    @Override
    public void notificar() {

    }

    public TipoNumero(Integer valor) {
        this.valor = valor;
    }
}
