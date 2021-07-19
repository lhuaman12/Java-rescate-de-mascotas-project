package domain.GestorMascotasPerdidas;

public class EstrategiaConQR implements HandlerMascotaPerdida{
    String token;
    RescatistaServices notificadorMascota;

    public EstrategiaConQR() {
    }
    public EstrategiaConQR token(String token){
        this.token=token;
        return this;
    }
    public EstrategiaConQR notificadorMascota(RescatistaServices rescatistaServices){
        this.notificadorMascota=rescatistaServices;
        return this;
    }

    @Override
    public void gestionarRescate(FormularioMascotaPerdida formularioMascotaPerdida) {
        notificadorMascota.notificarMascotaPerdida(formularioMascotaPerdida,token);
    }


}
