package domain.Usuarios;

import domain.GestorMascotasPerdidas.FormularioMascotaPerdida;
import domain.GestorMascotasPerdidas.HandlerMascotaPerdida;
import domain.GestorMascotasPerdidas.MascotaPerdida;
import domain.Mascotas.Mascota;
import domain.Mascotas.TipoQR;

import java.awt.*;
import java.awt.geom.Point2D;
import java.time.LocalDate;
import java.util.ArrayList;

public class Rescatista extends PersonaComun implements ImplementacionMascotaPerdida{
    private String direccion;
    private FormularioMascotaPerdida formularioMascotaPerdida;

//constructor principal sin builder
//-----------------------------------------------------------------
    public Rescatista(String nombre, String apellido, Documento tipoDoc, Integer nroDoc, LocalDate fechaNacimiento, Genero genero) {
        super.nombre=nombre;
        super.apellido=apellido;
        super.tipoDoc=tipoDoc;
        super.nroDoc=nroDoc;
        super.fechaNacimiento=fechaNacimiento;
        super.genero=genero;
        super.contactos = new ArrayList<>();
        this.direccion = null;
        this.formularioMascotaPerdida=null;

    }

//constructor aplicando builder - ver persona común
//-----------------------------------------------------------------

    public Rescatista(){
        super.contactos = new ArrayList<>();
        this.formularioMascotaPerdida=null;
    }

    public Rescatista direccion(String direccion){
        this.direccion=direccion;
        return this;
    }

    public void rellenarFormulario(MascotaPerdida mascotaPerdida, HandlerMascotaPerdida handler){
        this.formularioMascotaPerdida= new FormularioMascotaPerdida(this,mascotaPerdida,handler);
    }


//metodos para simular rescate

    public void accionMascotaEncontrada(){
        this.formularioMascotaPerdida.gestionarRescate();
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
