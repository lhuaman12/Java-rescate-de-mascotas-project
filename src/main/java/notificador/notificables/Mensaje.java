package notificador.notificables;

public class Mensaje implements Notificable {

    private String mensaje;
    private String medio;
    private String destinatario;

    public Mensaje(String mensaje, String medio, String destinatario) {
        this.mensaje = mensaje;
        this.medio = medio;
        this.destinatario = destinatario;
    }

    @Override
    public String mensaje() {
        return this.mensaje;
    }

    @Override
    public String medio() {
        return this.medio;
    }

    @Override
    public String destinatario() {
        return this.destinatario;
    }

}
