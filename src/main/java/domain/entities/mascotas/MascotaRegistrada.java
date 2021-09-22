package domain.entities.mascotas;

import domain.entities.organizaciones.AtributosOrganizacion.Parametros.CaracteristicaParaRegistro;

import java.time.LocalDate;
import java.util.List;

public class MascotaRegistrada extends MascotaBasica {

    private int id;

    private String nombre;

    private String apodo;

    private LocalDate edadAprox;

    private String QRPath;

    private java.time.LocalDate fechaAlta;

    private String tokenRescate;

    private List<CaracteristicaParaRegistro> caracteristicas;


    // constructor
    public MascotaRegistrada(
            String nombre,
            String apodo,
            TipoMascota tipoMascota,
            LocalDate edadAproximada,
            TamanioMascota tamanioMascota,
            Boolean tieneDiscapacidad,
            String descripcionDiscapacidad,
            Sexo sexo,
            List<FotoMascota> fotos
    ) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.tipoMascota = tipoMascota;
        this.edadAprox = edadAprox;
        this.tamanioMascota = tamanioMascota;
        this.tieneDiscapacidad = tieneDiscapacidad;
        this.descripcionDiscapacidad = descripcionDiscapacidad;
        this.sexo = sexo;
        this.fotoMascotas=fotos;

    }

    public void agregarQR(String QRPath){
        this.QRPath=QRPath;
    }
    public void agregarToken(String token){
        this.tokenRescate = token;
    }

}


