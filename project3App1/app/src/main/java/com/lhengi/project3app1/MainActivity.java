package com.lhengi.project3app1;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // setup permission and intent strings
    private static String HENGS_PERMISSION = "edu.uic.cs478.f18.project3";
    private static String NY_INTENT = "edu.uic.cs478.BroadcastReceiver3.ny";
    private static String SF_INTENT = "edu.uic.cs478.BroadcastReceiver3.sf";
    private Button sfButton, nyButton;

    private static String CURRENT_INTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sfButton = (Button) findViewById(R.id.button1);
        nyButton = (Button) findViewById(R.id.button2);

        sfButton.setOnClickListener(sfListener);
        nyButton.setOnClickListener(nyListener);


    }

    // Listeners, see whichever button was pressed set intent to it and send broadcast

    public View.OnClickListener sfListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            CURRENT_INTENT = SF_INTENT;
            checkPermissionAndBroadcast();

        }
    };

    public View.OnClickListener nyListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            CURRENT_INTENT = NY_INTENT;
            checkPermissionAndBroadcast();
        }
    };

    // send broadcast if there is permission, if not then request and send broadcast
    private void checkPermissionAndBroadcast() {

        Intent intent = new Intent(CURRENT_INTENT);

        if (ContextCompat.checkSelfPermission(this, HENGS_PERMISSION) == PackageManager.PERMISSION_GRANTED) {

            sendOrderedBroadcast(intent,HENGS_PERMISSION);

        } else {

            ActivityCompat.requestPermissions(this, new String[]{HENGS_PERMISSION}, 0);
        }

    }

    public void onRequestPermissionsResult(int code, String[] permissions, int[] results) {

        if (results.length > 0) {

            if (results[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(CURRENT_INTENT);

                sendOrderedBroadcast(intent,HENGS_PERMISSION);

            } else {
                Toast.makeText(this, "Bummer: No permission", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
