package domain.entities.usuarios;

abstract public class Persona {
    private Credenciales credeciales;
    private String nombre;
    private String apellido;

    public void registrarse(String username,String password){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
