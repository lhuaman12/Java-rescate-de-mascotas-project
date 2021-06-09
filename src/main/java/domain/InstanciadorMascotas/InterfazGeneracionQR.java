package InstanciadorMascotas;

import Mascotas.Mascota;
import Mascotas.TipoQR;

public interface InterfazGeneracionQR {
    Boolean validarRegistroMascota(Mascota mascota);
    TipoQR generarQR(Mascota mascota);
}
