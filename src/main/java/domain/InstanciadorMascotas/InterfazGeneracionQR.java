package domain.InstanciadorMascotas;

import domain.Mascotas.Mascota;
import domain.Mascotas.TipoQR;

public interface InterfazGeneracionQR {

    TipoQR generarQR(Mascota mascota);

}
