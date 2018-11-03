package com.lhengi.project3app3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class SanReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context arg0, Intent arg1) {



        // check which intent received then call the activity
        if( arg1.getAction().equals("edu.uic.cs478.BroadcastReceiver3.sf"))
        {
            arg0.startActivity(new Intent(arg0, QuoteViewerActivity.class));
        }
        else
        {
            arg0.startActivity(new Intent(arg0, NewActivity.class));
        }



    }
}
