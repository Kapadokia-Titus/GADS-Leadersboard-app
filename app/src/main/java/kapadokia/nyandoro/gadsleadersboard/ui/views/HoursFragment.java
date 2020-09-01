package kapadokia.nyandoro.gadsleadersboard.ui.views;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import kapadokia.nyandoro.gadsleadersboard.R;
import kapadokia.nyandoro.gadsleadersboard.data.datastates.HoursDataState;
import kapadokia.nyandoro.gadsleadersboard.data.model.Hour;
import kapadokia.nyandoro.gadsleadersboard.databinding.FragmentHoursBinding;
import kapadokia.nyandoro.gadsleadersboard.ui.adapters.HoursAdapter;
import kapadokia.nyandoro.gadsleadersboard.ui.viewmodels.HoursViewModel;

public class HoursFragment extends Fragment {

    private FragmentHoursBinding binding;
    private HoursViewModel hoursViewModel;
    private List<Hour> hourList;
    private HoursAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHoursBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        hourList = new ArrayList<>();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        hoursViewModel = new ViewModelProvider(this).get(HoursViewModel.class);

        fetchHours();
        observerLiveData();
    }

    private void fetchHours(){
        hoursViewModel.fetchAllHours();
    }

    private void observerLiveData(){
        hoursViewModel.hoursDataStateMutableLiveData.observe(getViewLifecycleOwner(), new Observer<HoursDataState>() {
            @Override
            public void onChanged(HoursDataState hoursDataState) {
                if (hoursDataState.getHour() !=null){
                initView(hoursDataState.getHour());
                    Log.d("hours", "onChanged: " + hoursDataState.getHour());
                }else {
                    handleError(hoursDataState.getThrowable());
                }
            }
        });
    }

    private void handleError(Throwable throwable) {
        Toast.makeText(getContext(),throwable.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
    }
    private void initView(Hour hour){
        adapter =new HoursAdapter(hour, getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.hoursRecycler.setLayoutManager(manager);
        binding.hoursRecycler.setAdapter(adapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}