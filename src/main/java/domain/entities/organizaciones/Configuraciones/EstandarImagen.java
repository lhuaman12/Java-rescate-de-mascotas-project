package domain.entities.organizaciones.Configuraciones;

import javax.persistence.*;

@Entity
@Table(name = "estandar_imagen")
public class EstandarImagen {
    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    CalidadImagen calidadImagen;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tamanio_imagen_id")
    TamanioImagen tamanioImagen;

    public EstandarImagen() {
    }

    public CalidadImagen getCalidadImagen() {
        return calidadImagen;
    }

    public void setCalidadImagen(CalidadImagen calidadImagen) {
        this.calidadImagen = calidadImagen;
    }

    public TamanioImagen getTamanioImagen() {
        return tamanioImagen;
    }

    public void setTamanioImagen(TamanioImagen tamanioImagen) {
        this.tamanioImagen = tamanioImagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
