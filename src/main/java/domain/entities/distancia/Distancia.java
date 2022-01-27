package domain.entities.distancia;

import java.awt.geom.Point2D;

public class Distancia {

    public static double calcularDistancia(double lat1, double lon1, double lat2, double lon2) {
        //return Point2D.distance(lat1, lon1, lat2, lon2);

        final int R = 6371; // Radio de la Tierra

        double latDistancia = Math.toRadians(lat2 - lat1);
        double lonDistancia = Math.toRadians(lon2 - lon1);

        double a = Math.sin(latDistancia / 2) * Math.sin(latDistancia / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistancia / 2) * Math.sin(lonDistancia / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distancia = R * c;

        return distancia;
    }

}


