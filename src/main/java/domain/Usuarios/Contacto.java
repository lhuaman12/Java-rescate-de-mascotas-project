package domain.Usuarios;

import java.util.ArrayList;
import java.util.List;

public class Contacto {
    protected String nombre;
    protected String apellido;
    private Integer telefono;
    private String mail;
    private List<MetodoNotificacion> formasNotificacion;


    public Contacto(String nombre, String apellido, Integer telefono, String mail) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.mail = mail;
        this.formasNotificacion = new ArrayList<>();
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

    public List<MetodoNotificacion> getFormasNotificacion() {
        return formasNotificacion;
    }

    public void setFormasNotificacion(List<MetodoNotificacion> formasNotificacion) {
        this.formasNotificacion = formasNotificacion;
    }

    public void agregarMetodoNotificacion(MetodoNotificacion metodo){
        if(!this.formasNotificacion.contains(metodo)){
            this.formasNotificacion.add(metodo);
        }
    }

}
