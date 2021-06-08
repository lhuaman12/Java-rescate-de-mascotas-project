package notificador;

import notificador.config.Config;
import notificador.estrategias.NotificarEmail;
import notificador.estrategias.NotificarSMS;
import notificador.estrategias.NotificarWhatsApp;
import notificador.notificables.Mensaje;
import notificador.notificador.Notificador;
import org.junit.Before;
import org.junit.Test;

public class NotificadorTest {

    private Notificador notificador;
    private Mensaje mensaje;

    @Before
    public void init(){

        this.notificador = new Notificador(new NotificarEmail());
        Mensaje mensaje = new Mensaje(Config.text, "EMAIL", System.getenv("DDS_TWILIO_SMS_TO"));
        this.mensaje = mensaje;

    }

    @Test
    public void NotificarEmail() {
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
