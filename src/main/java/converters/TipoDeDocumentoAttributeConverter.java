package converters;

import domain.entities.usuarios.TipoDocumento;

import javax.persistence.AttributeConverter;

public class TipoDeDocumentoAttributeConverter implements AttributeConverter<TipoDocumento,String> {
    @Override
    public String convertToDatabaseColumn(TipoDocumento tipoDocumento) {
        switch (tipoDocumento){
            case DNI:
                return "DNI";
            case LC:
                return "Libreta civica";
            case CI:
                return "Cedula de identidad";
            case PAS:
                return "Pasaporte";
            case LE:
                return "Libreta de enrolamiento";

        }
         return null;
    }

    @Override
    public TipoDocumento convertToEntityAttribute(String s) {
        switch(s){
            case "DNI":
                return TipoDocumento.DNI;
            case "Libreta civica":
                return TipoDocumento.LC;
            case "Cedula de identidad":
                return TipoDocumento.CI;
            case "Pasaporte":
                return TipoDocumento.PAS;
            case "Libreta de enrolamiento":
                return TipoDocumento.LE;

        }
        return null;
    }
}
