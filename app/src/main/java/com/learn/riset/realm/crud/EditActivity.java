package com.learn.riset.realm.crud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.learn.riset.realm.MainActivity;
import com.learn.riset.realm.R;
import com.learn.riset.realm.helper.RealmHelper;
import com.learn.riset.realm.model.ModelSiswa;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity implements View.OnClickListener{
    int posisi;
    private EditText etNama,etAlamat;
    private Button simpan, hapus;
    private RealmHelper helper;
    private String nama, alamat, intentNama, intentAlamat;
    private ArrayList<ModelSiswa> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        etNama = (EditText) findViewById(R.id.etNama);
        etAlamat = (EditText) findViewById(R.id.etAlamat);
        simpan = (Button) findViewById(R.id.simpan);
        hapus = (Button) findViewById(R.id.hapus);

        helper = new RealmHelper(EditActivity.this);
        data = new ArrayList<>();
        posisi = getIntent().getIntExtra("id",0);
        intentNama = getIntent().getStringExtra("nama");
        intentAlamat = getIntent().getStringExtra("alamat");


        etNama.setText(intentNama);
        etAlamat.setText(intentAlamat);

        simpan.setOnClickListener(this);
        hapus.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.simpan){
            nama = etNama.getText().toString();
            alamat = etAlamat.getText().toString();

            helper.updateSiswa(posisi,nama,alamat);
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();

        }else{
            helper.deleteSiswa(posisi);
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();

        }
    }
}
