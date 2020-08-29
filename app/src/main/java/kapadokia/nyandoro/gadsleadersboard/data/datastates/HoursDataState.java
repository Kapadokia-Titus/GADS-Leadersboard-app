package kapadokia.nyandoro.gadsleadersboard.data.datastates;

import kapadokia.nyandoro.gadsleadersboard.data.model.Hour;

public class HoursDataState {
    private Hour hour;
    private Throwable throwable;

    public HoursDataState(Hour hour) {
        this.hour = hour;
        this.throwable =null;
    }

    public HoursDataState(Throwable throwable) {
        this.throwable = throwable;
        this.hour = null;
    }


    public Hour getHour() {
        return hour;
    }

    public void setHour(Hour hour) {
        this.hour = hour;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
