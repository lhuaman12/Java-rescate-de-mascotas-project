package notificador.notificador;

import notificador.estrategias.EstrategiaDeNotificacion;
import notificador.notificables.Notificable;

public class Notificador {

    private EstrategiaDeNotificacion estrategiaDeNotificacion;
    private Notificable notificable;

    public Notificador(EstrategiaDeNotificacion estrategiaDeNotificacion) {
        this.estrategiaDeNotificacion = estrategiaDeNotificacion;
    }

    public void setEstrategiaDeNotificacion(EstrategiaDeNotificacion estrategiaDeNotificacion) {
        this.estrategiaDeNotificacion = estrategiaDeNotificacion;
    }

    public void setNotificable(Notificable notificable) {
        this.notificable = notificable;
    }

    public void notificar() {
        this.estrategiaDeNotificacion.notificar(this.notificable);
    }
}
