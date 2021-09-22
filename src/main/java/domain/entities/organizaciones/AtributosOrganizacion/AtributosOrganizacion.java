package domain.entities.organizaciones.AtributosOrganizacion;

import domain.entities.organizaciones.AtributosOrganizacion.Parametros.CaracteristicaParaRegistro;
import domain.entities.organizaciones.PreguntasDeAdopcion;
import domain.entities.organizaciones.Configuraciones.ConfiguracionImagen;

import java.util.ArrayList;
import java.util.List;

public class AtributosOrganizacion {
    private List<CaracteristicaParaRegistro> caracteristicaParaRegistros;
    private PreguntasDeAdopcion preguntasDeAdopcion;
    private ConfiguracionImagen configuracionImagen;

    public AtributosOrganizacion() {
        this.caracteristicaParaRegistros = new ArrayList<>();
        this.preguntas = new ArrayList<>();
        this.configuracionImagen=null;
    }


    public void setConfiguracionImagen(ConfiguracionImagen configuracionImagen) {
        this.setConfiguracionImagen(configuracionImagen);
    }


    public ConfiguracionImagen getConfiguracionImagen() {
        return configuracionImagen;
    }


    public void agregarCaracteristica(CaracteristicaParaRegistro caracteristicaParaRegistro) {
        this.caracteristicaParaRegistros.add(caracteristicaParaRegistro);
    }
    public void quitarCaracteristica(CaracteristicaParaRegistro caracteristicaParaRegistro) {
        this.caracteristicaParaRegistros.remove(caracteristicaParaRegistro);
    }

    public void agregarCaracteristicas(List<CaracteristicaParaRegistro> caracteristicaParaRegistros) {
        this.caracteristicaParaRegistros.addAll(caracteristicaParaRegistros);
    }

    public List<CaracteristicaParaRegistro> getCaracteristicas() {
        return caracteristicaParaRegistros;
    }

}
