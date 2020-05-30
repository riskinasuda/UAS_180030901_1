package com.bh183.sudaasvini;

import java.util.Date;

public class Obat {

    private int idObat;
    private String namaObat;
    private Date tglKadaluarsa;
    private String gambar;
    private String efekSamping;
    private String harga;
    private String komposisi;

    public Obat(int idObat, String namaObat, Date tglKadaluarsa, String gambar, String efekSamping, String harga, String komposisi) {
        this.idObat = idObat;
        this.namaObat = namaObat;
        this.tglKadaluarsa = tglKadaluarsa;
        this.gambar = gambar;
        this.efekSamping = efekSamping;
        this.harga = harga;
        this.komposisi = komposisi;
    }

    public void setIdObat(int idObat) {
        this.idObat = idObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public void setTglKadaluarsa(Date tglKadaluarsa) {
        this.tglKadaluarsa = tglKadaluarsa;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public void setEfekSamping(String efekSamping) {
        this.efekSamping = efekSamping;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public void setKomposisi(String komposisi) {
        this.komposisi = komposisi;
    }

    public int getIdObat() {
        return idObat;
    }

    public String getNamaObat() {
        return namaObat;
    }

    public Date getTglKadaluarsa() {
        return tglKadaluarsa;
    }

    public String getGambar() {
        return gambar;
    }

    public String getEfekSamping() {
        return efekSamping;
    }

    public String getHarga() {
        return harga;
    }

    public String getKomposisi() {
        return komposisi;
    }
}
