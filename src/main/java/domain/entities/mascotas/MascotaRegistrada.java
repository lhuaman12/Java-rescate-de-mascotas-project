package domain.entities.mascotas;

import domain.entities.usuarios.Usuario;

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
    private String tokenRescate;

    @Transient
    private List<CaracteristicasONG> caracteristicas;


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

    public String getTokenRescate() {
        return tokenRescate;
    }

    public void setTokenRescate(String tokenRescate) {
        this.tokenRescate = tokenRescate;
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
}


