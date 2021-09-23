package domain.entities.utils.normalizador.NormalizadorDeImagen;

import domain.entities.mascotas.FotoMascota;
import domain.entities.organizaciones.Configuraciones.CalidadImagen;
import domain.entities.organizaciones.Configuraciones.TamanioImagen;
import domain.entities.utils.normalizador.Adapter.AdapterNormalizador;


public class NormalizarImagen {
    private AdapterNormalizador normalizador;
    private FotoMascota imagen;
    private CalidadImagen calidadImagen;
    private TamanioImagen tamanio;

    public NormalizarImagen(AdapterNormalizador normalizador, FotoMascota imagen, CalidadImagen calidadImagen, TamanioImagen tamanio) {
        this.normalizador = normalizador;
        this.imagen = imagen;
        this.calidadImagen = calidadImagen;
        this.tamanio = tamanio;
    }

    public void normalizar(){
        this.normalizador.normalizarImagen(this.imagen,this.calidadImagen,this.tamanio);
    }

}
