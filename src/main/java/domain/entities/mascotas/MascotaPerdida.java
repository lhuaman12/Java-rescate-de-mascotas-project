package domain.entities.mascotas;

import domain.entities.usuarios.Direccion;
import domain.entities.utils.refugiodds.BuscadorDeHogaresService;
import domain.entities.utils.refugiodds.entidades.Hogar;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.List;

public class MascotaPerdida extends MascotaBasica {
    private EdadAproximada edadAprox;
    private List<FotoMascota> fotos;
    private Point2D coordenadas;
    private Direccion direccion;
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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
