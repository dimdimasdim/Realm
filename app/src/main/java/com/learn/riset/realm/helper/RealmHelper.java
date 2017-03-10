package com.learn.riset.realm.helper;

import android.util.Log;
import android.widget.Toast;

import com.learn.riset.realm.model.ModelSiswa;
import com.learn.riset.realm.model.Siswa;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

import android.content.Context;

import java.util.ArrayList;

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

    public void deleteSiswa(int id){
        RealmResults<Siswa> dataResult = realm
                .where(Siswa.class).equalTo("id", id)
                .findAll();
        realm.beginTransaction();
        dataResult.remove(0);
        dataResult.removeLast();
        dataResult.clear();
        realm.commitTransaction();

        ShowLog("Data Berhasil di hapus");

    }

    public void updateSiswa(int id, String nama, String alamat){
        realm.beginTransaction();
        Siswa siswa = realm.where(Siswa.class)
                .equalTo("id", id)
                .findFirst();
        siswa.setNama(nama);
        siswa.setAlamat(alamat);
        realm.commitTransaction();
        ShowLog("Data berhasil di update");
    }

    public ArrayList<ModelSiswa> findAllSiswa(){
        ArrayList<ModelSiswa> data = new ArrayList<>();
        realmResults = realm.where(Siswa.class)
                .findAll();
        realmResults.sort("id", Sort.DESCENDING);
        if (realmResults.size() > 0){
            ShowLog("Size = "+realmResults.size());
            for (int i =0; i < realmResults.size(); i++){
                String nama, alamat;

                int id = realmResults.get(i).getId();
                nama = realmResults.get(i).getNama();
                alamat = realmResults.get(i).getAlamat();
                data.add(new ModelSiswa(id,nama,alamat));
            }
        }else {
            ShowLog("size = 0");
        }

        return data;
    }


    private void ShowLog(String s) {
        Log.d(TAG, s);
        Toast.makeText(context, s, Toast.LENGTH_LONG);
    }
}
