package domain.entities.publicacion;

import domain.entities.mascotas.MascotaPerdida;
import domain.entities.organizaciones.Organizacion;
import domain.entities.rescate.Rescate;

import javax.persistence.*;

@Entity
@DiscriminatorValue("rescate")
public class PublicacionRescate extends Publicacion {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rescate_id")
    private Rescate rescate;


    @Override
    public void generarTitulo() {
        MascotaPerdida mascotaPerdida = getRescate().getMascotaPerdida();
        String titulo = "Se perdio un "+ mascotaPerdida.getTipoMascota()+" "+ mascotaPerdida.getSexo();
                //"por " + rescate.getDomicilio().getMunicipio().getNombre();  TODO: necesito una API que traduzca coordenadas a direcciones
        setTitulo(titulo);
    }

    @Override
    public void generarContenido() {
        MascotaPerdida mascotaPerdida = getRescate().getMascotaPerdida();
        String body = "La mascota fue vista por " + //rescate.getDomicilio().getCalle() + " " + rescate.getDomicilio().getAltura()+ TODO: necesito una API que traduzca coordenadas a direcciones
                "Es " + mascotaPerdida.getTamanioMascota() + "y tiene aproximadamente " + mascotaPerdida.getEdadAproximada();
        setContenido(body);
    }
    /* El contenido se genera en el back-end y no en el motor de plantillas (por ej pasandole la mascota y rescatista)
     ya que si un voluntario o administrador quiere modificar el contenido solo debe modificar la publicacion
     como un CRUD
     */

    public Rescate getRescate() {
        return rescate;
    }

    public void setRescate(Rescate rescate) {
        this.rescate = rescate;
    }
    /*
    public Organizacion getOrganizacion() {
        return organizacion;
    }

    //public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

     */
}
