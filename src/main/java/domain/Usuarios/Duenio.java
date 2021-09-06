package domain.Usuarios;

import domain.Mascotas.Imagen;
import domain.Mascotas.Mascota;
import domain.Mascotas.TipoQR;
import domain.Organizaciones.Organizacion;
import domain.Plataforma.Plataforma;

import java.awt.geom.Point2D;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Duenio extends PersonaComun implements ImplementacionMascota {

    private List<Mascota> mascotas;

//constructor principal sin builder
//-----------------------------------------------------------------
    public Duenio(String nombre, String apellido, Documento tipoDoc, Integer nroDoc, LocalDate fechaNacimiento) {
        super.nombre=nombre;
        super.apellido=apellido;
        super.tipoDoc=tipoDoc;
        super.nroDoc=nroDoc;
        super.fechaNacimiento=fechaNacimiento;
        super.contactos = new ArrayList<>();
        this.mascotas = new ArrayList<>();
    }
//constructor aplicando builder
//-----------------------------------------------------------------
    public Duenio(){
        super.contactos = new ArrayList<>();
        this.mascotas = new ArrayList<>();
    }

//métodos para instanciar cuenta
//-----------------------------------------------------------------
    @Override
    public void crearPerfil(Cuenta cuenta) {
    this.cuenta=cuenta;
}


    //métodos de registro de mascotas
//-----------------------------------------------------------------
    public void registrarMascotas(List<Mascota> mascotas, Organizacion org) {
        mascotas.stream().forEach(m -> this.registrarMascota(m,org));
    }

    @Override
    public void registrarMascota(Mascota mascota,Organizacion org) {
        this.agregarMascota(mascota);
        org.agregarMascota(mascota);
    }

    @Override
    public void reemplazarFotos(Mascota mascota, List<Imagen> fotosNormalizadas) {
        mascota.setFotos(fotosNormalizadas);
    }

    @Override
    public void agregarQR(Mascota mascota, TipoQR codigoMascota) {
        mascota.setCodigo(codigoMascota);
    }

    @Override
    public void agregarToken(Mascota mascota, String token_mascota) {
        mascota.setToken(token_mascota);
    }

    @Override
    public void asociarDuenio(Mascota mascota) {
        mascota.setDuenio(this);
    }

//métodos de obtención de dueño de mascota - organizacion más cercana
//-----------------------------------------------------------------

    @Override
    public Boolean tieneQRAsociado(TipoQR codigoQR) {
        return this.mascotas.stream().anyMatch(m -> m.getCodigo()==codigoQR);
    }

    public Organizacion getOrganizacionMasCercana(Plataforma plataforma, Point2D.Double ubicacion) {
        return plataforma.getOrganizacionMasCercana(ubicacion);
    }

//otros métodos
//-----------------------------------------------------------------
    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void agregarMascota(Mascota mascota){
        this.mascotas.add(mascota);
    }
    public void agregarMascotas(Mascota...mascotas){
        Collections.addAll(this.mascotas,mascotas);
    }

    public void agregarMascotas(Contacto...contactos){Collections.addAll(this.contactos,contactos);
    }


}
