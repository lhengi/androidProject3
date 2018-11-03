package com.lhengi.project3app2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context arg0, Intent arg1)
    {
        Toast.makeText(arg0,"You selected New York!!",Toast.LENGTH_LONG).show();
    }
}
