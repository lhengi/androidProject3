package com.lhengi.project3app3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nyc_layout);
        Toast.makeText(getBaseContext(),"New York points of interests are still under construction...",Toast.LENGTH_LONG).show();

    }
}

