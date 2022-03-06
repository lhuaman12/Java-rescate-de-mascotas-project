package domain.entities.mascotas;

import domain.entities.utils.refugiodds.BuscadorDeHogaresService;
import domain.entities.utils.refugiodds.entidades.Hogar;

import javax.persistence.*;
import java.io.IOException;
import java.util.List;


@Entity
@DiscriminatorValue("perdida")
public class MascotaPerdida extends Mascota {


    @OneToOne
    @JoinColumn(name="hogar_id",referencedColumnName = "id")
    private HogarDeTransito hogarActual; //hogar de transito donde se encuentra (si no esta es null)

    // Constructor
    public MascotaPerdida() {}


    // Methods
    public List<Hogar> buscarHogarDeTransito() throws IOException {
        BuscadorDeHogaresService buscador = BuscadorDeHogaresService.getInstancia();
        return buscador.buscarHogar(this); // TODO: la consulta a la API es sincronica cambiar luego
    }

    public HogarDeTransito getHogarDeTransito() {
        return this.hogarActual;
    }

    public void setHogarDeTransito(HogarDeTransito hogar) {
        this.hogarActual = hogar;
    }

    // metodos



}
