package domain.entities.organizaciones.Configuraciones;

import javax.persistence.*;

@Entity
@Table(name = "tamanio_imagen")
public class TamanioImagen {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private int ancho;

    @Column
    private int alto;

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public TamanioImagen() {
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
