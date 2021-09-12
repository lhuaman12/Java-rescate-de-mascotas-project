package domain.Usuarios;

import domain.Mascotas.Mascota;
import domain.Mascotas.TipoQR;

import java.awt.*;
import java.awt.geom.Point2D;
import java.time.LocalDate;
import java.util.ArrayList;

public class Rescatista extends PersonaComun implements ImplementacionMascotaPerdida{
    private String direccion;

//constructor principal sin builder
//-----------------------------------------------------------------
    public Rescatista(String nombre, String apellido, Documento tipoDoc, Integer nroDoc, LocalDate fechaNacimiento) {
        super.nombre=nombre;
        super.apellido=apellido;
        super.tipoDoc=tipoDoc;
        super.nroDoc=nroDoc;
        super.fechaNacimiento=fechaNacimiento;
        super.contactos = new ArrayList<>();
        this.direccion = null;

    }

//constructor aplicando builder - ver persona común
//-----------------------------------------------------------------

    public Rescatista(){
        super.contactos = new ArrayList<>();
    }

    public Rescatista direccion(String direccion){
        this.direccion=direccion;
        return this;
    }




    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    @Override
    public Boolean tieneQRAsociado(TipoQR codigoQR) {
        return null;
    }
}
