package kapadokia.nyandoro.gadsleadersboard.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import kapadokia.nyandoro.gadsleadersboard.R;
import kapadokia.nyandoro.gadsleadersboard.data.model.Hour;

public class HoursAdapter extends RecyclerView.Adapter<HoursAdapter.MyHoursAdapter> {

    private List<Hour> hourList;
    private Context context;


    public HoursAdapter(Hour hour, Context context){
        hourList.add(hour);
        this.context =context;
    }

    public class MyHoursAdapter extends RecyclerView.ViewHolder{

        TextView name, description;
        ImageView imageView;
        public MyHoursAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.user_place);
            description = itemView.findViewById(R.id.description_place);
            imageView = itemView.findViewById(R.id.image_place);
        }
    }



    @NonNull
    @Override
    public MyHoursAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lists, parent,false);
        return new MyHoursAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHoursAdapter holder, int position) {
        Hour hour = hourList.get(position);
        holder.name.setText(hour.getName());
        holder.description.setText(hour.getHours());
        Glide.with(holder.itemView.getContext()).load(hour.getBadgeUrl()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return hourList.size();
    }
}
