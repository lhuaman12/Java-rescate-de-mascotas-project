package domain.Plataforma;

import domain.Mascotas.Mascota;
import domain.Mascotas.TipoQR;
import domain.Organizaciones.Organizacion;
import domain.Usuarios.Cuenta;
import domain.Usuarios.Dueño;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Plataforma {

    private static Plataforma plataforma;
    private List<Cuenta> cuentas;
    private List<Organizacion> organizaciones = new ArrayList<>();

    private Plataforma() {
        this.cuentas = new ArrayList<>();
    }

    public static Plataforma getPlataforma() {
        if (plataforma == null) {
            plataforma = new Plataforma();
        }
        return plataforma;
    }
    public List<Cuenta> getCuentas() {
        return cuentas;
    }
    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
    public void addCuenta(Cuenta cuenta) {
        this.cuentas.add(cuenta);
    }
    public Boolean userExists(String user) {
        return cuentas.stream()
               .anyMatch(c -> c.esIgual(user));
    }

    public Organizacion getOrganizacionMasCercana(Point2D.Double ubicacion) {

        List<Double> distancias;
        distancias = organizaciones.stream()
                .flatMapToDouble(o -> DoubleStream.of(o.coordenadas.distance(ubicacion)))
                .boxed()
                .collect(Collectors.toList());

        Integer posicionMenorDistancia= distancias.indexOf(Collections.min(distancias));
        return organizaciones.get(posicionMenorDistancia);

    }

    public void agregarOrganizacion(Organizacion org1) {
        this.organizaciones.add(org1);
    }


    public Dueño buscarDueñoPorQR(TipoQR codigoQR) {
        //Mascota dueñoMascota=this.organizaciones.stream().map(o->o.getMascotaByQR(codigoQR)).findFirst().get();
        return null;
    }
}
