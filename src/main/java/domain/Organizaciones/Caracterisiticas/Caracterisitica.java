package domain.Organizaciones.Caracterisiticas;

public class Caracterisitica {
    private String descripcion;
    private InterfazValor interfazValor;

    public Caracterisitica(){
        this.interfazValor=null;
    }
    public Caracterisitica descripcion(String descripcion){
        this.descripcion=descripcion;
        return this;
    }
    public Caracterisitica valor(InterfazValor interfazValor){
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

