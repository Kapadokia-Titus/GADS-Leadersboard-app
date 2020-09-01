package kapadokia.nyandoro.gadsleadersboard.ui.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import kapadokia.nyandoro.gadsleadersboard.data.datastates.HoursDataState;
import kapadokia.nyandoro.gadsleadersboard.repositories.GadsRepo;
import kapadokia.nyandoro.gadsleadersboard.repositories.GadsRepoImpl;

public class HoursViewModel extends ViewModel {

    private GadsRepo gadsRepo = new GadsRepoImpl();

    public MutableLiveData<HoursDataState> hoursDataStateMutableLiveData = new MutableLiveData<>();

    public void fetchAllHours(){
        hoursDataStateMutableLiveData =(gadsRepo.getAllHours());
    }
}
