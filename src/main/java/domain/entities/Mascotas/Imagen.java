package domain.entities.Mascotas;


import domain.entities.Organizaciones.Configuraciones.TamanioImagen;

public class Imagen {
    public byte[] datosImagen;
    private TamanioImagen tamanio;

    public Imagen(byte[] datosImagen, TamanioImagen tamanio) {
        this.datosImagen = datosImagen;
        this.tamanio = tamanio;
    }

    public byte[] getDatosImagen() {
        return this.datosImagen;
    }

    public TamanioImagen getTamanio() {
        return this.tamanio;
    }
}
