package domain.Mascotas;

import domain.Organizaciones.Caracterisiticas.Caracterisitica;

import java.util.ArrayList;
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
    private String token;

    public TipoMascota getTipo() {
        return tipo;
    }

    public TamanioMascota getTamanio() {
        return tamanio;
    }

    public void setTamanio(TamanioMascota tamanio) {
        this.tamanio = tamanio;
    }


    //constructor principal sin builder
//-----------------------------------------------------------------
    public Mascota(TipoMascota tipo, String nombre, String apodo, Integer edadAprox, String descripcion, Sexo sexo) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.apodo = apodo;
        this.edadAprox = edadAprox;
        this.descripcion = descripcion;
        this.sexo=sexo;
        this.fotos= new ArrayList<>();
        this.caracterisicas = new ArrayList<>();
        this.token=null;
    }

    //constructor aplicando builder
//-----------------------------------------------------------------

    public Mascota(){
        this.fotos= new ArrayList<>();
        this.token=null;
    }

    public Mascota tipoMascota(TipoMascota tipo){
        this.tipo=tipo;
        return this;
    }
    public Mascota nombre(String nombre){
        this.nombre=nombre;
        return this;
    }
    public Mascota apodo(String apodo){
        this.apodo=apodo;
        return this;
    }
    public Mascota edadAprox(Integer edadAprox){
        this.edadAprox=edadAprox;
        return this;
    }
    public Mascota descripcion(String descripcion){
        this.descripcion=descripcion;
        return this;
    }
    public Mascota sexo(Sexo sexo){
        this.sexo=sexo;
        return this;
    }
    public Mascota tamanioMascota(TamanioMascota tamanio){
        this.tamanio=tamanio;
        return this;

    }

    public Mascota agregarToken(String token){
        this.token=token;
        return this;
    }


    public Mascota agregarImagen(Imagen imagen){
        this.fotos.add(imagen);
        return this;
    }
    public Mascota agregarImagenes(List<Imagen> imagenes){
        this.fotos=imagenes;
        return this;
    }

    public Mascota agregarCaracteristica(Caracterisitica caracterisitica){
        this.caracterisicas.add(caracterisitica);
        return this;
    }
    public Mascota agregarCaracteristicas(List<Caracterisitica> caracterisiticas){
        this.caracterisicas=caracterisiticas;
        return this;
    }

    //otros metodos
//-----------------------------------------------------------------

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

    public void setToken(String token_mascota) {
        this.token=token_mascota;
    }
    public String getToken() {
        return token;
    }

}
