package domain.entities.Organizaciones.Caracterisiticas;

public class TipoDouble implements InterfazValor {
    Double valor;

    @Override
    public void notificar() {

    }

    public TipoDouble(Double valor) {
        this.valor = valor;
    }

}
