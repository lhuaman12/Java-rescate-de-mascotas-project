package usuarios;

import domain.entities.utils.generadorQRRescate.GeneradorQRRescate;
import domain.entities.utils.generadorQRRescate.JWTUtil;
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
        GeneradorQRRescate generadorQRRescate = new GeneradorQRRescate();

    }
}
