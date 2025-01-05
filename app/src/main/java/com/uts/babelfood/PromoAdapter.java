package com.uts.babelfood;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.PromoViewHolder> {

    private Context context;
    private List<Promo> promoList;

    public PromoAdapter(Context context, List<Promo> promoList) {
        this.context = context;
        this.promoList = promoList;
    }

    @NonNull
    @Override
    public PromoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_promo, parent, false);
        return new PromoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PromoViewHolder holder, int position) {
        Promo promo = promoList.get(position);

        holder.namaPromo.setText(promo.getNama_promo());
        holder.deskripsiPromo.setText(promo.getDeskripsi());
        holder.hargaAwal.setText("Rp " + promo.getHarga_awal());
        holder.hargaDiskon.setText("Rp " + promo.getHarga_diskon());

        // Set strike-through pada harga asli
        holder.hargaAwal.setPaintFlags(holder.hargaAwal.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        Glide.with(context)
                .load(promo.getGambar_url())
                .placeholder(R.drawable.baseline_image_not_supported_24)
                .into(holder.gambarPromo);
    }

    @Override
    public int getItemCount() {
        return promoList.size();
    }

    public static class PromoViewHolder extends RecyclerView.ViewHolder {
        TextView namaPromo, deskripsiPromo, hargaAwal, hargaDiskon;
        ImageView gambarPromo;

        public PromoViewHolder(@NonNull View itemView) {
            super(itemView);

            namaPromo = itemView.findViewById(R.id.namaPromo);
            deskripsiPromo = itemView.findViewById(R.id.deskripsiPromo);
            hargaAwal = itemView.findViewById(R.id.hargaAwal);
            hargaDiskon = itemView.findViewById(R.id.hargaDiskon);
            gambarPromo = itemView.findViewById(R.id.gambarPromo);
        }
    }
}
