package domain.GestorMascotasPerdidas;

import domain.Usuarios.Rescatista;

public class FormularioMascotaPerdida {
    Rescatista rescatista;
    MascotaPerdida datosMascotaPerdida;
    HandlerMascotaPerdida handlerMascotaPerdida;


    public void gestionarRescate() {
        handlerMascotaPerdida.gestionarRescate(this);
    }

    public FormularioMascotaPerdida(Rescatista rescatista, MascotaPerdida datosMascotaPerdida, HandlerMascotaPerdida handlerMascotaPerdida) {
        this.rescatista = rescatista;
        this.datosMascotaPerdida = datosMascotaPerdida;
        this.handlerMascotaPerdida = handlerMascotaPerdida;
    }
}
