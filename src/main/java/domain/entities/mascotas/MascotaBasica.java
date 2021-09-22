package domain.entities.mascotas;

import java.util.List;

public class MascotaBasica {

    protected TipoMascota tipoMascota;
    protected TamanioMascota tamanioMascota;
    protected Boolean tieneDiscapacidad;
    protected String descripcionDiscapacidad;
    protected Sexo sexo;
    protected List<FotoMascota> fotoMascotas;

    public void agregarFoto(FotoMascota foto){
        this.fotoMascotas.add(foto);
    }

    public TipoMascota getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(TipoMascota tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public TamanioMascota getTamanioMascota() {
        return tamanioMascota;
    }

    public void setTamanioMascota(TamanioMascota tamanioMascota) {
        this.tamanioMascota = tamanioMascota;
    }

    public Boolean getTieneDiscapacidad() {
        return tieneDiscapacidad;
    }

    public void setTieneDiscapacidad(Boolean tieneDiscapacidad) {
        this.tieneDiscapacidad = tieneDiscapacidad;
    }

    public String getDescripcionDiscapacidad() {
        return descripcionDiscapacidad;
    }

    public void setDescripcionDiscapacidad(String descripcionDiscapacidad) {
        this.descripcionDiscapacidad = descripcionDiscapacidad;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public List<FotoMascota> getFotoMascotas() {
        return fotoMascotas;
    }

    public void setFotoMascotas(List<FotoMascota> fotoMascotas) {
        this.fotoMascotas = fotoMascotas;
    }
}
