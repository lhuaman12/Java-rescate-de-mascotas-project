package Organizaciones;

public abstract class Caracterisitica {
    protected Categoria categoria;
    protected TipoCaract tipoCaract;

    public void agregarDatosCaracteristica(Categoria categoria, TipoCaract tipoCaract){
        this.categoria=categoria;
        this.tipoCaract=tipoCaract;
    }


}

