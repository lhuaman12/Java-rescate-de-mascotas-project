package domain.entities.utils.QR;


import config.Config;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.security.Key;

public class JWTUtil {

    //public static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public static SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(Config.secretToken));

    public String createRescateToken(String idMascota, String nombreMascota){
        //Header header = Header
        return Jwts.builder().setId(idMascota).setSubject("mascota_perdida").signWith(key).compact();
    }
    public String getSecretCode(){ // TODO: borrar luego esto no es seguro tener el secret en el codigo,tampoco usar el id (se podria hashear)
        return Encoders.BASE64.encode(key.getEncoded());
    }
    public Boolean verificarToken(String token){
        return false;
    }
    public Jws<Claims> leerToken(String token){
        //Jws<Claims> jws;
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token); //payload
        }
        catch (JwtException e){
            System.out.println(e.getCause());
            return null;
        }
    }

    public String parseURLRescate(String URL){
        return null;
    }

}

