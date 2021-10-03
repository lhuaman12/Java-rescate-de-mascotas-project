package domain.entities.publicaciones;

import domain.entities.usuarios.Voluntario;

import java.util.List;

abstract public class Publicacion {
    protected String titulo;
    protected String contenido;
    List<RegistroEstado> registroEstados;

    abstract public void generarTitulo();

    abstract void generarContenido();

    public void cambiarEstado(EstadoPublicacion estadoPublicacion, Voluntario voluntario){
        RegistroEstado nuevoRegistro = new RegistroEstado(voluntario,estadoPublicacion);
        registroEstados.add(nuevoRegistro);
    }

}
