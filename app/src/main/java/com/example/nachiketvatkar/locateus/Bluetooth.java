package com.example.nachiketvatkar.locateus;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.os.Binder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Bluetooth extends Service {

    private static final String TAG = "com.example.nachiketvatkar.locateus";
    private final IBinder orange= new MyLocalBinder();
    public Bluetooth() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"ONSTART");
        Runnable r= new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<3600;i++){
                    long futureTime = System.currentTimeMillis() + 5000;
                    while (System.currentTimeMillis()< futureTime){
                        synchronized (this){
                            try {
                                wait(futureTime-System.currentTimeMillis());
                                Log.i(TAG, "Something is happening");
                            }
                            catch (Exception e){

                            }
                        }
                    }
                }
            }
        };
        Thread bluetooth = new Thread(r);
        bluetooth.start();
        return Service.START_STICKY;
    }


    public String Coms1(){
//     SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss",Locale.JAPAN);
//        return (df.format(new Date()));
    }

    public void Coms2(){

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"ONDESTROY");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return orange;
    }

    public class  MyLocalBinder extends Binder{
        Bluetooth getService(){
            return Bluetooth.this;
        }
    }
}
