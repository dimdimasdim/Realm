package com.learn.riset.realm.model;

import io.realm.RealmObject;

/**
 * Created by Riset on 09/03/2017.
 */

public class Siswa extends RealmObject {

    private int id;
    private String nama,alamat;

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
