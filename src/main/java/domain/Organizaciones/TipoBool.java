package Organizaciones;

public class TipoBool extends Caracterisitica{
    private Boolean valor;

    public TipoBool() {
        super.agregarDatosCaracteristica(categoria,tipoCaract);

    }


    public void setearValor(Boolean val) {
        this.valor=val;
    }
}
