package domain.entities.publicaciones;

import domain.entities.usuarios.Usuario;

import java.time.LocalDate;

public class RegistroEstado {
    Usuario voluntarioResponsable;
    LocalDate fechaDeCambio;
    EstadoPublicacion estadoPublicacion;


    public RegistroEstado(Usuario voluntarioResponsable, EstadoPublicacion estadoPublicacion) {
        this.voluntarioResponsable = voluntarioResponsable;
        this.estadoPublicacion = estadoPublicacion;
    }
}
