package com.fiid.agfid.berita;

/**
 * Created by AGFID on 10/10/2018.
 */

public class Item {
    private String gambar , tittle, deskripsi , url , konten;
    public Item(String mgambar , String mtittle , String mdeskripsi, String murl , String mkonten){
        gambar = mgambar;
        tittle = mtittle;
        deskripsi = mdeskripsi;
        url = murl;
    }

    public String getGambar() {
        return gambar;
    }

    public String getTittle() {
        return tittle;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getUrl() {
        return url;
    }

    public String getKonten() {
        return konten;
    }
}
