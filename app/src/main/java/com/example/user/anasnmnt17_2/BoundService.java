package com.example.user.anasnmnt17_2;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IIS 5 on 27-12-2017.
 */

public class BoundService extends Service {

    IBinder iBinder = new LocalBinder();

    @Override
    public IBinder onBind(Intent intent) { //  Return the communication channel to the service.
        return iBinder;
    }


    public class LocalBinder extends Binder {
        public BoundService getService() {
            // Return this instance of BoundService
            return BoundService.this;
        }

    }

    public String getTime() {//Method for GetTime()
        //creating object of SimpleDateFormat
        SimpleDateFormat simpleDateFormat = null;
        //Applying the condition for getting the date and time
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        return simpleDateFormat.format(new Date());

    }
}