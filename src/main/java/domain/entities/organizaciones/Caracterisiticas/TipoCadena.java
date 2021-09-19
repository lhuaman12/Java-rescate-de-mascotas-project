package domain.entities.Organizaciones.Caracterisiticas;

public class TipoCadena implements InterfazValor {
    String valor;

    @Override
    public void notificar() {

    }

    public TipoCadena(String valor) {
        this.valor = valor;
    }
}
