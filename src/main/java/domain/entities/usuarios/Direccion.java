package domain.entities.usuarios;

import javax.persistence.*;

@Entity
@Table(name = "domicilio")
public class Direccion {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private String calle;
    @Column
    private int altura;
    @Column
    private String localidad;
    @Column
    private String provincia;
    @Column
    private String pais;
    @Column
    private String codPostal;


    // Constructor
    /*
    public Domicilio(String calle,
                     int altura,
                     String localidad,
                     String provincia,
                     String pais,
                     String codPostal) {

        this.calle = calle;
        this.altura = altura;
        this.localidad = localidad;
        this.provincia = provincia;
        this.pais = pais;
        this.codPostal = codPostal;
    }
    */


    // Getters and Setters

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

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    //

}
