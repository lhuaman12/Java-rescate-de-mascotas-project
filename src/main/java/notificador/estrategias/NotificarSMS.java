package notificador.estrategias;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import notificador.notificables.Notificable;

public class NotificarSMS implements EstrategiaDeNotificacion {

    private static final String ACCOUNT_SID = System.getenv("DDS_TWILIO_ACCOUNT_SID");
    private static final String AUTH_TOKEN = System.getenv("DDS_TWILIO_AUTH_TOKEN");
    private static final String FROM_NUMBER = System.getenv("DDS_TWILIO_SMS_FROM");


    public void notificar(Notificable notificable) {

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        String medio = notificable.medio();
        String addressList = notificable.destinatario();
        String text = notificable.mensaje();

        Message message = Message.creator(
                new PhoneNumber(addressList),        // To number
                new PhoneNumber(FROM_NUMBER),        // From number
                text
        ).create();

        System.out.println("Done");
    }

}
