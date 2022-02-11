package domain.entities.publicaciones;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("adopcion")
public class PublicacionDeAdopcion extends Publicacion{


    @Override
    public void generarTitulo() {

    }

    @Override
    void generarContenido() {

    }
}
