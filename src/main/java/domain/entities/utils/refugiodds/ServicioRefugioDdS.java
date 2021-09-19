package domain.entities.utils.refugiodds;


import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import domain.entities.utils.refugiodds.entidades.Hogar;
import domain.entities.utils.refugiodds.entidades.ListadoDeHogares;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        String authorization = "Bearer " +
                System.getenv("DDS_REFUGIODDS_TOKEN");

        RefugioDdSService refugioDdSService = this.retrofit
                .create(RefugioDdSService.class);

        Call<ListadoDeHogares> requestListadoDeHogares =
                refugioDdSService.hogares(authorization, offset);

        Response<ListadoDeHogares> responseListadoDeHogares =
                requestListadoDeHogares.execute();

        return responseListadoDeHogares.body();

    }

    public List<Hogar> hogares() throws IOException{
        List<Hogar> listado = new ArrayList<Hogar>();
        int offset = 0;
        while(offset < 4) {
            offset++;
            listado.addAll(this.listadoDeHogares(offset).hogares);
        }
        return listado;
    }

}
