package com.uts.babelfood;

public class Promo {
    private int id_promo;
    private String nama_promo;
    private String deskripsi;
    private String gambar_url;
    private double harga_awal;
    private double harga_diskon;
    private String kategori;

    // Getters
    public int getId_promo() { return id_promo; }
    public String getNama_promo() { return nama_promo; }
    public String getDeskripsi() { return deskripsi; }
    public String getGambar_url() { return gambar_url; }
    public double getHarga_awal() { return harga_awal; }
    public double getHarga_diskon() { return harga_diskon; }
    public String getKategori() { return kategori; }
}
