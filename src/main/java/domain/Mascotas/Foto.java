package domain.Mascotas;

import domain.Organizaciones.Calidad;

public class Foto {
    private Integer tamanio;
    private Calidad calidad;

    public Foto(Integer tamanio, Calidad calidad) {
        this.tamanio = tamanio;
        this.calidad = calidad;
    }

    public void cambiarAtributos(Integer tamanio, Calidad calidad){
        this.cambiarTamanio(tamanio);
        this.cambiarCalidad(calidad);
    }

    private void cambiarTamanio(Integer tamanio) {
        this.tamanio = tamanio;
    }
    private void cambiarCalidad(Calidad calidad) {
        this.calidad = calidad;
    }

}