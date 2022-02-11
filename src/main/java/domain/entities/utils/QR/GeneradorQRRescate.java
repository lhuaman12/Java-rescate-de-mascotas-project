package domain.entities.utils.QR;

import domain.entities.mascotas.MascotaRegistrada;
import domain.entities.usuarios.Usuario;
import domain.entities.utils.QR.AdapteeQR.ZXing;

import java.io.File;

public class GeneradorQRRescate implements GeneradorToken {

    private final String rootFolder ="src/main/resources/mascotas_info";
    private final String URLBase="http://localhost:9002/rescate/";
    private ZXing adaptee = new ZXing();
    private GeneradorToken generadorToken = new AdapterGeneradorDeToken();

    @Override
    public String generarToken(String id, String nombreMascota) {
        return generadorToken.generarToken(id,nombreMascota);
    }

    public String generarURL(String id,String nombreMascota){
        return URLBase+generarToken(id,nombreMascota);
    }

    public String crearQR(MascotaRegistrada mascota, Usuario usuario) throws Exception{
        String baseFolder = rootFolder +"/mascota_"+mascota.getId()+"/QR";
        File file = new File(baseFolder);
        file.mkdir();
        String fullPath = baseFolder + "/qrMascota.jpg";
        String URL = generarURL(String.valueOf(mascota.getId()),mascota.getApodo());
        adaptee.crearQR(URL,fullPath);
        return fullPath;
    }

}
