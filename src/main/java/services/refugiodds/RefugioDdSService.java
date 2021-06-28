package services.refugiodds;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import services.refugiodds.entidades.ListadoDeHogares;

public interface RefugioDdSService {

    @GET("hogares")
    Call<ListadoDeHogares> hogares(
            @Header("authorization") String authorization,
            @Query("offset") int offset
    );

}
