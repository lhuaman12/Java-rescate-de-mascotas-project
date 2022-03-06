package domain.entities.publicacion;

import domain.entities.adopcion.Adopcion;
import domain.entities.adopcion.PeticionDeAdopcion;

import javax.persistence.*;

@Entity
@DiscriminatorValue("intencion_adopcion")

public class PublicacionIntencionAdopcion  extends Publicacion{

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "peticion_adopcion_id")
    private PeticionDeAdopcion peticionDeAdopcion;

    @Override
    public void generarTitulo() {

    }

    @Override
    void generarContenido() {

    }

    public PeticionDeAdopcion getPeticionDeAdopcion() {
        return peticionDeAdopcion;
    }

    public void setPeticionDeAdopcion(PeticionDeAdopcion peticionDeAdopcion) {
        this.peticionDeAdopcion = peticionDeAdopcion;
    }
}
