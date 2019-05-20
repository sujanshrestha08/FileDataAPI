package adapters;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.e.filedataapi.R;

import java.util.ArrayList;

import model.Heroes;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.MyHolder> {

    private Context context;
    private ArrayList<Heroes> listHeroes;

    public HeroAdapter(Context context, ArrayList<Heroes> listHeroes){
        this.context = context;
        this.listHeroes = listHeroes;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_hero, viewGroup, false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        Heroes heroes = listHeroes.get(i);
        myHolder.tvName.setText(heroes.getName());
        myHolder.tvDesc.setText(heroes.getDesc());
    }

    public void updateData(ArrayList<Heroes> list){
        this.listHeroes.clear();
        this.listHeroes.addAll(list);
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listHeroes.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{

        private ImageView imgProfile;
        private TextView tvName, tvDesc;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile = itemView.findViewById(R.id.imgProfile);
            tvName = itemView.findViewById(R.id.tvName);
            tvDesc = itemView.findViewById(R.id.tvDesc);
        }
    }
}
