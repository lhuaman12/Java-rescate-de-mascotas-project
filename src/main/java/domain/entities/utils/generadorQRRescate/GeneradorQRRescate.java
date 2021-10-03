package domain.entities.utils.generadorQRRescate;

import Adapter.AdapterQR.ZXing.ZXingAdapter;
import domain.entities.mascotas.QRRescate;
import domain.entities.utils.QR.QR.FabricadorQR;

public class GeneradorQRRescate implements AdapterGeneradorToken {
    private final String pathFile="src/main/resources/dueniosQRs";
    private final String URLBase="https://patitas.com?rescate_id=";
    private AdapterGeneradorToken generadorToken;

    //private FabricadorQR AdapterfabricadorQR;

    @Override
    public String generarToken(String id, String nombreMascota) {
        return generadorToken.generarToken(id,nombreMascota);
    }

    public String generarURL(String id,String nombreMascota){
        return URLBase+generarToken(id,nombreMascota);
    }

    public QRRescate generarQRRescate(String id,String nombreMascota,String URLBase) throws Exception {
        String URL = generarURL(id,nombreMascota);
        FabricadorQR fabricadorQR = new FabricadorQR(new ZXingAdapter(),URL);
        return fabricadorQR.crear(id,pathFile);

    }
}
