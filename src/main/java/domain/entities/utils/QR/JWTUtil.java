package domain.entities.utils.QR;


import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

// We need a signing key, so we'll create one just for this example. Usually
// the key would be read from your application configuration instead.

public class JWTUtil {

    public static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    //String jws = Jwts.builder().setSubject("Joe").signWith(key).compact();

    public String createToken(String idDuenio,String nombreMascota){
        //Header header = Header
        return Jwts.builder().setId(idDuenio).setSubject("mascota_perdida").claim("nombre_mascota",nombreMascota).signWith(key).compact();
    }
    public String getSecretCode(){ // TODO: borrar luego esto no es seguro tener el secret en el codigo,tampoco usar el id (se podria hashear)
        return Encoders.BASE64.encode(key.getEncoded());
    }
    public Boolean verificarToken(String token){
        return false;
    }
    public Jws<Claims> leerRequest(String token){
        //Jws<Claims> jws;
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token); //payload
        }
        catch (JwtException e){
            System.out.println(e.getCause());
            return null;
        }
    }

}

