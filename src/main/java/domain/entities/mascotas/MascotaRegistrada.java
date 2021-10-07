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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public LocalDate getEdadAprox() {
        return edadAprox;
    }

    public void setEdadAprox(LocalDate edadAprox) {
        this.edadAprox = edadAprox;
    }

    public String getQRPath() {
        return QRPath;
    }

    public void setQRPath(String QRPath) {
        this.QRPath = QRPath;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getTokenRescate() {
        return tokenRescate;
    }

    public void setTokenRescate(String tokenRescate) {
        this.tokenRescate = tokenRescate;
    }

    public List<CaracteristicasONG> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<CaracteristicasONG> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}


