package domain.entities.utils.normalizador.NormalizadorDeImagen;

import domain.entities.mascotas.foto_mascota;
import domain.entities.organizaciones.Configuraciones.CalidadImagen;
import domain.entities.organizaciones.Configuraciones.TamanioImagen;
import domain.entities.utils.normalizador.Adapter.Adaptees.Adapter1;
import domain.entities.utils.normalizador.Adapter.AdapterNormalizador;


public class NormalizarImagen {
    private AdapterNormalizador normalizador;
    private foto_mascota imagen;
    private CalidadImagen calidadImagen;
    private TamanioImagen tamanio;

    public NormalizarImagen(foto_mascota imagen, CalidadImagen calidadImagen, TamanioImagen tamanio) {
        this.normalizador = new Adapter1();
        this.imagen = imagen;
        this.calidadImagen = calidadImagen;
        this.tamanio = tamanio;
    }

    public void normalizar(){
        this.normalizador.normalizarImagen(this.imagen,this.calidadImagen,this.tamanio);
    }

}
