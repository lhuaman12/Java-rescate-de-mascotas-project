package domain.entities.usuarios;

import domain.entities.mascotas.MascotaRegistrada;
import domain.entities.utils.notificador.notificables.Notificable;

import java.time.LocalDate;

public class MensajeMascotaPerdida implements Notificable {
    //public Usuario duenio;
    public Contacto contacto;
    public MascotaRegistrada mascota;
    public Usuario rescatista;
    public LocalDate fechaDeEnvio;

    public MensajeMascotaPerdida(Contacto contacto, MascotaRegistrada mascota, Usuario rescatista) {
        this.contacto = contacto;
        this.mascota = mascota;
        this.rescatista = rescatista;
    }


    @Override
    public String mensaje() {

        String body = new String();

        body = "Hola " + contacto.getNombre()+ " " + contacto.getApellido()+"\n"+
                "La mascota"+mascota.getNombre()+" ha sido encontrada\n"+"Comuniquese con el rescatista para arreglar un encuentro!\n Informacion:"+
                "Persona que encontro a la mascota:"+
                "Nombre:"+rescatista.getNombre()+
                "Apellido:" + rescatista.getApellido()+"\n";


        for(Contacto contacto: rescatista.getContactos()){
            body.concat(contacto.getDatos());
            body = body + "\n";
        }

        return body;
    }

    @Override
    public String medio() {
        return null;
    }

    @Override
    public String destinatario() {
        String destinatario;
        switch(contacto.getMediosDeNotificacion()){
            case EMAIL: destinatario= contacto.getEmail();break;
            case SMS: destinatario=contacto.getTelefono();break;
            case WHATSAPP: destinatario= contacto.getTelefono();break;
            default: destinatario=null;
        }
        return destinatario;
    }
}
