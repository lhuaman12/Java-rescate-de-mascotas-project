package domain.GestorMascotasPerdidas;

import domain.Plataforma.Plataforma;
import domain.Usuarios.Contacto;
import domain.Usuarios.Duenio;
import notificador.notificables.Mensaje;

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
        Duenio duenioMascota = this.getDuenioMascotaPerdida(token);
        duenioMascota
                .getContactos()
                .stream()
                .forEach(c -> notificarContacto(c,getMensajeFormulario(formularioMascotaPerdida)));


    }
    public Duenio getDuenioMascotaPerdida(String token){
        return this.plataforma.getDuenioByToken(token);
    }

    public void notificarContacto(Contacto contacto, Mensaje mensaje){

    }

}
