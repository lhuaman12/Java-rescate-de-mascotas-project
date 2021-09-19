package domain.entities.Organizaciones;

import javax.persistence.*;

@Entity
@Table(name = "estandar_fotos")
public class EstandarFotos {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private int ancho;      // Pixels
    @Column
    private int alto;       // Pixels
    @Transient
    private Calidad calidad;


    // Constructor
    public EstandarFotos(int ancho,
                         int alto,
                         Calidad calidad) {

        this.ancho = ancho;
        this.alto = alto;
        this.calidad = calidad;
    }


    // Getters and Setters

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

    public Calidad getCalidad() {
        return calidad;
    }

    public void setCalidad(Calidad calidad) {
        this.calidad = calidad;
    }

    //
}
