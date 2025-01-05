package com.uts.babelfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.InformationViewHolder> {
    private Context context;
    private List<Information> informationList;

    public InformationAdapter(Context context, List<Information> informationList) {
        this.context = context;
        this.informationList = informationList;
    }

    @NonNull
    @Override
    public InformationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_informasi, parent, false);
        return new InformationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InformationViewHolder holder, int position) {
        Information information = informationList.get(position);
        holder.tvTanggalInformasi.setText(information.getTgl_information());
        holder.tvEmail.setText(information.getEmail());
        holder.tvKomentar.setText(information.getKomentar());
        holder.tvTanggapan.setText(information.getTanggapan() != null ?
                "Tanggapan: " + information.getTanggapan() : "Tanggapan: Belum ada");
        holder.tvStatus.setText("Status: " + information.getStatus());
    }

    @Override
    public int getItemCount() {
        return informationList.size();
    }

    public static class InformationViewHolder extends RecyclerView.ViewHolder {
        TextView tvTanggalInformasi, tvEmail, tvKomentar, tvTanggapan, tvStatus;

        public InformationViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTanggalInformasi = itemView.findViewById(R.id.tvTanggalInformasi);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvKomentar = itemView.findViewById(R.id.tvKomentar);
            tvTanggapan = itemView.findViewById(R.id.tvTanggapan);
            tvStatus = itemView.findViewById(R.id.tvStatus);
        }
    }
}
