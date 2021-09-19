package domain.entities.Organizaciones.Configuraciones;


public class ConfiguracionImagen {
    CalidadImagen calidadImagen;
    TamanioImagen tamanioImagen;

    public ConfiguracionImagen(CalidadImagen calidadImagen, TamanioImagen tamanioImagen) {
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
