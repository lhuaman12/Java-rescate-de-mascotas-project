package usuarios;

import domain.entities.mascotas.*;
import domain.entities.usuarios.Usuario;
import domain.entities.utils.QR.GeneradorQRRescate;
import domain.entities.utils.QR.JWTUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.junit.Test;

public class RescatesTest {
    @Test
    public void generarTokenTest(){

        JWTUtil jwt = new JWTUtil();
        String token = jwt.createToken("1","firulais");
        System.out.println(token);
        Jws<Claims> parsed= jwt.leerRequest(token);

        System.out.println(parsed.getBody());

        System.out.println(jwt.getSecretCode());


    }
    public void generarURLRescate(){
        GeneradorQRRescate adapterGeneradorQRRescate = new GeneradorQRRescate();

    }
    @Test
    public void generarQRRescate() throws Exception {
        MascotaRegistrada mascota = new MascotaRegistrada("carlos","firulais", TipoMascota.PERRO,null, TamanioMascota.GRANDE,
                null,null,null, Sexo.HEMBRA,null);
        Usuario duenio = new Usuario();
        duenio.setId(1);
        RegistroDeMascotasHandler utilRegistro = RegistroDeMascotasHandler.getInstancia();
        String resp = utilRegistro.crearQR(mascota,duenio);
    }
}
