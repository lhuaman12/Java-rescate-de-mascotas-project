package rescate;

import domain.entities.mascotas.*;
import domain.entities.usuarios.Usuario;
import domain.entities.utils.QR.GeneradorQRRescate;
import domain.entities.utils.QR.JWTUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.junit.Assert;
import org.junit.Test;

public class RescatesTest {
    @Test
    public void generarTokenTest(){

        JWTUtil jwt = new JWTUtil();
        String token = jwt.createRescateToken("1.jpg","firulais");
        System.out.println(token);
        Jws<Claims> parsed= jwt.leerToken(token);

        System.out.println(parsed.getBody());

        System.out.println(jwt.getSecretCode());
    }
    @Test
    public void generarQRRescate() throws Exception {
        /*
        MascotaRegistrada mascota = new MascotaRegistrada();
        mascota.setNombre("Carlos");
        mascota.setApodo("Firulais");
        mascota.setTipoMascota(TipoMascota.PERRO);
        mascota.setTamanioMascota(TamanioMascota.GRANDE);
        mascota.setSexo(Sexo.HEMBRA);

        Usuario duenio = new Usuario();
        duenio.setId(1);
        mascota.setId(2);
        */
        /*
        RegistroDeMascotasHandler utilRegistro = RegistroDeMascotasHandler.getInstancia();
        String resp = utilRegistro.crearQR(mascota,duenio);
        mascota.setQRPath(resp);
        Assert.assertNotEquals(null,resp); */

    }
    @Test
    public void leerTokenRescate() throws Exception {

        MascotaRegistrada mascota = new MascotaRegistrada();
        mascota.setNombre("Carlos");
        mascota.setApodo("Firulais");
        mascota.setTipoMascota(TipoMascota.PERRO);
        mascota.setTamanioMascota(TamanioMascota.GRANDE);
        mascota.setSexo(Sexo.HEMBRA);

        Usuario duenio = new Usuario();
        duenio.setId(1);
        mascota.setId(1);
        // RegistroDeMascotasHandler utilRegistro = RegistroDeMascotasHandler.getInstancia();
        GeneradorQRRescate generador = new GeneradorQRRescate();
        String URLRescate = generador.generarURL(String.valueOf(mascota.getId()), mascota.getNombre());


        /*
        JWTUtil jwt = new JWTUtil();
        Jws<Claims> parsed= jwt.leerToken();
        String idMascota = parsed.getBody().getId();

        System.out.println(parsed.getBody().getSubject());
        Assert.assertEquals(mascota.getId(),idMascota);
        */
    }
}
