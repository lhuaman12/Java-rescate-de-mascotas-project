package domain.Usuarios;

import java.time.LocalDate;
import java.util.List;

public abstract class PersonaComun extends Persona{

    protected String nombre;
    protected String apellido;
    protected Documento tipoDoc;
    protected Integer nroDoc;
    protected LocalDate fechaNacimiento;
    protected List<Contacto> contactos;

    public PersonaComun nombre(String nombre){
        this.nombre=nombre;
        return this;
    }
    public PersonaComun apellido(String apellido){
        this.apellido=apellido;
        return this;
    }
    public PersonaComun tipoDoc(Documento tipoDoc){
        this.tipoDoc=tipoDoc;
        return this;
    }
    public PersonaComun nroDoc(Integer nroDoc){
        this.nroDoc=nroDoc;
        return this;
    }
    public PersonaComun fechaNacimiento(LocalDate fechaNac){
        this.fechaNacimiento=fechaNac;
        return this;
    }

    public PersonaComun contactos(List<Contacto> contactos){
        this.contactos=contactos;
        return this;
    }
    public PersonaComun agregarContacto(Contacto contacto){
        this.contactos.add(contacto);
        return this;
    }
    public PersonaComun cuenta(Cuenta cuenta){
        super.cuenta=cuenta;
        return this;
    }

    public List<Contacto> getContactos(){
        return contactos;
    }

}
