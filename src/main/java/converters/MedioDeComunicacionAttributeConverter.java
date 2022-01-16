package converters;

import domain.entities.usuarios.MedioDeNotificacion;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class MedioDeComunicacionAttributeConverter implements AttributeConverter<MedioDeNotificacion,String> {

    @Override
    public String convertToDatabaseColumn(MedioDeNotificacion medioDeNotificacion){
        if(medioDeNotificacion == MedioDeNotificacion.EMAIL)
            return "email";

        else if (medioDeNotificacion == MedioDeNotificacion.SMS)
            return "SMS";
        else if (medioDeNotificacion == MedioDeNotificacion.WHATSAPP)
            return "WhatsApp";

        return null;
    }

    @Override
    public MedioDeNotificacion convertToEntityAttribute(String s) {
        if(s == "email")
            return MedioDeNotificacion.EMAIL;
        else if (s == "SMS")
            return MedioDeNotificacion.SMS;
        else if (s == "WhatsApp")
            return MedioDeNotificacion.WHATSAPP;
        return null;
    }
}
