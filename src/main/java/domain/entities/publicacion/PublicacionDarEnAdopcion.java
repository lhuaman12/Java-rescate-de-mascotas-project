package domain.entities.publicacion;

import domain.entities.adopcion.Adopcion;
import domain.entities.organizaciones.Organizacion;

import javax.persistence.*;

@Entity
@DiscriminatorValue("adopcion")
public class PublicacionDeAdopcion extends Publicacion{

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adopcion_id")
    private Adopcion adopcion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organizacion_id", referencedColumnName = "id")
    private Organizacion organizacion;

    // Lista de personas que estan en la lista para adoptar??

    @Override
    public void generarTitulo() {

    }

    @Override
    public void generarContenido() {

    }


    public Adopcion getAdopcion() {
        return adopcion;
    }

    public void setAdopcion(Adopcion adopcion) {
        this.adopcion = adopcion;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }
}
