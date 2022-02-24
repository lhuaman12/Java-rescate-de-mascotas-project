package domain.entities.mascotas;

import javax.persistence.*;

@Entity
@Table(name = "caracteristica_registro_mascota")
public class CaracteristicasRegistroDeMascota {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private String nombreCaracteristica;
    @Column
    private String respuesta;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mascota_id", referencedColumnName = "id")
    private MascotaRegistrada mascotaRegistrada;

    public String getNombreCaracteristica() {
        return nombreCaracteristica;
    }

    public void setNombreCaracteristica(String nombreCaracteristica) {
        this.nombreCaracteristica = nombreCaracteristica;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MascotaRegistrada getMascotaRegistrada() {
        return mascotaRegistrada;
    }

    public void setMascotaRegistrada(MascotaRegistrada mascotaRegistrada) {
        this.mascotaRegistrada = mascotaRegistrada;
    }

}
