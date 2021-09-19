package domain.entities.utils.refugiodds.entidades;

import com.google.gson.annotations.SerializedName;

public class Ubicacion {

    public String direccion;
    public double lat;

    @SerializedName("long")
    public double Long;

    public double getLong() { return Long; }

    public void setLong(double aLong) {
        Long = aLong;
    }

    public void setNew (double aLong) {
        Long = aLong;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getLat() {
        return lat;
    }
}
