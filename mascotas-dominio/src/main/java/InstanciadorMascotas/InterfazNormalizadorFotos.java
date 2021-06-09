package InstanciadorMascotas;

import Mascotas.Foto;
import Mascotas.Mascota;
import Organizaciones.Organizacion;

import java.util.List;

public interface InterfazNormalizadorFotos {

    Boolean validarRegistroMascota(Mascota mascota);

    List<Foto> normalizarFotos(List<Foto> fotos, Organizacion org);
}
