package domain.entities.mascotas;
import java.time.LocalDate;

// TODO: eliminar clase QRRescate

public class QRRescate {
    private String path;
    private LocalDate fechaDeGeneracion;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public LocalDate getFechaDeGeneracion() {
        return fechaDeGeneracion;
    }

    public void setFechaDeGeneracion(LocalDate fechaDeGeneracion) {
        this.fechaDeGeneracion = fechaDeGeneracion;
    }
}
