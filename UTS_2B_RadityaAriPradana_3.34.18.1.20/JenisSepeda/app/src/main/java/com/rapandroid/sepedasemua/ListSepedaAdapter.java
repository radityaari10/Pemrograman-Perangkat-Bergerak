package com.rapandroid.sepedasemua;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListSepedaAdapter extends RecyclerView.Adapter<ListSepedaAdapter.ListViewHolder>{
    private ArrayList<Sepeda> listSepeda;
    private Context context;
    //private OnItemClickCallback onItemClickCallback;

    //void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
    //  this.onItemClickCallback = onItemClickCallback;
    //}
    public ListSepedaAdapter(Context context, ArrayList<Sepeda> list){
        this.listSepeda = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ListSepedaAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_sepeda,
                parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListSepedaAdapter.ListViewHolder holder, int position) {
        final Sepeda sepeda = listSepeda.get(position);

        Glide.with(holder.itemView.getContext())
                .load(sepeda.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);

        holder.tvName.setText(sepeda.getName());
        holder.tvDesc.setText(sepeda.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDesc = itemView.findViewById(R.id.tv_item_desc);
        }
    }

    //public interface OnItemClickCallback {
    //    void onItemClicked(Sepeda data);
    //}
}
