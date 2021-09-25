package domain.entities.publicaciones;

import domain.entities.usuarios.Voluntario;

import java.time.LocalDate;

public class RegistroEstado {
    Voluntario voluntarioResponsable;
    LocalDate fechaDeCambio;
    EstadoPublicacion estadoPublicacion;


    public RegistroEstado(Voluntario voluntarioResponsable, EstadoPublicacion estadoPublicacion) {
        this.voluntarioResponsable = voluntarioResponsable;
        this.estadoPublicacion = estadoPublicacion;
    }
}
