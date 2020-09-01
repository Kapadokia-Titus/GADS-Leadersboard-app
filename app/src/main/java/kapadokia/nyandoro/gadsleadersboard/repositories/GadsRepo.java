package kapadokia.nyandoro.gadsleadersboard.repositories;

import androidx.lifecycle.MutableLiveData;

import kapadokia.nyandoro.gadsleadersboard.data.datastates.HoursDataState;
import kapadokia.nyandoro.gadsleadersboard.data.datastates.SkillIqDataState;

public interface GadsRepo {

    MutableLiveData<HoursDataState> getAllHours();
    MutableLiveData<SkillIqDataState> getAllSkillIq();
}
