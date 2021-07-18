package domain.InstanciadorMascotas;

import domain.Mascotas.Imagen;
import domain.Mascotas.Mascota;
import domain.Mascotas.TipoQR;
import domain.Organizaciones.Organizacion;
import domain.Plataforma.Plataforma;
import domain.Usuarios.ImplementacionMascota;

import java.util.List;

public class InstanciadorMascotas {
    private static InstanciadorMascotas instanciadorMascotas;
    private Plataforma plataforma;
    private InterfazNormalizadorFotos interfazNormalizadorFotos;
    private InterfazGeneracionQR interfazGeneracionQR;
    private ImplementacionMascota implementacionMascota;


    private InstanciadorMascotas() { }
    public static InstanciadorMascotas getInstanciadorMascotas(){
        if(instanciadorMascotas==null){
            instanciadorMascotas= new InstanciadorMascotas();
        }
        return instanciadorMascotas;
    }

    public void setImplementacionMascota(ImplementacionMascota implementacionMascota) {
        this.implementacionMascota = implementacionMascota;
    }

    public void registrarMascota(Mascota mascota,ImplementacionMascota usuario,Organizacion org){
        List<Imagen> fotosNormalizadas = this.interfazNormalizadorFotos.normalizarFotos(mascota.getFotos(),org);
        TipoQR codigoMascota = this.interfazGeneracionQR.generarQR(mascota);
        if(fotosNormalizadas!=null && codigoMascota!=null){
                implementacionMascota.registrarMascota(mascota,org);
                implementacionMascota.reemplazarFotos(mascota,fotosNormalizadas);
                implementacionMascota.agregarQR(mascota,codigoMascota);
                implementacionMascota.agregarToken(mascota,null);
                implementacionMascota.asociarDuenio(mascota);
        }else{
            System.out.println("Error en la instanciación de la mascota. Intente más tarde");
        }
    }

    public InstanciadorMascotas setConfiguraciones(Plataforma plataforma, NormalizadorFotos normalizadorFotos, GeneradorQR generadorQR){
        this.plataforma=plataforma;
        this.interfazNormalizadorFotos=normalizadorFotos;
        this.interfazGeneracionQR=generadorQR;
        return instanciadorMascotas;
    }
}
