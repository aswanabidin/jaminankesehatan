package com.example.aswanabidin.tubessisfo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class anggotaPage extends Activity {

    private TextView textViewAnggota;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private FirebaseDatabase data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Firebase.setAndroidContext(this);
        user = mAuth.getCurrentUser();
        data = FirebaseDatabase.getInstance();

        textViewAnggota = (TextView) findViewById(R.id.textViewAnggota);

        data.getReference().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting the data from snapshot
                    Toast.makeText(anggotaPage.this, "songko", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}