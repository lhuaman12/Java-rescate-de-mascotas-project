package domain.InstanciadorMascotas;

import Adapter.AdapterFabricadorQR;
import domain.Mascotas.Mascota;
import domain.Mascotas.TipoQR;

public class GeneradorQR implements InterfazGeneracionQR{
    private static GeneradorQR generadorQR;
    private String mensaje;
    private Adapter.AdapterFabricadorQR adapterQR;
    private String pathFile;

    private GeneradorQR(){}
    public static GeneradorQR getGeneradorQR(){
        if(generadorQR==null){
            generadorQR= new GeneradorQR();
        }
        return generadorQR;
    }

    public String getMensaje() {
        return mensaje;
    }

    public AdapterFabricadorQR getAdapterQR() {
        return adapterQR;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setAtributosGeneradorQR(AdapterFabricadorQR adapterQR, String mensaje, String pathFile) {
        this.mensaje = mensaje;
        this.adapterQR = adapterQR;
        this.pathFile = pathFile;
    }
    public void crear() throws Exception {
        adapterQR.crear(mensaje,pathFile);
    }

    @Override
    public TipoQR generarQR(Mascota mascota) {
        TipoQR nuevoQr= new TipoQR();
        nuevoQr.setPath(mensaje);
        return nuevoQr;
    }

}
