package domain.Organizaciones;

import domain.Mascotas.Calidad;

import javax.persistence.*;

@Entity
@Table(name = "estandar_fotos")
public class EstandarFotos {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private int pixelesHorizontal;
    @Column
    private int pixelesVertical;
    @Transient
    private Calidad calidad;


    // Constructor
    public EstandarFotos(int pixelesHorizontal,
                         int pixelesVertical,
                         Calidad calidad) {

        this.pixelesHorizontal = pixelesHorizontal;
        this.pixelesVertical = pixelesVertical;
        this.calidad = calidad;
    }

    public int getPixelesHorizontal() {
        return pixelesHorizontal;
    }

    public void setPixelesHorizontal(int pixelesHorizontal) {
        this.pixelesHorizontal = pixelesHorizontal;
    }

    public int getPixelesVertical() {
        return pixelesVertical;
    }

    public void setPixelesVertical(int pixelesVertical) {
        this.pixelesVertical = pixelesVertical;
    }

    public Calidad getCalidad() {
        return calidad;
    }

    public void setCalidad(Calidad calidad) {
        this.calidad = calidad;
    }
}
