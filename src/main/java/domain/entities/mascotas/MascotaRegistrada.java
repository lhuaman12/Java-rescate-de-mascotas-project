package domain.entities.mascotas;

import domain.entities.organizaciones.PreguntasONG.Atributo;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

public class MascotaRegistrada extends MascotaBasica {
    @Id
    private int id; // TODO: luego de persistir hashear el ID y generar un token

    private String nombre;

    private String apodo;

    private LocalDate edadAprox;

    private String QRPath;

    private java.time.LocalDate fechaAlta;

    private String tokenRescate;

    private List<CaracteristicasONG> caracteristicas;


    // constructor
    public MascotaRegistrada(
            String nombre,
            String apodo,
            TipoMascota tipoMascota,
            LocalDate edadAproximada,
            TamanioMascota tamanioMascota,
            List<CaracteristicasONG> caracteristicas,
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
        this.caracteristicas=caracteristicas;

    }

    public void agregarQR(String QRPath){
        this.QRPath=QRPath;
    }
    public void agregarToken(String token){
        this.tokenRescate = token;
    }

}


