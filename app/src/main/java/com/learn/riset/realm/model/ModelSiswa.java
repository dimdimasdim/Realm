package com.learn.riset.realm.model;

/**
 * Created by Riset on 09/03/2017.
 */

public class ModelSiswa {
    private int id;
    private String nama, alamat;

    public ModelSiswa(int id, String nama, String alamat) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
