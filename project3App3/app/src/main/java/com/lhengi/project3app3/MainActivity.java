package com.lhengi.project3app3;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

// Landing page for first time install app
// include button for requesting permission
public class MainActivity extends AppCompatActivity
{
    private static String HENGS_PERMISSION = "edu.uic.cs478.f18.project3";
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // user can request permission by clicking button
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(buttonListener);
    }

    public View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            checkPermission();
        }
    };

    private void checkPermission()
    {
        if(ContextCompat.checkSelfPermission(this,HENGS_PERMISSION)== PackageManager.PERMISSION_GRANTED)
        {
            Toast.makeText(this,"Permission already granted",Toast.LENGTH_SHORT).show();
        }
        else
        {
            ActivityCompat.requestPermissions(this,new String[]{HENGS_PERMISSION},0);
        }
    }

    public void onRequestPermissionsResult(int code, String[] permissions, int[] results)
    {
        if (results.length > 0)
        {
            if (results[0] == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this,"Thanks for the permission",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this,"Bummer: No permission",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
