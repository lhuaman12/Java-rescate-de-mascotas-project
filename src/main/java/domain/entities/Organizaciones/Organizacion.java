package domain.entities.Organizaciones;

import domain.entities.Mascotas.Mascota;
import domain.entities.Organizaciones.AtributosOrganizacion.AtributosOrganizacion;
import domain.entities.Organizaciones.Caracterisiticas.Caracterisitica;
import domain.entities.Organizaciones.Configuraciones.ConfiguracionImagen;
import domain.entities.Usuarios.Domicilio;

import javax.persistence.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name = "organizacion")
public class Organizacion {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Transient
    private Domicilio domicilio;
    @Column
    private long latitud;
    @Column
    private long longitud;
    @Transient
    public Point2D.Double coordenadas;
    @Transient
    private List<Mascota> mascotasRegistradas;
    @Transient
    private AtributosOrganizacion atributosOrganizacion;
    @Transient
    private List<String> preguntasAdopcion;

    //constructor sin builder
//-----------------------------------------------------------------
    public Organizacion(String nombre, String direccion, Point2D.Double coordenadas) {
        this.nombre = nombre;
        //this.direccion = direccion;
        this.coordenadas = coordenadas;
        this.mascotasRegistradas=new ArrayList<>();
        preguntasAdopcion = new ArrayList<>();
    }

    //constructor aplicando builder
//-----------------------------------------------------------------
    public Organizacion(){
        this.atributosOrganizacion=new AtributosOrganizacion();
        this.mascotasRegistradas = new ArrayList<>();
    }
    public Organizacion nombre(String nombre){
        this.nombre=nombre;
        return this;
    }
/*    public Organizacion direccion(String direccion){
        this.direccion=direccion;
        return this;
    }*/
    public Organizacion coordenadas(Point2D.Double coordenadas){
        this.coordenadas=coordenadas;
        return this;
    }
    public Organizacion agregarCaracteristicas(List<Caracterisitica> caracterisiticas){
        this.atributosOrganizacion.agregarCaracteristicas(caracterisiticas);
        return this;
    }

    public Organizacion agregarCaracteristica(Caracterisitica caracterisitica){
        this.atributosOrganizacion.agregarCaracteristica(caracterisitica);
        return this;
    }

    public List<Mascota> getMascotasRegistradas(){
        return this.mascotasRegistradas;
    }


    /*public Caracterisitica getCaracterisiticaSegun(Categoria cat, TipoCaract tipo){
        return this.caracteristicas.stream().filter(c -> c.existenAtributos(cat,tipo)).findFirst().get();
    }*/
    public ConfiguracionImagen getConfiguracionImagen() {
        return this.atributosOrganizacion.getConfiguracionImagen();
    }

    public Organizacion setConfiguracionImagen(ConfiguracionImagen configuracionImagen) {
        this.atributosOrganizacion.setConfiguracionImagen(configuracionImagen);
        return this;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

/*    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }*/

    public Point2D.Double getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Point2D.Double coordenadas) {
        this.coordenadas = coordenadas;
    }

    public List<Caracterisitica> getCaracteristicas() {
        return this.atributosOrganizacion.getCaracteristicas();
    }

    public void agregarMascota(Mascota mascota) {
        this.mascotasRegistradas.add(mascota);
    }



}
