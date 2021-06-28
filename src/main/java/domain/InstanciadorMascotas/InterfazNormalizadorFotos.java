package domain.InstanciadorMascotas;

import domain.Mascotas.Imagen;
import domain.Organizaciones.Organizacion;

import java.util.List;

public interface InterfazNormalizadorFotos {

    List<Imagen> normalizarFotos(List<Imagen> fotos, Organizacion org);
}
