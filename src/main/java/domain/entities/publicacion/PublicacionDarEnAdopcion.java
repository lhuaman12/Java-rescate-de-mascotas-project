package domain.entities.publicacion;

import domain.entities.adopcion.Adopcion;
import domain.entities.organizaciones.Organizacion;

import javax.persistence.*;

@Entity
@DiscriminatorValue("dar_en_adopcion")
public class PublicacionDarEnAdopcion extends Publicacion{

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adopcion_id")
    private Adopcion adopcion;

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

}
