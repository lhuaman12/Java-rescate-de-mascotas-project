package domain.InstanciadorMascotas;


import domain.InstanciadorMascotas.Adapter.AdapterNormalizador;
import domain.Mascotas.Imagen;
import domain.Organizaciones.Configuraciones.CalidadImagen;
import domain.Organizaciones.Configuraciones.TamanioImagen;
import domain.Organizaciones.Organizacion;



import java.util.List;
import java.util.stream.Collectors;

public class NormalizadorFotos implements InterfazNormalizadorFotos{
    private static NormalizadorFotos normalizadorFotos;
    private AdapterNormalizador adapterNormalizadorImagen;

    private NormalizadorFotos(){}
    public static NormalizadorFotos getNormalizadorFotos(){
        if(normalizadorFotos==null){
            normalizadorFotos= new NormalizadorFotos();
        }
        return normalizadorFotos;
    }



    @Override
    public List<Imagen> normalizarFotos(List<Imagen> fotos, Organizacion org) {
        TamanioImagen tamanioImagen= org.getConfiguracionImagen().getTamanioImagen();
        CalidadImagen calidadImagen = org.getConfiguracionImagen().getCalidadImagen();
        return fotos.stream().map(foto -> this.adapterNormalizadorImagen.normalizarImagen(foto,tamanioImagen,calidadImagen)).collect(Collectors.toList());

    }

}
