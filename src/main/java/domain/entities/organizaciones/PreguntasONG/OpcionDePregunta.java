package domain.entities.organizaciones.PreguntasONG;

import javax.persistence.*;

@Entity
@Table(name = "opcion_de_pregunta")
public class OpcionDePregunta {

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

    public Atributo getAtributo() {
        return atributo;
    }

    public void setAtributo(Atributo atributo) {
        this.atributo = atributo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
