package com.learn.riset.realm;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.learn.riset.realm.adapter.AdapterSiswa;
import com.learn.riset.realm.crud.AddActivity;
import com.learn.riset.realm.crud.EditActivity;
import com.learn.riset.realm.helper.RealmHelper;
import com.learn.riset.realm.model.ModelSiswa;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RealmHelper realmHelper;
    private ArrayList<ModelSiswa> data;
    private FloatingActionButton add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        data = new ArrayList<>();
        realmHelper = new RealmHelper(MainActivity.this);

        recyclerView = (RecyclerView) findViewById(R.id.RVSiswa);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        setRecyclerView();

        add = (FloatingActionButton) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(i);
                finish();
            }
        });



    }

    private void setRecyclerView() {

        try{
            data= realmHelper.findAllSiswa();
        }catch (Exception e){
            e.printStackTrace();
        }
        AdapterSiswa adapterSiswa = new AdapterSiswa(data, new AdapterSiswa.OnItemClickListener(){
            @Override
            public void onClick(ModelSiswa item) {
                Intent i = new Intent(getApplicationContext(), EditActivity.class);
                i.putExtra("id", item.getId());
                i.putExtra("nama", item.getNama());
                i.putExtra("alamat", item.getAlamat());
                startActivity(i);
                finish();
            }
        });
        recyclerView.setAdapter(adapterSiswa);
    }

    @Override
    protected void onResume() {
        super.onResume();

        try {
            data = realmHelper.findAllSiswa();
        }catch (Exception e){
            e.printStackTrace();
        }
        setRecyclerView();
    }
}
