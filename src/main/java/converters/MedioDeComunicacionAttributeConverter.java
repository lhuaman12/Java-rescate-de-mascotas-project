package converters;

import domain.entities.usuarios.MedioDeNotificacion;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class MedioDeComunicacionAttributeConverter implements AttributeConverter<MedioDeNotificacion,String> {

    @Override
    public String convertToDatabaseColumn(MedioDeNotificacion medioDeNotificacion){

        switch(medioDeNotificacion){
            case EMAIL:
                return "email";
            case SMS:
                return "SMS";
            case WHATSAPP:
                return "WhatsApp";
        }

        return null;
    }

    @Override
    public MedioDeNotificacion convertToEntityAttribute(String s) {
        switch(s){
            case "email":
                return MedioDeNotificacion.EMAIL;
            case "SMS":
                return MedioDeNotificacion.SMS;
            case "WhatsApp":
                return MedioDeNotificacion.WHATSAPP;
        }
        return null;
    }
}
