package domain.InstanciadorMascotas;

import domain.Mascotas.Foto;
import domain.Mascotas.Mascota;
import domain.Organizaciones.Organizacion;

import java.util.List;

public interface InterfazNormalizadorFotos {

    Boolean validarRegistroMascota(Mascota mascota);

    List<Foto> normalizarFotos(List<Foto> fotos, Organizacion org);
}
