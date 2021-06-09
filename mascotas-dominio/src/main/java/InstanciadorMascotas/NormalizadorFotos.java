package InstanciadorMascotas;

import Mascotas.Foto;
import Mascotas.Mascota;
import Organizaciones.Organizacion;

import java.util.List;

public class NormalizadorFotos implements InterfazNormalizadorFotos{
    private static NormalizadorFotos normalizadorFotos;

    private NormalizadorFotos(){}
    public static NormalizadorFotos normalizadorFotos(){
        if(normalizadorFotos==null){
            normalizadorFotos= new NormalizadorFotos();
        }
        return normalizadorFotos;
    }
    @Override
    public Boolean validarRegistroMascota(Mascota mascota) {
        return true;
    }

    @Override
    public List<Foto> normalizarFotos(List<Foto> fotos, Organizacion org) {
        return null;
    }
}
