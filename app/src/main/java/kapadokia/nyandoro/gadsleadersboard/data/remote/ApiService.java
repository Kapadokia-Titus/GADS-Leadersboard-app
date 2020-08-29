package kapadokia.nyandoro.gadsleadersboard.data.remote;

import kapadokia.nyandoro.gadsleadersboard.data.model.Hour;
import kapadokia.nyandoro.gadsleadersboard.data.model.Skilliq;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    // get hours
    @GET("/api/hours")
    Call<Hour> getHours();

    // get skill Iq
    @GET("/api/skilliq")
    Call<Skilliq> getSkillIq();
}
