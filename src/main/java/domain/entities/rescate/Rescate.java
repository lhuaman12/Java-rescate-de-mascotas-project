package domain.entities.rescate;

import domain.entities.mascotas.MascotaPerdida;
import domain.entities.usuarios.Contacto;
import domain.entities.usuarios.MensajeMascotaPerdida;
import domain.entities.usuarios.Usuario;
import domain.entities.utils.notificador.notificables.Mensaje;

public class Rescate {
    private Usuario duenio;
    private MascotaPerdida mascotaPerdida;
    private EstadoMascotaPerdida estadoMascota = EstadoMascotaPerdida.CON_RESCATISTA;
    private Usuario rescatista=null;

    public void avisarMascotaEncontrada(Contacto contacto){ // del rescatista al duenio
        //MensajeMascotaPerdida mensaje = new MensajeMascotaPerdida(duenio,);
    }
    public Usuario buscarDuenio(){
        return null;
    }
    public void avisarRescatistaPublicacion(){ // cuando alguien responde a la publicacion del rescatista

    }
}
