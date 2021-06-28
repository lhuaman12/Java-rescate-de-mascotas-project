package domain.Mascotas;

import domain.Organizaciones.Caracterisitica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mascota {
    private TipoMascota tipo;
    private String nombre;
    private String apodo;
    private Integer edadAprox;
    private String descripcion;
    private TamanioMascota tamanio;
    private Sexo sexo;
    private List<Imagen> fotos;
    private List<Caracterisitica> caracterisicas;
    private TipoQR codigo;

    public TipoMascota getTipo() {
        return tipo;
    }

    public TamanioMascota getTamanio() {
        return tamanio;
    }

    public void setTamanio(TamanioMascota tamanio) {
        this.tamanio = tamanio;
    }

    public Mascota(TipoMascota tipo, String nombre, String apodo, Integer edadAprox, String descripcion, Sexo sexo) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.apodo = apodo;
        this.edadAprox = edadAprox;
        this.descripcion = descripcion;
        this.sexo=sexo;
        this.fotos= new ArrayList<>();
        this.caracterisicas = new ArrayList<>();
        this.codigo=null;
    }

    public void setFotos(List<Imagen> fotos) {
        this.fotos = fotos;
    }

    public void setCaracterisicas(List<Caracterisitica> caracterisicas) {
        this.caracterisicas = caracterisicas;
    }

    public List<Imagen> getFotos() {
        return fotos;
    }

    public List<Caracterisitica> getCaracterisicas() {
        return caracterisicas;
    }

    public TipoQR getCodigo() {
        return codigo;
    }

    public void setCodigo(TipoQR codigo) {
        this.codigo = codigo;
    }

}
