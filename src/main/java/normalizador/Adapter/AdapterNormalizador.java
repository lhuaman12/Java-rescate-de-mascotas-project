package Adapter;


import Parametros.CalidadImagen;
import Parametros.Imagen;
import Parametros.TamanioImagen;

public interface AdapterNormalizador {
    public Imagen normalizarImagen(Imagen imagen, TamanioImagen tamanioImagen, CalidadImagen calidadImagen);
}
