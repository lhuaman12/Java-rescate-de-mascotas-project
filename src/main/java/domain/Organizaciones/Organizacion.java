package domain.Organizaciones;

import domain.Mascotas.Mascota;
import domain.Mascotas.TipoQR;
import domain.Organizaciones.AtributosOrganizacion.AtributosOrganizacion;
import domain.Organizaciones.Caracterisiticas.Caracterisitica;
import domain.Organizaciones.Configuraciones.ConfiguracionImagen;
import domain.Organizaciones.GrupoPublicaciones.EstadoPublicacion;
import domain.Organizaciones.GrupoPublicaciones.GrupoPublicaciones;
import domain.Organizaciones.GrupoPublicaciones.PublicacionMascotaPerdida;
import domain.Organizaciones.UsuariosOrg.UsuariosOrganizacion;
import domain.Usuarios.Administrador;
import domain.Usuarios.Voluntario;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Organizacion {
    private String nombre;
    private String direccion;
    public Point2D.Double coordenadas;

    private List<Mascota> mascotasRegistradas;

    private AtributosOrganizacion atributosOrganizacion;
    private GrupoPublicaciones grupoPublicaciones;
    private UsuariosOrganizacion usuariosOrganizacion;

    //constructor sin builder
//-----------------------------------------------------------------
    public Organizacion(String nombre, String direccion, Point2D.Double coordenadas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.coordenadas = coordenadas;
        this.mascotasRegistradas=new ArrayList<>();
    }

    //constructor aplicando builder
//-----------------------------------------------------------------
    public Organizacion(){
        this.atributosOrganizacion=new AtributosOrganizacion();
        this.grupoPublicaciones = new GrupoPublicaciones();
        this.usuariosOrganizacion= new UsuariosOrganizacion();
        this.mascotasRegistradas = new ArrayList<>();
    }
    public Organizacion nombre(String nombre){
        this.nombre=nombre;
        return this;
    }
    public Organizacion direccion(String direccion){
        this.direccion=direccion;
        return this;
    }
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


    public Mascota getMascotaByQR(TipoQR codigoQR){
        return this.mascotasRegistradas.stream().filter(m -> m.getCodigo()==codigoQR).findFirst().get();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

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


    public void agregarVoluntario(Voluntario voluntario) {
        this.usuariosOrganizacion.agregarVoluntario(voluntario);
    }

    public void agregarAdministrador(Administrador administrador) {
        this.usuariosOrganizacion.agregarAdministrador(administrador);

    }
    public void quitarVoluntario(Voluntario voluntario) {
        this.usuariosOrganizacion.quitarVoluntario(voluntario);
    }

    public void quitarAdministrador(Administrador administrador) {
        this.usuariosOrganizacion.quitarAdministrador(administrador);

    }

    public void agregarPublicacionMascotaPerdida(PublicacionMascotaPerdida publicacion) {
        this.grupoPublicaciones.agregarPublicacionMascotaPerdida(publicacion);
    }

    public Stream<PublicacionMascotaPerdida> getPublicacionesPendientes() {
        return this.grupoPublicaciones.getPublicacionesMascotasPerdidas()
                .stream()
                .filter(publi -> publi.getEstadoPublicacion()==EstadoPublicacion.PENDIENTE);
    }
}
