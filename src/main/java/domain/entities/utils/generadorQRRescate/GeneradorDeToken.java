package domain.entities.utils.generadorQRRescate;

public class GeneradorDeToken implements AdapterGeneradorToken{
    private JWTUtil jwt;
    public String generarToken(String id, String nombreMascota) {
            return jwt.createToken(id,nombreMascota);
    }
}
