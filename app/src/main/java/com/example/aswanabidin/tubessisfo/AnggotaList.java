package com.example.aswanabidin.tubessisfo;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aswanabidin on 4/25/17.
 */

public class AnggotaList extends ArrayAdapter<Anggota> {

    private Activity context;
    private List<Anggota> anggotaList;

    public AnggotaList(Activity context, List<Anggota> anggotaList) {
        super(context, R.layout.list_layout, anggotaList);
        this.context = context;
        this.anggotaList = anggotaList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView textViewNomorKartuKeluarga = (TextView) listViewItem.findViewById(R.id.textViewNomorKartuKeluarga);
        TextView textViewNomorRekening = (TextView) listViewItem.findViewById(R.id.textViewNomorRekening);
        TextView textViewNamaLengkap = (TextView) listViewItem.findViewById(R.id.textViewNamaLengkap);
        TextView textViewTempatLahir = (TextView) listViewItem.findViewById(R.id.textViewTempatLahir);
        TextView textViewTanggalLahir = (TextView) listViewItem.findViewById(R.id.textViewTanggalLahir);
        TextView textViewAlamatRumah = (TextView) listViewItem.findViewById(R.id.textViewAlamatRumah);
        TextView textViewJenisKelamin = (TextView) listViewItem.findViewById(R.id.textViewJenisKelamin);
        TextView textViewStatusPernikahan = (TextView) listViewItem.findViewById(R.id.textViewStatusPernikahan);
        TextView textViewNomorTelepon = (TextView) listViewItem.findViewById(R.id.textViewNomorTelepon);
        TextView textViewAlamatEmail = (TextView) listViewItem.findViewById(R.id.textViewAlamatEmail);
        TextView textViewFasilitasKesehatan = (TextView) listViewItem.findViewById(R.id.textViewFasilitasKesehatan);

        Anggota anggota = anggotaList.get(position);

        textViewNomorKartuKeluarga.setText(anggota.getAnggotaNomorKartuKeluarga());
        textViewNomorRekening.setText(anggota.getAnggotaNomorRekening());
        textViewNamaLengkap.setText(anggota.getAnggotaNamaLengkap());
        textViewTempatLahir.setText(anggota.getAnggotaTempatLahir());
        textViewTanggalLahir.setText(anggota.getAnggotaTanggalLahir());
        textViewAlamatRumah.setText(anggota.getAnggotaAlamatRumah());
        textViewJenisKelamin.setText(anggota.getAnggotaJenisKelamin());
        textViewStatusPernikahan.setText(anggota.getAnggotaStatusPernikahan());
        textViewNomorTelepon.setText(anggota.getAnggotaNomorTelepon());
        textViewAlamatEmail.setText(anggota.getAnggotaAlamatEmail());
        textViewFasilitasKesehatan.setText(anggota.getAnggotaFasilitasKesehatan());

        return listViewItem;
    }

}

