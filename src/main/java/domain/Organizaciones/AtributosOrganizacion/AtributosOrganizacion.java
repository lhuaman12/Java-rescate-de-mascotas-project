package domain.Organizaciones.AtributosOrganizacion;

import domain.Organizaciones.Caracterisiticas.Caracterisitica;
import domain.Organizaciones.Caracterisiticas.Pregunta;
import domain.Organizaciones.Configuraciones.ConfiguracionImagen;

import java.util.ArrayList;
import java.util.List;

public class AtributosOrganizacion {
    private List<Caracterisitica> caracteristicas;
    private List<Pregunta> preguntas;
    private ConfiguracionImagen configuracionImagen;

    public AtributosOrganizacion() {
        this.caracteristicas= new ArrayList<>();
        this.preguntas = new ArrayList<>();
        this.configuracionImagen=null;
    }


    public void setConfiguracionImagen(ConfiguracionImagen configuracionImagen) {
        this.setConfiguracionImagen(configuracionImagen);
    }


    public ConfiguracionImagen getConfiguracionImagen() {
        return configuracionImagen;
    }


    public void agregarCaracteristica(Caracterisitica caracterisitica) {
        this.caracteristicas.add(caracterisitica);
    }
    public void quitarCaracteristica(Caracterisitica caracterisitica) {
        this.caracteristicas.remove(caracterisitica);
    }

    public void agregarCaracteristicas(List<Caracterisitica> caracterisiticas) {
        this.caracteristicas.addAll(caracterisiticas);
    }

    public List<Caracterisitica> getCaracteristicas() {
        return caracteristicas;
    }
}
