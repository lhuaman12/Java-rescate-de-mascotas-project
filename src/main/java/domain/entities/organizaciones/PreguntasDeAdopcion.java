package domain.entities.organizaciones;

import domain.entities.mascotas.TamanioMascota;

import java.time.LocalDate;
import java.util.List;

public class PreguntasDeAdopcion {
    private Boolean estaCastrada;
    private LocalDate edadAproximada;
    private TamanioMascota tamanioMascota;
    private List<PreguntasParticularesDeAdopcion> preguntasParticulares;

}
