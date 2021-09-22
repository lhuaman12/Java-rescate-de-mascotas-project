package domain.entities.organizaciones;

import domain.entities.mascotas.MascotaRegistrada;
import domain.entities.organizaciones.AtributosOrganizacion.AtributosOrganizacion;
import domain.entities.organizaciones.AtributosOrganizacion.Parametros.CaracteristicaParaRegistro;
import domain.entities.organizaciones.Configuraciones.ConfiguracionImagen;
import domain.entities.usuarios.Direccion;
import domain.entities.usuarios.Domicilio;

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
    private String nombreDeOrganizacion;
    @Column
    private String descripcion;
    @Transient
    private Direccion direccion;
    @Column
    private long latitud;
    @Column
    private long longitud;
    @Transient
    public Point2D.Double coordenadas;
    @Transient
    private List<MascotaRegistrada> mascotasRegistradas;
    @Transient
    private AtributosOrganizacion atributosOrganizacion;
    @Transient
    private List<String> preguntasAdopcion;

    //constructor sin builder
//-----------------------------------------------------------------
    public Organizacion(String nombre, Direccion direccion, Point2D.Double coordenadas) {
        this.nombreDeOrganizacion = nombre;
        this.direccion = direccion;
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
        this.nombreDeOrganizacion=nombre;
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
    public Organizacion agregarCaracteristicas(List<CaracteristicaParaRegistro> caracteristicaParaRegistros){
        this.atributosOrganizacion.agregarCaracteristicas(caracteristicaParaRegistros);
        return this;
    }

    public Organizacion agregarCaracteristica(CaracteristicaParaRegistro caracteristicaParaRegistro){
        this.atributosOrganizacion.agregarCaracteristica(caracteristicaParaRegistro);
        return this;
    }

    public List<MascotaRegistrada> getMascotasRegistradas(){
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

    public List<CaracteristicaParaRegistro> getCaracteristicas() {
        return this.atributosOrganizacion.getCaracteristicas();
    }

    public void agregarMascota(MascotaRegistrada mascotaRegistrada) {
        this.mascotasRegistradas.add(mascotaRegistrada);
    }



}
