package domain.entities.mascotas;

import domain.entities.utils.refugiodds.BuscadorDeHogaresService;
import domain.entities.utils.refugiodds.entidades.Hogar;

import javax.persistence.*;
import java.io.IOException;
import java.util.List;


@Entity
@DiscriminatorValue("perdida")
public class MascotaPerdida extends Mascota {

    @Enumerated(EnumType.STRING)
    private EdadAproximada edadAprox;

    @Transient
    private Hogar hogarDeTransito;


    // Constructor
    public MascotaPerdida() {}


    // Getters and Setters

    public EdadAproximada getEdadAprox() {
        return edadAprox;
    }

    public void setEdadAprox(EdadAproximada edadAprox) {
        this.edadAprox = edadAprox;
    }

    public Hogar getHogarDeTransito() {
        return hogarDeTransito;
    }

    public void setHogarDeTransito(Hogar hogarDeTransito) {
        this.hogarDeTransito = hogarDeTransito;
    }


    // Methods
    public List<Hogar> buscarHogarDeTransito() throws IOException {
        BuscadorDeHogaresService buscador = BuscadorDeHogaresService.getInstancia();
        return buscador.buscarHogar(this); // TODO: la consulta a la API es sincronica cambiar luego
    }
    public void confimarHogarDeTransito(Hogar hogarDeTransito){
        this.hogarDeTransito = hogarDeTransito;
    }


}
