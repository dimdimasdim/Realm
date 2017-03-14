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

public class AddActivity extends AppCompatActivity {

    private RealmHelper helper;
    private EditText etAlamat, etNama;
    private Button simmpan;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        helper = new RealmHelper(AddActivity.this);
        etNama = (EditText)findViewById(R.id.nama);
        etAlamat = (EditText) findViewById(R.id.alamat);
        simmpan = (Button) findViewById(R.id.simpan);

        simmpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama,alamat;
                nama = etNama.getText().toString();
                alamat = etAlamat.getText().toString();
                helper.addSiswa(nama,alamat);

                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });

    }
}
