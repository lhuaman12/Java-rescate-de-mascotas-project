package domain.Mascotas;

public class Foto {
    private Integer tamaño;
    private Calidad calidad;

    public Foto(Integer tamaño, Calidad calidad) {
        this.tamaño = tamaño;
        this.calidad = calidad;
    }

    public void cambiarAtributos(Integer tamaño, Calidad calidad){
        this.cambiarTamaño(tamaño);
        this.cambiarCalidad(calidad);
    }

    private void cambiarTamaño(Integer tamaño) {
        this.tamaño=tamaño;
    }
    private void cambiarCalidad(Calidad calidad) {
        this.calidad=calidad;
    }

}
