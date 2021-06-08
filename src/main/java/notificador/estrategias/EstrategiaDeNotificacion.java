package notificador.estrategias;

import notificador.notificables.Notificable;

public interface EstrategiaDeNotificacion {

    public void notificar(Notificable notificable);
}
