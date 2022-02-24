package domain.entities.mascotas;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("mascota_en_adopcion")
public class MascotaEnAdopcion extends Mascota{

    @Column
    private Boolean tieneTodasLasVacunas; //Pregunta de plataforma

    @Column
    private Boolean tieneDiscapacidad; // Pregunta de plataforma

    @Column
    private Boolean fueAdoptada;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Virtud> virtudes; //Pregunta de plataforma

    @OneToMany(mappedBy = "mascotaEnAdopcion",cascade = {CascadeType.ALL}) //many to many..
    private List<CaracteristicaDeAdopcion> caracteristica; //Preguntas de ONG

    public Boolean getTieneTodasLasVacunas() {
        return tieneTodasLasVacunas;
    }

    public void setTieneTodasLasVacunas(Boolean tieneTodasLasVacunas) {
        this.tieneTodasLasVacunas = tieneTodasLasVacunas;
    }

    public Boolean getFueAdoptada() {
        return fueAdoptada;
    }

    public void setFueAdoptada(Boolean fueAdoptada) {
        this.fueAdoptada = fueAdoptada;
    }

    public List<CaracteristicaDeAdopcion> getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(List<CaracteristicaDeAdopcion> caracteristica) {
        this.caracteristica = caracteristica;
    }

    public Boolean getTieneDiscapacidad() {
        return tieneDiscapacidad;
    }

    public void setTieneDiscapacidad(Boolean tieneDiscapacidad) {
        this.tieneDiscapacidad = tieneDiscapacidad;
    }


    public List<Virtud> getVirtudes() {
        return virtudes;
    }

    public void setVirtudes(List<Virtud> virtudes) {
        this.virtudes = virtudes;
    }

    public MascotaEnAdopcion() {
        this.virtudes = new ArrayList<>();

    }
}
