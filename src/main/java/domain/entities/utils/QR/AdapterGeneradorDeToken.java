package domain.entities.utils.QR;

public class AdapterGeneradorDeToken implements GeneradorToken {
    public JWTUtil jwt = new JWTUtil();
    public String generarToken(String id, String nombreMascota) {
            return jwt.createToken(id,nombreMascota);
    }
}
