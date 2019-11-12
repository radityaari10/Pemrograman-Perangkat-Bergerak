package com.rapandroid.sepedasemua;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardSepedaAdapter extends RecyclerView.Adapter<CardSepedaAdapter.ListViewHolder> {
    private ArrayList<Sepeda> listSepeda;
    private Context context;

    public CardSepedaAdapter(Context context, ArrayList<Sepeda> listSepeda){
        this.listSepeda = listSepeda;
        this.context = context;
    }
    @NonNull
    @Override
    public CardSepedaAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_sepeda, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardSepedaAdapter.ListViewHolder holder, int position) {
        final Sepeda sepeda = listSepeda.get(position);
        Glide.with(holder.itemView.getContext())
                .load(sepeda.getPhoto())
                .apply(new RequestOptions().fitCenter())
                .into(holder.imgPhoto);
        holder.tvName.setText(sepeda.getName());
        holder.tvDesc.setText(sepeda.getDescription());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detail = new Intent(context, DetailItemSepedaActivity.class);
                detail.putExtra("sepeda_id", sepeda.getId());
                context.startActivity(detail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listSepeda.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDesc;
        CardView cv;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.list_img_sepeda);
            tvName = itemView.findViewById(R.id.list_name_sepeda);
            tvDesc = itemView.findViewById(R.id.list_desc_sepeda);
            cv = itemView.findViewById(R.id.item_cardview);
        }
    }
}
