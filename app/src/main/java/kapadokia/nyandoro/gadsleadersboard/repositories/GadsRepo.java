package kapadokia.nyandoro.gadsleadersboard.repositories;

import androidx.lifecycle.MutableLiveData;

import kapadokia.nyandoro.gadsleadersboard.data.model.Hour;
import kapadokia.nyandoro.gadsleadersboard.data.model.Skilliq;

public interface GadsRepo {

    MutableLiveData<Hour> getAllHours();
    MutableLiveData<Skilliq> getAllSkillIq();
}
