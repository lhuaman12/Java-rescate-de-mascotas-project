package QR.QR;

import Adapter.AdapterFabricadorQR;

public class FabricadorQR {
    private String mensaje;
    private AdapterFabricadorQR adapterQR;
    private String pathFile;
    public void crear() throws Exception {
        adapterQR.crear(mensaje,pathFile);
    }

    public FabricadorQR(AdapterFabricadorQR adapterQR,String mensaje, String pathFile) {
        this.mensaje = mensaje;
        this.adapterQR = adapterQR;
        this.pathFile = pathFile;
    }
}
