package normalizador.Adapter;


import normalizador.Parametros.CalidadImagen;
import normalizador.Parametros.Imagen;
import normalizador.Parametros.TamanioImagen;

public interface AdapterNormalizador {
    public Imagen normalizarImagen(Imagen imagen, TamanioImagen tamanioImagen, CalidadImagen calidadImagen);
}
