package com.uts.babelfood;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MakananAdapter extends RecyclerView.Adapter<MakananAdapter.MakananViewHolder> {
    private Context context;
    private List<Makanan> makananList;

    public MakananAdapter(Context context, List<Makanan> makananList) {
        this.context = context;
        this.makananList = makananList;
    }

    @NonNull
    @Override
    public MakananViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_makanan, parent, false);
        return new MakananViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MakananViewHolder holder, int position) {
        Makanan makanan = makananList.get(position);

        holder.namaMakanan.setText(makanan.getNama_makanan());
        holder.hargaMakanan.setText("Rp " + makanan.getHarga());
        holder.deskripsiMakanan.setText(makanan.getDeskripsi());
        Glide.with(context).load(makanan.getGambar_url()).into(holder.gambarMakanan);

        holder.btnPesanSekarang.setOnClickListener(v -> {
            Intent intent = new Intent(context, AddOrderActivity.class);
            intent.putExtra("id_makanan", makanan.getId_makanan());
            intent.putExtra("nama_makanan", makanan.getNama_makanan());
            intent.putExtra("harga_makanan", makanan.getHarga());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return makananList.size();
    }

    public static class MakananViewHolder extends RecyclerView.ViewHolder {
        TextView namaMakanan, hargaMakanan, deskripsiMakanan;
        ImageView gambarMakanan;
        Button btnPesanSekarang;

        public MakananViewHolder(@NonNull View itemView) {
            super(itemView);

            namaMakanan = itemView.findViewById(R.id.namaMakanan);
            hargaMakanan = itemView.findViewById(R.id.hargaMakanan);
            deskripsiMakanan = itemView.findViewById(R.id.deskripsiMakanan);
            gambarMakanan = itemView.findViewById(R.id.gambarMakanan);
            btnPesanSekarang = itemView.findViewById(R.id.btnPesanSekarang);
        }
    }
}