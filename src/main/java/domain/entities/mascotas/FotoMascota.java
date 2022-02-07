package domain.entities.mascotas;

import javax.imageio.ImageIO;
import javax.persistence.*;
import java.awt.image.BufferedImage;
import java.io.*;

@Entity
@Table(name = "foto_mascota")
public class FotoMascota {

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
    public FotoMascota() {}

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

    public byte[] traerBytesDesdePath(){

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
    public void guardarFoto(MascotaRegistrada mascota,byte[] fotoBytes,Integer numeroDeFoto) throws IOException {

        String pathMascota = "src/main/resources/mascotas_info/" + "mascota_" + String.valueOf(mascota.getId());
        File file1 = new File(pathMascota);
        file1.mkdir();

        String pathFotosDeMascotas = pathMascota + "/fotos";
        File file2 = new File(pathFotosDeMascotas);
        file2.mkdir();

        String pathFotosDeLaMascota = pathFotosDeMascotas +"/foto_" +String.valueOf(numeroDeFoto)+".jpg";

        InputStream is = new ByteArrayInputStream(fotoBytes);
        BufferedImage newBi = ImageIO.read(is);
        ImageIO.write(newBi, "jpg", new File(pathFotosDeLaMascota));

        this.setRuta(pathFotosDeLaMascota);
    }

}
