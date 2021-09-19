package domain.entities.Organizaciones.Caracterisiticas;

public class TipoBool implements InterfazValor {
    Boolean valor;

    @Override
    public void notificar() {

    }

    public TipoBool(Boolean valor) {
        this.valor = valor;
    }

}
