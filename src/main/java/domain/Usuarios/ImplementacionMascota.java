package domain.Usuarios;

import domain.Mascotas.Imagen;
import domain.Mascotas.Mascota;
import domain.Mascotas.TipoQR;
import domain.Organizaciones.Organizacion;

import java.util.List;

public interface ImplementacionMascota {
    void registrarMascota(Mascota mascota, Organizacion org);

    void reemplazarFotos(Mascota mascota, List<Imagen> fotosNormalizadas);

    void agregarQR(Mascota mascota, TipoQR codigoMascota);

    void agregarToken(Mascota mascota, String token_mascota);

    void asociarDuenio(Mascota mascota);
}
