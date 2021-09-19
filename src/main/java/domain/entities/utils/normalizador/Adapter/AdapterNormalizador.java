package domain.entities.utils.normalizador.Adapter;


import domain.entities.utils.normalizador.Parametros.CalidadImagen;
import domain.entities.utils.normalizador.Parametros.Imagen;
import domain.entities.utils.normalizador.Parametros.TamanioImagen;

public interface AdapterNormalizador {
    public Imagen normalizarImagen(Imagen imagen, TamanioImagen tamanioImagen, CalidadImagen calidadImagen);
}
