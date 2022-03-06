package domain.entities.adopcion;

import domain.entities.mascotas.MascotaEnAdopcion;
import domain.entities.usuarios.Usuario;

import javax.persistence.*;

@Entity
@Table(name = "adopcion")
public class Adopcion {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    @JoinColumn(name = "mascota_en_adopcion_id")
    private MascotaEnAdopcion mascota;

    @OneToOne
    @JoinColumn(name = "duenio_de_adopcion_id")
    private Usuario duenioDeAdopcion;

    public MascotaEnAdopcion getMascota() {
        return mascota;
    }

    public void setMascota(MascotaEnAdopcion mascota) {
        this.mascota = mascota;
    }

    public Usuario getDuenioDeAdopcion() {
        return duenioDeAdopcion;
    }

    public void setDuenioDeAdopcion(Usuario duenioDeAdopcion) {
        this.duenioDeAdopcion = duenioDeAdopcion;
    }

}
