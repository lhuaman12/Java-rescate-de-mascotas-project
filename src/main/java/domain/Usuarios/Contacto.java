package domain.Usuarios;

import java.util.List;

public class Contacto {
    protected String nombre;
    protected String apellido;
    private Integer telefono;
    private String mail;
    //private List<MedioContacto> formasContacto;


    public Contacto(String nombre, String apellido, Integer telefono, String mail) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.mail = mail;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
