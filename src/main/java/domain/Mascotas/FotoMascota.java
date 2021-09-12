package domain.Mascotas;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class FotoMascota {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private String ruta;

    // Constructor
    public FotoMascota(String ruta) {
        this.ruta = ruta;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
