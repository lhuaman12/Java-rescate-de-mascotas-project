package domain.InstanciadorMascotas;

import domain.InstanciadorCuentas.InstanciadorCuenta;
import domain.Mascotas.Mascota;
import domain.Mascotas.TipoQR;

public class GeneradorQR implements InterfazGeneracionQR{
    private static GeneradorQR generadorQR;

    private GeneradorQR(){}
    public static GeneradorQR getGeneradorQR(){
        if(generadorQR==null){
            generadorQR= new GeneradorQR();
        }
        return generadorQR;
    }

    @Override
    public Boolean validarRegistroMascota(Mascota mascota) {
        return true;
    }

    @Override
    public TipoQR generarQR(Mascota mascota) {
        return null;
    }
}
