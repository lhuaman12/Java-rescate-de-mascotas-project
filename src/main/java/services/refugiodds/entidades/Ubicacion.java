package services.refugiodds.entidades;

import com.google.gson.annotations.SerializedName;

public class Ubicacion {

    public String direccion;
    public double lat;

    @SerializedName("long")
    private double Long;

    public double getLong () {
        return Long;
    }

    public void setNew (double aLong) {
        Long = aLong;
    }

}
