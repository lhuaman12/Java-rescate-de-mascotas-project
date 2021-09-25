package domain.entities.utils.refugiodds;


import domain.entities.mascotas.MascotaPerdida;
import domain.entities.utils.refugiodds.entidades.Hogar;
import domain.entities.utils.refugiodds.entidades.ListadoDeHogares;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BuscadorDeHogaresService {


    private static BuscadorDeHogaresService instancia = null;
    private final static String urlAPI = "https://api.refugiosdds.com.ar/api/";
    private Retrofit retrofit;


    private BuscadorDeHogaresService() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(urlAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public static BuscadorDeHogaresService getInstancia() {
        if (instancia == null) {
            instancia = new BuscadorDeHogaresService();
        }
        return instancia;
    }


    public ListadoDeHogares getListadoDeHogares(int offset) throws IOException {

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

    public List<Hogar> hogaresDisponibles() throws IOException{
        List<Hogar> listado = new ArrayList<Hogar>();
        int offset = 0;
        while(offset < 4) {
            offset++;
            listado.addAll(this.getListadoDeHogares(offset).hogares);
        }
        return listado;
    }

    public List<Hogar> buscarHogar(MascotaPerdida mascotaPerdida) throws IOException {
        List<Hogar> hogares = hogaresDisponibles();
        return hogares.stream().filter(hogar->hogar.admiteMascota(mascotaPerdida)).collect(Collectors.toList());

    }

}
