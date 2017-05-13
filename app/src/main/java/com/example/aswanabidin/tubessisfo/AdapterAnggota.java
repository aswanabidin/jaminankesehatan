package com.example.aswanabidin.tubessisfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aswanabidin on 5/8/17.
 */

public class AdapterAnggota extends BaseAdapter {
    private ArrayList<Anggota> daftarAnggota;
    private Context context;

    public AdapterAnggota(ArrayList<Anggota> daftarAnggota, Context context) {
        this.daftarAnggota = daftarAnggota;
        this.context = context;
    }

    @Override
    public int getCount() {
        return daftarAnggota.size();
    }

    @Override
    public Anggota getItem(int position) {
        return daftarAnggota.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Anggota anggota = daftarAnggota.get(position);

        v = inflater.inflate(R.layout.list_row_anggota, parent, false);
        TextView tulisan = (TextView) v.findViewById(R.id.kepalaKeluarga);
        tulisan.setText(anggota.getAnggotaNamaLengkap());

        return v;
    }
}
