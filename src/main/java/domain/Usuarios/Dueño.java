package domain.Usuarios;

import domain.Mascotas.Imagen;
import domain.Mascotas.Mascota;
import domain.Mascotas.TipoQR;
import domain.Organizaciones.Organizacion;
import domain.Plataforma.Plataforma;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dueño extends PersonaComun implements ImplementacionMascota {

    private List<Mascota> mascotas;


    public Dueño(String nombre, String apellido, Documento tipoDoc,Integer nroDoc, Integer fechaNacimiento,Genero genero) {
        super.nombre=nombre;
        super.apellido=apellido;
        super.tipoDoc=tipoDoc;
        super.nroDoc=nroDoc;
        super.fechaNacimiento=fechaNacimiento;
        super.genero=genero;
        super.contactos = new ArrayList<>();
        this.mascotas = new ArrayList<>();
    }
    public void agregarMascota(Mascota mascota){
        this.mascotas.add(mascota);
    }
    public void agregarMascotas(Mascota...mascotas){
        Collections.addAll(this.mascotas,mascotas);
    }
    public void agregarContacto(Contacto contacto){
        this.contactos.add(contacto);
    }
    public void agregarMascotas(Contacto...contactos){Collections.addAll(this.contactos,contactos);
    }


    @Override
    public void crearPerfil(Cuenta cuenta) {
        this.cuenta=cuenta;
    }

    public Organizacion getOrganizacionMasCercana(Plataforma plataforma, Point2D.Double ubicacion) {
        return plataforma.getOrganizacionMasCercana(ubicacion);
    }

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

    public List<Mascota> getMascotas() {
        return mascotas;
    }
}
