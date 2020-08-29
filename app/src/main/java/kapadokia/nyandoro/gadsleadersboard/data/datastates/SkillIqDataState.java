package kapadokia.nyandoro.gadsleadersboard.data.datastates;

import kapadokia.nyandoro.gadsleadersboard.data.model.Skilliq;

public class SkillIqDataState {

    private Skilliq skilliq;
    private Throwable throwable;

    public SkillIqDataState(Skilliq skilliq) {
        this.skilliq = skilliq;
        this.throwable = null;
    }

    public SkillIqDataState(Throwable throwable) {
        this.throwable = throwable;
        this.skilliq = null;
    }

    public Skilliq getSkilliq() {
        return skilliq;
    }

    public void setSkilliq(Skilliq skilliq) {
        this.skilliq = skilliq;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
