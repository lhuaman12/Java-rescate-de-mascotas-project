package domain.InstanciadorMascotas;

import domain.Mascotas.Foto;
import domain.Mascotas.Mascota;
import domain.Organizaciones.Organizacion;

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
