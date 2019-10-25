package com.example.domain.greenapp.check_net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.domain.greenapp.Activity.MainActivity;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //MainActivity.mactivity.finish();
        Intent newIntent=new Intent(context, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(newIntent);
    }
}
