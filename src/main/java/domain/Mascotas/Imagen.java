package domain.Mascotas;


import domain.Organizaciones.Configuraciones.TamanioImagen;

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
