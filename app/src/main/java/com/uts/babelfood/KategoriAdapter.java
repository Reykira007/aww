package com.uts.babelfood;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uts.babelfood.fragment.HomeFragment;

import java.util.List;

public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.KategoriViewHolder> {
    private Context context;
    private List<Kategori> kategoriList;

    public KategoriAdapter(Context context, List<Kategori> kategoriList) {
        this.context = context;
        this.kategoriList = kategoriList;
    }

    @NonNull
    @Override
    public KategoriViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false);
        return new KategoriViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KategoriViewHolder holder, int position) {
        Kategori kategori = kategoriList.get(position);
        holder.namaKategori.setText(kategori.getNama_kategori());

        switch (kategori.getNama_kategori()) {
            case "Makanan":
                holder.ikonKategori.setImageResource(R.drawable.makanan);
                break;
            case "Minuman":
                holder.ikonKategori.setImageResource(R.drawable.minuman);
                break;
            case "Promo":
                holder.ikonKategori.setImageResource(R.drawable.promo);
                break;
            case "Informasi":
                holder.ikonKategori.setImageResource(R.drawable.informasi);
                break;
            default:
                holder.ikonKategori.setImageResource(R.drawable.baseline_image_not_supported_24);
                break;
        }

        holder.itemView.setOnClickListener(v -> {
            Intent intent;
            switch (kategori.getNama_kategori()) {
                case "Makanan":
                    intent = new Intent(context, FoodActivity.class);
                    break;
                case "Minuman":
                    intent = new Intent(context, DrinkActivity.class);
                    break;
                case "Promo":
                    intent = new Intent(context, PromoActivity.class);
                    break;
                case "Informasi":
                    intent = new Intent(context, InformasiActivity.class);
                    break;
                default:
                    intent = new Intent(context, HomeFragment.class); // Default Activity
                    break;
            }
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return kategoriList.size();
    }

    public static class KategoriViewHolder extends RecyclerView.ViewHolder {
        TextView namaKategori;
        ImageView ikonKategori;

        public KategoriViewHolder(@NonNull View itemView) {
            super(itemView);
            namaKategori = itemView.findViewById(R.id.tvCategoryName);
            ikonKategori = itemView.findViewById(R.id.ivCategoryIcon);
        }
    }
}
