package com.uts.babelfood;

import com.google.gson.annotations.SerializedName;

public class Category {
    @SerializedName("id_kategori")
    private int idKategori;

    @SerializedName("nama_kategori")
    private String namaKategori;

    public Category() {
    }

    public Category(int idKategori, String namaKategori) {
        this.idKategori = idKategori;
        this.namaKategori = namaKategori;
    }

    public int getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(int idKategori) {
        this.idKategori = idKategori;
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public void setNamaKategori(String namaKategori) {
        this.namaKategori = namaKategori;
    }
}