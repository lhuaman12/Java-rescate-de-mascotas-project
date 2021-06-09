package notificador.estrategias;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import notificador.notificables.Notificable;

public class NotificarWhatsApp implements EstrategiaDeNotificacion {

    private static final String ACCOUNT_SID = System.getenv("DDS_TWILIO_ACCOUNT_SID");
    private static final String AUTH_TOKEN = System.getenv("DDS_TWILIO_AUTH_TOKEN");
    private static final String FROM_NUMBER = System.getenv("DDS_TWILIO_WS_FROM");

    public void notificar(Notificable notificable) {

        String medio = notificable.medio();
        String addressList = notificable.destinatario();
        String text = notificable.mensaje();

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(addressList),   // To number
                new com.twilio.type.PhoneNumber(FROM_NUMBER),   // From number
                text)
                .create();

        // System.out.println(message.getSid());
        System.out.println("Done");
    }

}


