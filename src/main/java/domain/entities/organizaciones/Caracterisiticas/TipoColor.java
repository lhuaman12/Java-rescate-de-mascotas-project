package domain.entities.Organizaciones.Caracterisiticas;

public class TipoColor implements InterfazValor {
    Color valor;

    @Override
    public void notificar() {

    }

    public TipoColor(Color valor) {
        this.valor = valor;
    }
}
