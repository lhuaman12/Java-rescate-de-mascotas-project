package notificador.estrategias;

import notificador.notificables.Notificable;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class NotificarEmail implements EstrategiaDeNotificacion {

    private static final String ACCOUNT_USER = System.getenv("DDS_EMAIL_ACCOUNT_USER");
    private static final String ACCOUNT_PASS = System.getenv("DDS_EMAIL_ACCOUNT_PASS");


    public void notificar(Notificable notificable) {

        String medio = notificable.medio();
        String addressList = notificable.destinatario();
        String text = notificable.mensaje();
        String subject = "RescateDePatitas - Testing email";

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(ACCOUNT_USER, ACCOUNT_PASS);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(ACCOUNT_USER));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(addressList)
            );
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

}
