package domain.entities.mascotas;

import domain.entities.domicilio.Domicilio;
import domain.entities.utils.refugiodds.BuscadorDeHogaresService;
import domain.entities.utils.refugiodds.entidades.Hogar;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.List;

public class MascotaPerdida extends MascotaBasica {
    private EdadAproximada edadAprox;
    private List<FotoMascota> fotos;
    private Point2D coordenadas;
    private Domicilio domicilio;
    private Hogar hogarDeTransito;


    public List<Hogar> buscarHogarDeTransito() throws IOException {
        BuscadorDeHogaresService buscador = BuscadorDeHogaresService.getInstancia();
        return buscador.buscarHogar(this); // TODO: la consulta a la API es sincronica cambiar luego
    }
    public void confimarHogarDeTransito(Hogar hogarDeTransito){
        this.hogarDeTransito = hogarDeTransito;
    }
    public Hogar getHogarDeTransito() {
        return hogarDeTransito;
    }

    public EdadAproximada getEdadAprox() {
        return edadAprox;
    }

    public void setEdadAprox(EdadAproximada edadAprox) {
        this.edadAprox = edadAprox;
    }

    public List<FotoMascota> getFotos() {
        return fotos;
    }

    public void setFotos(List<FotoMascota> fotos) {
        this.fotos = fotos;
    }

    public Point2D getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Point2D coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
}
