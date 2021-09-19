package domain.entities.Organizaciones.Caracterisiticas;

public class TipoNumero implements InterfazValor {
    Integer valor;

    @Override
    public void notificar() {

    }

    public TipoNumero(Integer valor) {
        this.valor = valor;
    }
}
