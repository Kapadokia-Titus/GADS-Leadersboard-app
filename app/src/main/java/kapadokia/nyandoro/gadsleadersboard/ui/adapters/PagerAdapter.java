package kapadokia.nyandoro.gadsleadersboard.ui.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import kapadokia.nyandoro.gadsleadersboard.ui.views.HoursFragment;
import kapadokia.nyandoro.gadsleadersboard.ui.views.SkillIqFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    int mNumOfTabs;
    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.mNumOfTabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new HoursFragment();
            case 1: return new SkillIqFragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
