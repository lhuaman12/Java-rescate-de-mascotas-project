package domain.entities.rescate;

import domain.entities.mascotas.MascotaPerdida;
import domain.entities.usuarios.Usuario;

public class Rescate {
    private Usuario duenio;
    private MascotaPerdida mascotaPerdida;

    public void avisarDuenio(){

    }
    public Usuario buscarDuenio(){
        // TODO: buscar en DB por token, analizar eficiencia
        return null;
    }
}
