package com.example.aswanabidin.tubessisfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailAnggota extends AppCompatActivity {

    private TextView medTextNomorKaruKeluarga, medTextNamaLengkap, medTextTempatLahir, medTextTanggalLahir, medTextAlamatRumah, medTextJenisKelamin, medStatusPernikahan,
            medTextNomorTelepon, medTextFasilitasKesehatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_anggota);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textViewNomorKartuKeluarga = (TextView) findViewById(R.id.textViewNomorKartuKeluarga);
        TextView textViewNomorRekening = (TextView) findViewById(R.id.textViewNomorRekening);
        TextView textViewNamaLengkap = (TextView) findViewById(R.id.textViewNamaLengkap);
        TextView textViewTempatLahir = (TextView) findViewById(R.id.textViewTempatLahir);
        TextView textViewTanggalLahir = (TextView) findViewById(R.id.textViewTanggalLahir);
        TextView textAlamatRumah = (TextView) findViewById(R.id.textViewAlamatRumah);
        TextView textViewJenisKelamin = (TextView) findViewById(R.id.textViewJenisKelamin);
        TextView textViewStatusPernikahan = (TextView) findViewById(R.id.textViewStatusPernikahan);
        TextView textNomorTelepon = (TextView) findViewById(R.id.textViewNomorTelepon);
        TextView textViewAlamatEmail = (TextView) findViewById(R.id.textViewAlamatEmail);
        TextView textFasilitasKesehatan = (TextView) findViewById(R.id.textViewFasilitasKesehatan);

        Bundle b = getIntent().getExtras();

        Anggota anggota = b.getParcelable("anggota");

        textViewNomorKartuKeluarga.setText(anggota.getAnggotaNomorKartuKeluarga());
        textViewNomorRekening.setText(anggota.getAnggotaNomorRekening());
        textViewNamaLengkap.setText(anggota.getAnggotaNamaLengkap());
        textViewTempatLahir.setText(anggota.getAnggotaTempatLahir());
        textViewTanggalLahir.setText(anggota.getAnggotaTanggalLahir());
        textAlamatRumah.setText(anggota.getAnggotaAlamatRumah());
        textViewJenisKelamin.setText(anggota.getAnggotaJenisKelamin());
        textViewStatusPernikahan.setText(anggota.getAnggotaStatusPernikahan());
        textNomorTelepon.setText(anggota.getAnggotaNomorTelepon());
        textViewAlamatEmail.setText(anggota.getAnggotaAlamatEmail());
        textFasilitasKesehatan.setText(anggota.getAnggotaFasilitasKesehatan());

    }

    //Kembali ke fragment list anggota
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {
            android.app.FragmentManager fm = getFragmentManager();
            fm.popBackStack();
            finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
