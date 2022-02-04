package domain.entities.utils.QR;

import domain.entities.mascotas.MascotaRegistrada;
import domain.entities.usuarios.Usuario;
import domain.entities.utils.QR.AdapteeQR.ZXing;

public class GeneradorQRRescate implements GeneradorToken {
    private final String pathFile="src/main/resources/mascotas_info/QRs";
    private final String URLBase="https://patitas.com?rescate_id=";
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
        String pathQR = pathFile+"usuario"+String.valueOf(usuario.getId())+".jpg";
        String URL = generarURL(String.valueOf(mascota.getId()),mascota.getApodo());
        adaptee.crearQR(URL,pathQR);
        return pathQR;
    }

}
