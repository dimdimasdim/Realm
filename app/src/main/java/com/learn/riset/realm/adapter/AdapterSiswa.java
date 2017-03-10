package com.learn.riset.realm.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.learn.riset.realm.R;
import com.learn.riset.realm.model.ModelSiswa;

import java.util.ArrayList;


/**
 * Created by Riset on 10/03/2017.
 */

public class AdapterSiswa extends RecyclerView.Adapter<AdapterSiswa.ViewHolder> {

    private final OnItemClickListener listener ;
    private ArrayList<ModelSiswa> siswa;

    public AdapterSiswa(ArrayList<ModelSiswa> siswa, OnItemClickListener listener){
        this.siswa = siswa;
        this.listener = listener;
    }

    @Override
    public AdapterSiswa.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_item,null);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterSiswa.ViewHolder holder, int position) {
        holder.click(siswa.get(position), listener);
        holder.id.setText(String.valueOf(siswa.get(position).getId()));
        holder.nama.setText(String.valueOf(siswa.get(position).getNama()));
        holder.alamat.setText(String.valueOf(siswa.get(position).getAlamat()));
    }

    public interface OnItemClickListener{
        void onClick(ModelSiswa item);
    }

    @Override
    public int getItemCount() {
        return siswa.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, nama, alamat;
        public ViewHolder(View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.txtid);
            nama = (TextView) itemView.findViewById(R.id.txtnama);
            alamat = (TextView) itemView.findViewById(R.id.txtalamat);
        }

        public void click(final ModelSiswa modelSiswa, final OnItemClickListener listener) {
            itemView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(modelSiswa);
                }
            });
        }
    }
}
