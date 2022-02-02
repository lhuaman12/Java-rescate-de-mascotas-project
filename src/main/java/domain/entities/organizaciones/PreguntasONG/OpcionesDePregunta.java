package domain.entities.organizaciones.PreguntasONG;

import javax.persistence.*;

@Entity
@Table(name = "opciones_de_pregunta")
public class OpcionesDePregunta {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String nombreOpcion;

    @ManyToOne
    @JoinColumn(name = "atributo_id", referencedColumnName = "id")
    Atributo atributo;

    public String getNombreOpcion() {
        return nombreOpcion;
    }

    public void setNombreOpcion(String nombreOpcion) {
        this.nombreOpcion = nombreOpcion;
    }

}
