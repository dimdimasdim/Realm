package com.learn.riset.realm.helper;

import android.util.Log;
import android.widget.Toast;

import com.learn.riset.realm.model.Siswa;

import io.realm.Realm;
import io.realm.RealmResults;

import android.content.Context;

/**
 * Created by Riset on 09/03/2017.
 */

public class RealmHelper {

    private static final String TAG = "RealmHelper";

    private Realm realm;
    private RealmResults<Siswa> realmResults;
    public Context context;

    public RealmHelper(Context context) {
        realm = Realm.getInstance(context);
        this.context = context;
    }

    public void addSiswa(String nama, String alamat){
        Siswa siswa = new Siswa();
        siswa.setId((int)(System.currentTimeMillis()/1000));
        siswa.setNama(nama);
        siswa.setAlamat(alamat);
        
        realm.beginTransaction();
        realm.copyToRealm(siswa);
        realm.commitTransaction();
        ShowLog("data " + nama + " berhasil disimpan");
    }


    private void ShowLog(String s) {
        Log.d(TAG, s);
        Toast.makeText(context, s, Toast.LENGTH_LONG);
    }
}
