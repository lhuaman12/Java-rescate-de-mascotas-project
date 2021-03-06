package domain.entities.usuarios;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notificacion")
public class Notificacion {

    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    private MedioDeNotificacion medioDeNotificacion;

    @Column(columnDefinition = "DATE")
    private Date fechaHora;     // Timestamp?

    @Column
    private String tipoMensaje;

    @Column     // ToDo Text
    private String mensaje;


    // Constructor
    public Notificacion(MedioDeNotificacion medioDeNotificacion,
                        Date fechaHora,
                        String tipoMensaje,
                        String mensaje) {

        this.medioDeNotificacion = medioDeNotificacion;
        this.fechaHora = fechaHora;
        this.tipoMensaje = tipoMensaje;
        this.mensaje = mensaje;
    }


    // Getters and Setters

    public MedioDeNotificacion getMedioDeNotificacion() {
        return medioDeNotificacion;
    }

    public void setMedioDeNotificacion(MedioDeNotificacion medioDeNotificacion) {
        this.medioDeNotificacion = medioDeNotificacion;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(String tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    //


}

