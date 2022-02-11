package domain.entities.usuarios;

import domain.entities.mascotas.MascotaRegistrada;
import domain.entities.utils.notificador.notificables.Notificable;

import javax.persistence.Transient;
import java.time.LocalDate;

public class MensajeMascotaPerdida implements Notificable {

    public Contacto contacto;

    public MascotaRegistrada mascota;

    public Usuario rescatista;

    public LocalDate fechaDeEnvio;

    public String estadoDeLaMascota;

    public MensajeMascotaPerdida() {
    }


    @Override
    public String mensaje() {

        String body =
                "Hola " + contacto.getNombre()+ " " + contacto.getApellido()+"\n"+
                "La mascota "+mascota.getNombre()+" ha sido encontrada\n" +"Comuniquese con el rescatista para arreglar un encuentro!\n"+
                "Persona que encontro a la mascota:\n"+
                "Nombre:"+rescatista.getNombre()+"\n"+
                "Apellido:" + rescatista.getApellido()+"\n"+
                "Estado en que la encontro:"+ estadoDeLaMascota+"\n"
                + "Telefono:" + rescatista.getContactos().get(0).getTelefono()+"\n"
                + "Email:" + rescatista.getContactos().get(0).getTelefono()+"\n"
                + "Medio preferido de contacto" + rescatista.getContactos().get(0).getMedioDeNotificacion().toString();

        /*
        for(Contacto contacto: rescatista.getContactos()){
            body.concat(contacto.getDatos());
            body = body + "\n";
        }
         */

        return body;
    }

    @Override
    public String medio() {
        return null;
    }

    @Override
    public String destinatario() {
        return contacto.getEmail();
    }

    //// getters and setters
    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public MascotaRegistrada getMascota() {
        return mascota;
    }

    public void setMascota(MascotaRegistrada mascota) {
        this.mascota = mascota;
    }

    public Usuario getRescatista() {
        return rescatista;
    }

    public void setRescatista(Usuario rescatista) {
        this.rescatista = rescatista;
    }

    public LocalDate getFechaDeEnvio() {
        return fechaDeEnvio;
    }

    public void setFechaDeEnvio(LocalDate fechaDeEnvio) {
        this.fechaDeEnvio = fechaDeEnvio;
    }

    public void setEstadoDeLaMascota(String estadoDeLaMascota) {
        this.estadoDeLaMascota = estadoDeLaMascota;
    }

    public String getEstadoDeLaMascota() {
        return estadoDeLaMascota;
    }


}
