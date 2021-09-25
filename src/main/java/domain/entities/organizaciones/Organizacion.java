package domain.entities.organizaciones;

import domain.entities.mascotas.MascotaRegistrada;
import domain.entities.organizaciones.Configuraciones.EstandarImagen;
import domain.entities.organizaciones.PreguntasONG.Atributo;
import domain.entities.usuarios.Direccion;


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

    private EstandarImagen estandarImagen;

    public void agregarRequerimiento(Atributo atributo){
        this.preguntasRequeridas.add(atributo);
    }

    public void agregarCaracteristica(Atributo caracteristicaMascota) {
    }
}