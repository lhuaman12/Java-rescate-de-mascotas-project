package Usuarios;

import Mascotas.Foto;
import Mascotas.Mascota;
import Mascotas.TipoQR;
import Organizaciones.Organizacion;

import java.util.List;

public interface ImplementacionMascota {
    void registrarMascota(Mascota mascota, Organizacion org);

    void reemplazarFotos(Mascota mascota, List<Foto> fotosNormalizadas);

    void agregarQR(Mascota mascota, TipoQR codigoMascota);
}
