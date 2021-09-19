package domain.entities.utils.normalizador.NormalizadorDeImagen;

import domain.entities.utils.normalizador.Adapter.AdapterNormalizador;
import domain.entities.utils.normalizador.Parametros.CalidadImagen;
import domain.entities.utils.normalizador.Parametros.Imagen;
import domain.entities.utils.normalizador.Parametros.TamanioImagen;

public class NormalizarImagen {
    private AdapterNormalizador normalizador;
    private Imagen imagen;
    private CalidadImagen calidadImagen;
    private TamanioImagen tamanio;

    public NormalizarImagen(AdapterNormalizador normalizador, Imagen imagen, CalidadImagen calidadImagen, TamanioImagen tamanio) {
        this.normalizador = normalizador;
        this.imagen = imagen;
        this.calidadImagen = calidadImagen;
        this.tamanio = tamanio;
    }

    public Imagen normalizar(){
        return normalizador.normalizarImagen(this.imagen,this.tamanio,this.calidadImagen);
    }

}
