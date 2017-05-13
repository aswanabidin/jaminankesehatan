package com.example.aswanabidin.tubessisfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by aswanabidin on 5/8/17.
 */

public class AdapterBeranda extends BaseAdapter {
    private ArrayList<ModelBeranda> dataBeranda;
    private Context context;

    public AdapterBeranda(ArrayList<ModelBeranda> dataBeranda, Context context) {
        this.dataBeranda = dataBeranda;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataBeranda.size();
    }

    @Override
    public ModelBeranda getItem(int position) {
        return dataBeranda.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        v = inflater.inflate(R.layout.list_beranda, parent, false);
        ImageView gambar = (ImageView) v.findViewById(R.id.thumbnail);
        TextView judul = (TextView) v.findViewById(R.id.title);
        TextView desc = (TextView) v.findViewById(R.id.isi);
        Picasso.with(context).load(getItem(position).getGambar()).fit().into(gambar);
        judul.setText(getItem(position).getJudul());
        desc.setText(getItem(position).getDesc());
        return null;
    }
}
