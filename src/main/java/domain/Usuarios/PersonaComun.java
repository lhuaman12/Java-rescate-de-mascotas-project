package domain.Usuarios;

import java.util.List;

public abstract class PersonaComun extends Persona{

    protected String nombre;
    protected String apellido;
    protected Documento tipoDoc;
    protected Integer nroDoc;
    protected Integer fechaNacimiento;
    protected Genero genero;
    protected List<Contacto> contactos;


}
