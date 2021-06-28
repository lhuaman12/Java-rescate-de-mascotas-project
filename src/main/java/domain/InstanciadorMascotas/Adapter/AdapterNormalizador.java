package domain.InstanciadorMascotas.Adapter;


import domain.Mascotas.Imagen;
import domain.Organizaciones.Configuraciones.CalidadImagen;
import domain.Organizaciones.Configuraciones.TamanioImagen;

public interface AdapterNormalizador {
    public Imagen normalizarImagen(Imagen imagen, TamanioImagen tamanioImagen, CalidadImagen calidadImagen);
}
