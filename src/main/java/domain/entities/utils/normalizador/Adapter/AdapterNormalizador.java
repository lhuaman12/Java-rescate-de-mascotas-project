package domain.entities.utils.normalizador.Adapter;


import domain.entities.mascotas.FotoMascota;
import domain.entities.organizaciones.Configuraciones.CalidadImagen;
import domain.entities.organizaciones.Configuraciones.TamanioImagen;


public interface AdapterNormalizador {
    public void normalizarImagen(FotoMascota fotomascota, CalidadImagen calidadImagen, TamanioImagen tamanioImagen);
}
