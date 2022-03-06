package domain.entities.utils.notificador;

import domain.entities.utils.notificador.config.Config;
import domain.entities.utils.notificador.estrategias.NotificarEmail;
import domain.entities.utils.notificador.estrategias.NotificarSMS;
import domain.entities.utils.notificador.estrategias.NotificarWhatsApp;
import domain.entities.utils.notificador.notificables.Mensaje;
import domain.entities.utils.notificador.notificador.Notificador;
import org.junit.Before;
import org.junit.Test;

public class NotificadorTest {

    private Notificador notificador;
    private Mensaje mensaje;

    @Before
    public void init(){

        this.notificador = new Notificador(new NotificarEmail());
        Mensaje mensaje = new Mensaje(Config.text, "EMAIL", System.getenv("DDS_EMAIL_TO"));
        this.mensaje = mensaje;

    }

    @Test
    public void NotificarEmail() {
        System.out.println(System.getenv("DDS_EMAIL_ACCOUNT_USER"));
        System.out.println(System.getenv("DDS_EMAIL_ACCOUNT_PASS"));
        this.notificador.setNotificable(this.mensaje);
        this.notificador.notificar();
    }

    @Test
    public void NotificarSMS() {
        this.notificador.setEstrategiaDeNotificacion(new NotificarSMS());
        this.notificador.setNotificable(this.mensaje);
        this.notificador.notificar();
    }

    @Test
    public void NotificarWhatsApp() {
        this.notificador.setEstrategiaDeNotificacion(new NotificarWhatsApp());
        this.notificador.setNotificable(this.mensaje);
        this.notificador.notificar();
    }

}
