package domain.entities.organizaciones;

import domain.entities.mascotas.MascotaRegistrada;
import domain.entities.organizaciones.PreguntasONG.Atributo;
import domain.entities.usuarios.Direccion;
import domain.entities.usuarios.Domicilio;

import javax.persistence.*;
import java.awt.geom.Point2D;
import java.util.List;

@Table
@Entity(name = "organizacion")
public class Organizacion {

    private int id;

    private String nombreDeOrganizacion;

    private String descripcion;

    private Direccion direccion;

    private long latitud;

    private long longitud;

    public Point2D.Double coordenadas;

    private List<MascotaRegistrada> mascotasRegistradas;

    private List<Atributo> preguntasRequeridas;

    public void agregarRequerimiento(Atributo atributo){
        this.preguntasRequeridas.add(atributo);
    }

}