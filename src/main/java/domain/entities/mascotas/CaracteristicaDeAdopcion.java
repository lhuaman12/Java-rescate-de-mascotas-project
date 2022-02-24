package domain.entities.mascotas;

import javax.persistence.*;

@Entity
@Table(name = "caracteristica_adopcion")
public class CaracteristicaDeAdopcion {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String nombreCaracteristica;

    @Column
    private String respuesta;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mascota_id", referencedColumnName = "id")
    private MascotaEnAdopcion mascotaEnAdopcion;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public MascotaEnAdopcion getMascotaEnAdopcion() {
        return mascotaEnAdopcion;
    }

    public void setMascotaEnAdopcion(MascotaEnAdopcion mascotaEnAdopcion) {
        this.mascotaEnAdopcion = mascotaEnAdopcion;
    }
}
