package domain.entities.mascotas;

import javax.persistence.*;

@Entity
@Table(name = "caracteristica_ong")
public class CaracteristicasONG {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private String nombreCaracteristica;
    @Column
    private String respuesta;

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

}
