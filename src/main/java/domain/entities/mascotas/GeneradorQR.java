package domain.entities.mascotas;

import com.google.zxing.WriterException;
import domain.entities.usuarios.Usuario;

import java.io.IOException;

public interface GeneradorQR {
    public String crearQR(MascotaRegistrada mascota, Usuario usuario) throws Exception;
}
