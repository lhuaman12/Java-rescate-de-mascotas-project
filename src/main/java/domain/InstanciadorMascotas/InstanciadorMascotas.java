package InstanciadorMascotas;

import InstanciadorCuentas.InstanciadorCuenta;
import Mascotas.Foto;
import Mascotas.Mascota;
import Mascotas.TipoQR;
import Organizaciones.Organizacion;
import Plataforma.Plataforma;
import Usuarios.ImplementacionMascota;

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

    public Boolean validarRegistroMascota(Mascota mascota){
        Boolean r1= this.interfazNormalizadorFotos.validarRegistroMascota(mascota);
        Boolean r2=this.interfazGeneracionQR.validarRegistroMascota(mascota);
        return r1 && r2;
    }

    public void registrarMascota(Mascota mascota,ImplementacionMascota usuario,Organizacion org){
        List<Foto> fotosNormalizadas = this.interfazNormalizadorFotos.normalizarFotos(mascota.getFotos(),org);
        TipoQR codigoMascota = this.interfazGeneracionQR.generarQR(mascota);
        Boolean validRegistro= this.validarRegistroMascota(mascota);
        if(validRegistro==true){
                implementacionMascota.registrarMascota(mascota,org);
                implementacionMascota.reemplazarFotos(mascota,fotosNormalizadas);
                implementacionMascota.agregarQR(mascota,codigoMascota);
        }else{
            System.out.println("Error en la creacion de usuario. Intente más tarde");
        }
    }

    public InstanciadorMascotas setConfiguraciones(Plataforma plataforma, NormalizadorFotos normalizadorFotos, GeneradorQR generadorQR){
        this.plataforma=plataforma;
        this.interfazNormalizadorFotos=normalizadorFotos;
        this.interfazGeneracionQR=generadorQR;
        return instanciadorMascotas;
    }
}
