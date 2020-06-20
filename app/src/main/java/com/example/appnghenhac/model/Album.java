package com.example.appnghenhac.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Album implements Serializable {

    @SerializedName("IdAlbum")
    @Expose
    private String idAlbum;
    @SerializedName("TenAlbul")
    @Expose
    private String tenAlbul;
    @SerializedName("TenCaSiAlbum")
    @Expose
    private String tenCaSiAlbum;
    @SerializedName("HinhAnhAlbum")
    @Expose
    private String hinhAnhAlbum;

    public String getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(String idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getTenAlbul() {
        return tenAlbul;
    }

    public void setTenAlbul(String tenAlbul) {
        this.tenAlbul = tenAlbul;
    }

    public String getTenCaSiAlbum() {
        return tenCaSiAlbum;
    }

    public void setTenCaSiAlbum(String tenCaSiAlbum) {
        this.tenCaSiAlbum = tenCaSiAlbum;
    }

    public String getHinhAnhAlbum() {
        return hinhAnhAlbum;
    }

    public void setHinhAnhAlbum(String hinhAnhAlbum) {
        this.hinhAnhAlbum = hinhAnhAlbum;
    }

}