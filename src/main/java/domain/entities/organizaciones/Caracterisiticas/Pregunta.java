package domain.entities.Organizaciones.Caracterisiticas;

public class Pregunta {
    private String descripcion;
    private InterfazValor interfazValor;

    public Pregunta(){
        this.interfazValor=null;
    }
    public Pregunta descripcion(String descripcion){
        this.descripcion=descripcion;
        return this;
    }
    public Pregunta valor(InterfazValor interfazValor){
        this.interfazValor=interfazValor;
        return this;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public String getValor() {
        return descripcion;
    }


    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }

}
