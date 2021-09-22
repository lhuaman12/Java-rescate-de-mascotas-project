package domain.entities.organizaciones.Configuraciones;

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
    private domain.entities.organizaciones.CalidadImagen calidadImagen;


    // Constructor
    public EstandarFotos(int ancho,
                         int alto,
                         domain.entities.organizaciones.CalidadImagen calidadImagen) {

        this.ancho = ancho;
        this.alto = alto;
        this.calidadImagen = calidadImagen;
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

    public domain.entities.organizaciones.CalidadImagen getCalidad() {
        return calidadImagen;
    }

    public void setCalidad(CalidadImagen calidadImagen) {
        this.calidadImagen = calidadImagen;
    }

    //
}
