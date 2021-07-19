package domain.GestorMascotasPerdidas;

import com.twilio.twiml.voice.Prompt;
import domain.Plataforma.Plataforma;
import domain.Usuarios.Contacto;
import domain.Usuarios.Dueño;
import notificador.notificables.Mensaje;

import java.util.List;

public class NotificadorMascotaPerdida implements RescatistaServices{

    private Plataforma plataforma;

    public NotificadorMascotaPerdida(){
    }

    public NotificadorMascotaPerdida plataforma(Plataforma plataforma){
        this.plataforma=plataforma;
        return this;
    }

    //TODO
    public Mensaje getMensajeFormulario(FormularioMascotaPerdida formularioMascotaPerdida){
        return null;
    }

    //TODO
    @Override
    public void notificarMascotaPerdida(FormularioMascotaPerdida formularioMascotaPerdida, String token) {
        Dueño dueñoMascota= this.getDuenioMascotaPerdida(token);
        dueñoMascota
                .getContactos()
                .stream()
                .forEach(c -> notificarContacto(c,getMensajeFormulario(formularioMascotaPerdida)));


    }
    public Dueño getDuenioMascotaPerdida(String token){
        return this.plataforma.getDuenioByToken(token);
    }

    public void notificarContacto(Contacto contacto, Mensaje mensaje){

    }

}
