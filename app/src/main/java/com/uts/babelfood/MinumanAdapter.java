package com.uts.babelfood;

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

public class MinumanAdapter extends RecyclerView.Adapter<MinumanAdapter.MinumanViewHolder> {
    private Context context;
    private List<Minuman> minumanList;

    public MinumanAdapter(Context context, List<Minuman> minumanList) {
        this.context = context;
        this.minumanList = minumanList;
    }

    @NonNull
    @Override
    public MinumanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_minuman, parent, false);
        return new MinumanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MinumanViewHolder holder, int position) {
        Minuman minuman = minumanList.get(position);
        holder.namaMinuman.setText(minuman.getNama_minuman());
        holder.hargaMinuman.setText("Rp " + minuman.getHarga());
        holder.deskripsiMinuman.setText(minuman.getDeskripsi());
        Glide.with(context)
                .load(minuman.getGambar_url())
                .placeholder(R.drawable.baseline_image_not_supported_24)
                .into(holder.gambarMinuman);
    }

    @Override
    public int getItemCount() {
        return minumanList.size();
    }

    public static class MinumanViewHolder extends RecyclerView.ViewHolder {
        TextView namaMinuman, hargaMinuman, deskripsiMinuman;
        ImageView gambarMinuman;

        public MinumanViewHolder(@NonNull View itemView) {
            super(itemView);
            namaMinuman = itemView.findViewById(R.id.namaMinuman);
            hargaMinuman = itemView.findViewById(R.id.hargaMinuman);
            deskripsiMinuman = itemView.findViewById(R.id.deskripsiMinuman);
            gambarMinuman = itemView.findViewById(R.id.gambarMinuman);
        }
    }
}

