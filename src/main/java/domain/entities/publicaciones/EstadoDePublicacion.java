package domain.entities.publicaciones;

import domain.entities.usuarios.Usuario;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="estado_de_publicacion")
public class EstadoDePublicacion {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    @JoinColumn(name = "voluntario_id", referencedColumnName = "id")
    private Usuario voluntarioResponsable;

    @Transient //TODO:timestamp
    private LocalDate fechaDeCambio;

    @Enumerated(EnumType.STRING)
    private EstadoPosible estadoPosible;


    @ManyToOne
    @JoinColumn(name="publicacion_id" ,referencedColumnName = "id")
    private Publicacion publicacion;


    public EstadoDePublicacion() {
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }
}
