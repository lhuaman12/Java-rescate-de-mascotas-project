package domain.entities.utils.QR.QR;

import Adapter.AdapterFabricadorQR;
import domain.entities.mascotas.QRRescate;

public class FabricadorQR {
    private String mensaje;
    private AdapterFabricadorQR adapterQR;

    public QRRescate crear(String idDuenio,String pathFile) throws Exception {
        String path = pathFile+"/"+idDuenio;
        QRRescate qr = new QRRescate();
        adapterQR.crear(mensaje,path);
        qr.setPath(path);
        return qr;
    }

    public String getMensaje() {
        return mensaje;
    }

    public FabricadorQR(AdapterFabricadorQR adapterQR, String mensaje) {
        this.mensaje = mensaje;
        this.adapterQR = adapterQR;
    }
}
