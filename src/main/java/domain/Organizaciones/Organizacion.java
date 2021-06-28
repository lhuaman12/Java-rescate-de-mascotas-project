package domain.Organizaciones;

import domain.Mascotas.Mascota;
import domain.Organizaciones.Configuraciones.ConfiguracionImagen;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Organizacion {
    public String nombre;
    public String direccion;
    public Point2D.Double coordenadas;
    public List<Caracterisitica> caracteristicas;
    public List<Mascota> mascotasRegistradas;
    public ConfiguracionImagen configuracionImagen;

    public Organizacion(String nombre, String direccion, Point2D.Double coordenadas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.coordenadas = coordenadas;
        this.caracteristicas = new ArrayList<Caracterisitica>();
        this.mascotasRegistradas=new ArrayList<>();
    }

    public Caracterisitica getCaracterisiticaSegun(Categoria cat, TipoCaract tipo){
        return this.caracteristicas.stream().filter(c -> c.existenAtributos(cat,tipo)).findFirst().get();
    }

    public ConfiguracionImagen getConfiguracionImagen() {
        return configuracionImagen;
    }

    public void setConfiguracionImagen(ConfiguracionImagen configuracionImagen) {
        this.configuracionImagen = configuracionImagen;
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
        return caracteristicas;
    }

    public void setCaracteristicas(List<Caracterisitica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public void agregarCaracteristica(Caracterisitica caracterisitica) {
        this.caracteristicas.add(caracterisitica);
    }


    public void agregarMascota(Mascota mascota) {
        this.mascotasRegistradas.add(mascota);
    }

    public List<Mascota> getMascotasRegistradas() {
        return mascotasRegistradas;
    }
}
