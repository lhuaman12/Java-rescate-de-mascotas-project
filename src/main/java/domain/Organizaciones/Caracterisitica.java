package domain.Organizaciones;

public abstract class Caracterisitica {
    protected Categoria categoria;
    protected TipoCaract tipoCaract;

    public void agregarDatosCaracteristica(Categoria categoria, TipoCaract tipoCaract){
        this.categoria=categoria;
        this.tipoCaract=tipoCaract;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public TipoCaract getTipoCaract() {
        return tipoCaract;
    }

    public boolean existenAtributos(Categoria cat, TipoCaract tipo){
       return (this.getCategoria()==cat) && (this.getTipoCaract()==tipo);
    }
}

