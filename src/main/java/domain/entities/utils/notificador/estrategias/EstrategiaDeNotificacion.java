package domain.entities.utils.notificador.estrategias;

import domain.entities.utils.notificador.notificables.Notificable;

public interface EstrategiaDeNotificacion {

    public void notificar(Notificable notificable);
}
