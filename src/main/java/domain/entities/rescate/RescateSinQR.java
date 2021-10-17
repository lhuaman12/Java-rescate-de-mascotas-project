package domain.entities.rescate;

import domain.entities.mascotas.MascotaPerdida;
import domain.entities.usuarios.Usuario;

import javax.persistence.*;

@Entity
@DiscriminatorValue("sin_qr")
public class RescateSinQR extends Rescate {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "duenio_id")
    private Usuario duenio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mascota_id")
    private MascotaPerdida mascotaPerdida;

    // Constructor
    public RescateSinQR() {}


    // Getters and Setters

    public Usuario getDuenio() {
        return duenio;
    }

    public void setDuenio(Usuario duenio) {
        this.duenio = duenio;
    }

    public MascotaPerdida getMascotaPerdida() {
        return mascotaPerdida;
    }

    public void setMascotaPerdida(MascotaPerdida mascotaPerdida) {
        this.mascotaPerdida = mascotaPerdida;
    }
}
