package com.example.aswanabidin.tubessisfo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HalamanBiodata extends Activity {

    DatabaseReference databaseAnggota;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private Button btnDaftarAnggota;
    private Firebase mRootRef;
    //    private Spinner medTextJenisKelamin;
    private EditText medTextNomorKaruKeluarga, medTextNomorRekening, medTextNamaLengkap, medTextTempatLahir, medTextTanggalLahir, medTextAlamatRumah, medTextJenisKelamin, medStatusPernikahan,
            medTextNomorTelepon, medTextAlamatEmail, medTextFasilitasKesehatan;
    private TextView textViewAnggota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_biodata);

        databaseAnggota = FirebaseDatabase.getInstance().getReference("anggota");

        Firebase.setAndroidContext(this);

        medTextNomorKaruKeluarga = (EditText) findViewById(R.id.edTextNomorKartuKeluarga);
        medTextNomorRekening = (EditText) findViewById(R.id.edTextNomorRekening);
        medTextNamaLengkap = (EditText) findViewById(R.id.edTextNamaLengkap);
        medTextTempatLahir = (EditText) findViewById(R.id.edTextTempatLahir);
        medTextTanggalLahir = (EditText) findViewById(R.id.edTextTanggalLahir);
        medTextAlamatRumah = (EditText) findViewById(R.id.edTextAlamatRumah);
        medTextJenisKelamin = (EditText) findViewById(R.id.edTextJenisKelamin);
        medStatusPernikahan = (EditText) findViewById(R.id.edTextStatusPernikahan);
        medTextNomorTelepon = (EditText) findViewById(R.id.edTextNomorTelepon);
        medTextAlamatEmail = (EditText) findViewById(R.id.edTextEmail);
        medTextFasilitasKesehatan = (EditText) findViewById(R.id.edTextFasilitasKesehatan);

        progressDialog = new ProgressDialog(this);

        btnDaftarAnggota = (Button) findViewById(R.id.btnDaftarAnggota);

        textViewAnggota = (TextView) findViewById(R.id.textViewAnggota);

//        Spinner myspinner = (Spinner) findViewById(R.id.edTextJenisKelamin);
//        ArrayAdapter<String> myadapter = new ArrayAdapter<String>(HalamanBiodata.this,
//                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.array_jeniskelamin));
//        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        myspinner.setAdapter(myadapter);

        btnDaftarAnggota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Firebase ref = new Firebase("https://sisfotubes.firebaseio.com/");

                //getting values to store
                String nokartukeluarga = medTextNomorKaruKeluarga.getText().toString().trim();
                String norekening = medTextNomorRekening.getText().toString().trim();
                String namalengkap = medTextNamaLengkap.getText().toString().trim();
                String tempatlahir = medTextTempatLahir.getText().toString().trim();
                String tanggallahir = medTextTanggalLahir.getText().toString().trim();
                String alamatrumah = medTextAlamatRumah.getText().toString().trim();
                String jeniskelamin = medTextJenisKelamin.getText().toString().trim();
                String statuspernikahan = medStatusPernikahan.getText().toString().trim();
                String nomortelepon = medTextNomorTelepon.getText().toString().trim();
                String alamatemail = medTextAlamatEmail.getText().toString().trim();
                String fasilitaskesehatan = medTextFasilitasKesehatan.getText().toString().trim();

                //creating anggtoa objek
                Anggota anggota = new Anggota();

                //adding values
                String id = FirebaseAuth.getInstance().getCurrentUser().getUid();
                anggota.setAnggotaId(id);
                anggota.setAnggotaNomorKartuKeluarga(nokartukeluarga);
                anggota.setAnggotaNomorRekening(norekening);
                anggota.setAnggotaNamaLengkap(namalengkap);
                anggota.setAnggotaTempatLahir(tempatlahir);
                anggota.setAnggotaTanggalLahir(tanggallahir);
                anggota.setAnggotaAlamatRumah(alamatrumah);
                anggota.setAnggotaJenisKelamin(jeniskelamin);
                anggota.setAnggotaStatusPernikahan(statuspernikahan);
                anggota.setAnggotaNomorTelepon(nomortelepon);
                anggota.setAnggotaAlamatEmail(alamatemail);
                anggota.setAnggotaFasilitasKesehatan(fasilitaskesehatan);

                //storing values to firebase

                progressDialog.setMessage("Registering Please Wait...");
                progressDialog.show();

                ref.push().setValue(anggota);
                ref.addValueEventListener(new com.firebase.client.ValueEventListener() {
                    @Override
                    public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                        for (com.firebase.client.DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                            //getting the data from snapshot
                            Anggota anggota = postSnapshot.getValue(Anggota.class);
                        }
                        startActivity(new Intent(getApplicationContext(), HalamanTabbed.class));
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        System.out.println("The read failed : " + firebaseError.getMessage());
                    }
                });
            }
        });
    }
}