package domain.Usuarios;

import domain.Mascotas.Mascota;

import java.awt.*;
import java.util.ArrayList;

public class Rescatista extends PersonaComun{
    private String direccion;
    private Polygon coordenadas;
    private Mascota mascotaPerdida;

    public Rescatista(String nombre, String apellido, Documento tipoDoc,Integer nroDoc, Integer fechaNacimiento,Genero genero) {
        super.nombre=nombre;
        super.apellido=apellido;
        super.tipoDoc=tipoDoc;
        super.nroDoc=nroDoc;
        super.fechaNacimiento=fechaNacimiento;
        super.genero=genero;
        super.contactos = new ArrayList<>();
        this.direccion = null;
        this.coordenadas=null;
        this.mascotaPerdida=null;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Polygon getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Polygon coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Mascota getMascotaPerdida() {
        return mascotaPerdida;
    }

    public void setMascotaPerdida(Mascota mascotaPerdida) {
        this.mascotaPerdida = mascotaPerdida;
    }
}
