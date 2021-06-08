package services.refugiodds;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import services.refugiodds.entidades.ListadoDeHogares;

public interface RefugioDdSService {

    @Headers({
            "Authorization: Bearer "
    })
    @GET("hogares")
    Call<ListadoDeHogares> hogares(@Query("offset") int offset);
}
