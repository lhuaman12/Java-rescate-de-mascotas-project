package normalizador.NormalizadorDeImagen;

import normalizador.Adapter.AdapterNormalizador;
import normalizador.Parametros.CalidadImagen;
import normalizador.Parametros.Imagen;
import normalizador.Parametros.TamanioImagen;

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
