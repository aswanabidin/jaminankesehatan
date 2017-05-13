package com.example.aswanabidin.tubessisfo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnggotaFragment extends Fragment {
    private AdapterAnggota adapter;
    private FirebaseDatabase database;
    private ArrayList<Anggota> dataAnggota = new ArrayList<>();

    public AnggotaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        database = FirebaseDatabase.getInstance();
        View v = inflater.inflate(R.layout.fragment_anggota, container, false);
        final ListView list = (ListView) v.findViewById(R.id.listanggota);
        database.getReference().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    dataAnggota.add(postSnapshot.getValue(Anggota.class));
                }
                adapter = new AdapterAnggota(dataAnggota, AnggotaFragment.this.getContext());
                list.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Anggota a = dataAnggota.get(position);
                Intent i = new Intent(AnggotaFragment.this.getActivity(), DetailAnggota.class);
                i.putExtra("anggota", a);
                startActivity(i);
            }
        });

        return v;
    }

    void dummyData() {

    }

}
