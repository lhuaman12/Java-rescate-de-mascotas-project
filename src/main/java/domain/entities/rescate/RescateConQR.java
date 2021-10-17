package domain.entities.rescate;

import domain.entities.mascotas.MascotaRegistrada;
import domain.entities.organizaciones.Organizacion;
import domain.entities.usuarios.Usuario;

import javax.persistence.*;

@Entity
@DiscriminatorValue("con_qr")
public class RescateConQR extends Rescate {

    @Transient
    private MascotaRegistrada mascotaRegistrada;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "duenio_id")
    private Usuario duenio;


    // Constructor
    public RescateConQR() {}


    // Getters and Setters

    public MascotaRegistrada getMascotaRegistrada() {
        return mascotaRegistrada;
    }

    public void setMascotaRegistrada(MascotaRegistrada mascotaRegistrada) {
        this.mascotaRegistrada = mascotaRegistrada;
    }


    public Usuario getDuenio() {
        return duenio;
    }

    public void setDuenio(Usuario duenio) {
        this.duenio = duenio;
    }
}
