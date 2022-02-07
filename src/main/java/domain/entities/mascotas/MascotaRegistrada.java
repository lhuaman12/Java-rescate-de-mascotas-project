package domain.entities.mascotas;

import domain.entities.usuarios.Usuario;
import domain.entities.utils.QR.QR;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@DiscriminatorValue("registrada")
public class MascotaRegistrada extends Mascota {

    @Column
    private String nombre;

    @Column
    private String apodo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "duenio_id", referencedColumnName = "id")
    private Usuario duenio;

    @Column
    private Boolean estaCastrado;

    @OneToMany(mappedBy = "mascotaRegistrada",cascade = {CascadeType.ALL})
    private List<CaracteristicasONG> caracteristicas;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "qr_id")
    private QR qrMascota;

    // Constructor
    public MascotaRegistrada() {
        this.caracteristicas = new ArrayList<>();
    }


    // Getters and Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public List<CaracteristicasONG> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<CaracteristicasONG> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Usuario getDuenio() {
        return duenio;
    }

    public void setDuenio(Usuario duenio) {
        this.duenio = duenio;
    }

    public void setEstaCastrado(Boolean estaCastrado) {
        this.estaCastrado = estaCastrado;
    }

    public Boolean getEstaCastrado() {
        return estaCastrado;
    }

    public QR getQrMascota() {
        return qrMascota;
    }

    public void setQrMascota(QR qrMascota) {
        this.qrMascota = qrMascota;
    }
}


