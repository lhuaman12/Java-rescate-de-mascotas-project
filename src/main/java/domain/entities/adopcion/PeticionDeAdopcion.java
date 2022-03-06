package domain.entities.adopcion;

import domain.entities.mascotas.MascotaEnAdopcion;
import domain.entities.usuarios.Usuario;

import javax.persistence.*;

@Entity
@Table(name="peticion_de_adopcion")
public class PeticionDeAdopcion {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mascota_preferida_id")
    private MascotaEnAdopcion mascotaPreferida;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "peticion_usuario_id")
    private Usuario usuario;

    //TODO: agregar comodidades como pregutnas de plataforma
    //private List<Comodidad> comodidades;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MascotaEnAdopcion getMascotaPreferida() {
        return mascotaPreferida;
    }

    public void setMascotaPreferida(MascotaEnAdopcion mascotaPreferida) {
        this.mascotaPreferida = mascotaPreferida;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
