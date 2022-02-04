package domain.entities.mascotas;

import javax.imageio.ImageIO;
import javax.persistence.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@Entity
@Table(name = "foto_mascota")
public class foto_mascota {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String ruta;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mascota_id", referencedColumnName = "id")
    private Mascota mascota;

    @Column
    private int ancho;

    @Column
    private int alto;

    @Column
    private Boolean esRutaLocal;


    // Constructor
    public foto_mascota() {}


    // Getters and Setters


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

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
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
    public void guardarFoto(MascotaRegistrada mascota,Byte[] fotoBytes){
        final String URL = "src/main/resources/mascotas_info/";
        String customPath = URL + "mascota_" + mascota.getId() + "/fotos";

        this.setRuta(customPath);
    }

}
