package domain.entities.mascotas;

import javax.imageio.ImageIO;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class FotoMascota {

    private int id;

    private String ruta;

    private int ancho;

    private int alto;

    public Boolean getEsRutaLocal() {
        return esRutaLocal;
    }

    public void setEsRutaLocal(Boolean esRutaLocal) {
        this.esRutaLocal = esRutaLocal;
    }
    public byte[] traerBytes(){
        if(esRutaLocal==true){
            try {
                BufferedImage foto = ImageIO.read(new File(this.getRuta()));
                ByteArrayOutputStream fotoBytesBuffer = new ByteArrayOutputStream();
                ImageIO.write(foto, "jpg", fotoBytesBuffer);
                return fotoBytesBuffer.toByteArray();
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }

        }
        return null;
    }

    Boolean esRutaLocal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }
}
