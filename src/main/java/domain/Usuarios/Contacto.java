package domain.Usuarios;

import java.util.ArrayList;
import java.util.List;

public class Contacto {
    protected String nombre;
    protected String apellido;
    private Integer telefono;
    private String mail;
    private List<MetodoNotificacion> formasNotificacion;

//constructor completo
//-----------------------------------------------------------------
    public Contacto(String nombre, String apellido, Integer telefono, String mail) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.mail = mail;
        this.formasNotificacion = new ArrayList<>();
    }

//constructor aplicando builder
//-----------------------------------------------------------------
    public Contacto(){
        this.formasNotificacion = new ArrayList<>();
    }

    public Contacto nombre(String nombre){
    this.nombre=nombre;
    return this;
    }

    public Contacto apellido(String apellido){
        this.apellido=apellido;
        return this;
    }
    public Contacto telefono(Integer telefono){
        this.telefono=telefono;
        return this;
    }
    public Contacto mail(String mail){
        this.mail=mail;
        return this;
    }
    public Contacto agregarFormaNotificacion(MetodoNotificacion metodo){
        this.agregarMetodoNotificacion(metodo);
        return this;
    }

    public Contacto agregarFormasDeNotificacion(List<MetodoNotificacion> formasNotificacion) {
        this.formasNotificacion = formasNotificacion;
        return this;
    }

//set y agregar formas notificacion
//-----------------------------------------------------------------

    public void setFormasNotificacion(List<MetodoNotificacion> formasNotificacion) {
        this.formasNotificacion = formasNotificacion;
    }

    public void agregarMetodoNotificacion(MetodoNotificacion metodo){
        if(!this.formasNotificacion.contains(metodo)){
            this.formasNotificacion.add(metodo);
        }
    }

//otros metodos
//-----------------------------------------------------------------

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



}
