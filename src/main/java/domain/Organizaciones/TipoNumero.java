package domain.Organizaciones;

public class TipoNumero extends Caracterisitica{
    private Integer valor;

    public TipoNumero() {
        super.agregarDatosCaracteristica(categoria,tipoCaract);
    }

    public void setearValor(Integer val) {
        this.valor=val;
    }

}
