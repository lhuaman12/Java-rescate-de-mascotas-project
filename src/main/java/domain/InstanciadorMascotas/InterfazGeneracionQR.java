package domain.InstanciadorMascotas;

import domain.Mascotas.Mascota;
import domain.Mascotas.TipoQR;

public interface InterfazGeneracionQR {
    Boolean validarRegistroMascota(Mascota mascota);
    TipoQR generarQR(Mascota mascota);
}
