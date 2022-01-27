package domain.entities.domicilio;

import javax.persistence.*;

@Entity
@Table(name = "domicilio")
public class Domicilio {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String calle;

    @Column
    private int altura;

    @Column(length = 8)
    private String piso;

    @Column(length = 8)
    private String dpto;

    @Column(length = 16)
    private String codPostal;

    @Column
    private double latitud;

    @Column
    private double longitud;

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "municipio_id")
    private Municipio municipio;

    // Constructor
    //public Domicilio() {}

    /*
    public Domicilio(
            int id,
            String calle,
            int altura,
            String piso,
            String dpto,
            String codPostal,
            double latitud,
            double longitud,
            Localidad localidad) {

        this.id = id;
        this.calle = calle;
        this.altura = altura;
        this.piso = piso;
        this.dpto = dpto;
        this.codPostal = codPostal;
        this.latitud = latitud;
        this.longitud = longitud;
        this.localidad = localidad;
    }
    */

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    /*
    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
    */
    //

}
