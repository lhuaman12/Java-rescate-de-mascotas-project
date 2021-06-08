package services.refugiodds;


import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import services.refugiodds.entidades.ListadoDeHogares;

import java.io.IOException;

public class ServicioRefugioDdS {


    private static ServicioRefugioDdS instancia = null;
    private final static String urlAPI = "https://api.refugiosdds.com.ar/api/";
    private Retrofit retrofit;


    private ServicioRefugioDdS() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(urlAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public static ServicioRefugioDdS getInstancia() {
        if (instancia == null) {
            instancia = new ServicioRefugioDdS();
        }
        return instancia;
    }


    public ListadoDeHogares listadoDeHogares(int offset) throws IOException {
        RefugioDdSService refugioDdSService = this.retrofit.create(RefugioDdSService.class);
        Call<ListadoDeHogares> requestListadoDeHogares = refugioDdSService.hogares(offset);
        Response<ListadoDeHogares> responseListadoDeHogares = requestListadoDeHogares.execute();
        return responseListadoDeHogares.body();
    }

}
