package domain.entities.mascotas;

import domain.entities.utils.generadorToken.GeneradorToken;
import domain.entities.utils.normalizador.Adapter.AdapterNormalizador;

import java.util.List;
import java.util.stream.Collectors;

// singleton
public final class RegistroDeMascotasHandler implements GeneradorToken{
    private static RegistroDeMascotasHandler registroDeMascotasHandler;
    private static AdapterNormalizador normalizadorImagen;
    private static GeneradorToken generadorToken;


    public static RegistroDeMascotasHandler getInstancia() {
        if (registroDeMascotasHandler == null) {
            registroDeMascotasHandler = new RegistroDeMascotasHandler();
        }
        return registroDeMascotasHandler;
    }
    public String generarToken(){
        return this.generadorToken.generarToken();
    }
    public FotoMascota normalizarFoto(FotoMascota foto){
            return null; // TODO: gogo aplicar normalizador
    }
    public List<FotoMascota> normalizarFotos(List<FotoMascota> fotos){
        return fotos.stream().map(foto->normalizarFoto(foto)).collect(Collectors.toList());
    }



}

