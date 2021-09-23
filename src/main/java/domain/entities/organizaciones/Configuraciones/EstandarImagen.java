package domain.entities.organizaciones.Configuraciones;


public class EstandarImagen {
    CalidadImagen calidadImagen;
    TamanioImagen tamanioImagen;

    public EstandarImagen(CalidadImagen calidadImagen, TamanioImagen tamanioImagen) {
        this.calidadImagen = calidadImagen;
        this.tamanioImagen = tamanioImagen;
    }

    public CalidadImagen getCalidadImagen() {
        return calidadImagen;
    }

    public void setCalidadImagen(CalidadImagen calidadImagen) {
        this.calidadImagen = calidadImagen;
    }

    public TamanioImagen getTamanioImagen() {
        return tamanioImagen;
    }

    public void setTamanioImagen(TamanioImagen tamanioImagen) {
        this.tamanioImagen = tamanioImagen;
    }
}
