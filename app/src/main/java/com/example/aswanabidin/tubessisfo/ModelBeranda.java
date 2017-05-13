package com.example.aswanabidin.tubessisfo;

/**
 * Created by aswanabidin on 5/8/17.
 */

public class ModelBeranda {
    private String gambar, judul, desc;

    public ModelBeranda(String gambar, String judul, String desc) {
        this.gambar = gambar;
        this.judul = judul;
        this.desc = desc;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
