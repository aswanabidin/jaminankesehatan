package com.example.aswanabidin.tubessisfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toolbar;

public class DetailView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

}
