package domain.entities.utils.normalizador.Adapter;


import domain.entities.mascotas.foto_mascota;
import domain.entities.organizaciones.Configuraciones.CalidadImagen;
import domain.entities.organizaciones.Configuraciones.TamanioImagen;


public interface AdapterNormalizador {
    public void normalizarImagen(foto_mascota fotomascota, CalidadImagen calidadImagen, TamanioImagen tamanioImagen);
}
