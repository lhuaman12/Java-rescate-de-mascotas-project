package domain.Mascotas;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class Mascota {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private String nombre;
    @Column
    private String apodo;
    @Transient
    private TipoMascota tipoMascota;
    @Enumerated
    private EdadAproximada edadAprox;
    @Column
    private String descripcion;
    @Transient
    private TamanioMascota tamanio;
    @Column
    private String qr;
    @Enumerated
    private Sexo sexo;
    @Column(columnDefinition = "DATE")
    private LocalDate fechaAlta;
    @Transient
    private List<FotoMascota> fotos;
    //private List<Foto> fotos;
    //private List<Caracterisitica> caracterisicas;


    // Constructor
    public Mascota(
            String nombre,
            String apodo,
            TipoMascota tipoMascota,
            EdadAproximada edadAprox,
            String descripcion,
            TamanioMascota tamanio,
            Sexo sexo) {

        this.nombre = nombre;
        this.apodo = apodo;
        this.tipoMascota = tipoMascota;
        this.edadAprox = edadAprox;
        this.descripcion = descripcion;
        this.tamanio = tamanio;
        this.sexo = sexo;

//        this.fotos = new ArrayList<>();
//        this.caracterisicas = new ArrayList<>();

    }

    // Getters

    public String getNombre() {
        return nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public TipoMascota getTipoMascota() {
        return tipoMascota;
    }

    public EdadAproximada getEdadAprox() {
        return edadAprox;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public TamanioMascota getTamanio() {
        return tamanio;
    }

    public String getQr() {
        return qr;
    }

    public Sexo getSexo() {
        return sexo;
    }

/*
    public List<Foto> getFotos() {
        return fotos;
    }

    public List<Caracterisitica> getCaracterisicas() {
        return caracterisicas;
    }
*/


    // Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public void setTipoMascota(TipoMascota tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public void setEdadAprox(EdadAproximada edadAprox) {
        this.edadAprox = edadAprox;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTamanio(TamanioMascota tamanio) {
        this.tamanio = tamanio;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

/*
    public void addFoto(Foto foto) {
        this.fotos.add(foto);
    }

    public void addCaracterisica(Caracterisitica caracterisica) {
        this.caracterisicas.add(caracterisica);
    }
*/


}