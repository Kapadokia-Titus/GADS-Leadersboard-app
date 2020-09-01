package kapadokia.nyandoro.gadsleadersboard.repositories;


import androidx.lifecycle.MutableLiveData;

import kapadokia.nyandoro.gadsleadersboard.data.datastates.HoursDataState;
import kapadokia.nyandoro.gadsleadersboard.data.datastates.SkillIqDataState;
import kapadokia.nyandoro.gadsleadersboard.data.model.Hour;
import kapadokia.nyandoro.gadsleadersboard.data.remote.ApiClient;
import kapadokia.nyandoro.gadsleadersboard.data.remote.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GadsRepoImpl  implements GadsRepo{
 // to implement from here

    public GadsRepoImpl(){

    }

    private ApiService apiService = new ApiClient().getClient().create(ApiService.class);
    @Override
    public MutableLiveData<HoursDataState> getAllHours() {

        final MutableLiveData<HoursDataState> hoursDataStateMutableLiveData = new MutableLiveData<>();
        Call<Hour> call = apiService.getHours();

        call.enqueue(new Callback<Hour>() {
            @Override
            public void onResponse(Call<Hour> call, Response<Hour> response) {
                hoursDataStateMutableLiveData.postValue(new HoursDataState(response.body()));
            }

            @Override
            public void onFailure(Call<Hour> call, Throwable t) {
                hoursDataStateMutableLiveData.postValue(new HoursDataState(t));
            }
        });

        return hoursDataStateMutableLiveData;
    }

    @Override
    public MutableLiveData<SkillIqDataState> getAllSkillIq() {
        return null;
    }
}
