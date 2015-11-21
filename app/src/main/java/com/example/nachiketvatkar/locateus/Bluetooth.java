package com.example.nachiketvatkar.locateus;

import android.app.Service;
import android.bluetooth.BluetoothManager;
import android. bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;
import android.util.Log;
import android.os.Binder;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;


public class Bluetooth extends Service {

    SQLiteDatabase db;
    private static final String TAG = "com.example.nachiketvatkar.locateus";
    private final IBinder orange= new MyLocalBinder();
    private BluetoothAdapter mBluetoothAdapter;

    public Bluetooth() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        // get SOS data from the database that is not yet sent to the arduino/RF module
        DBHelper dbh = DBHelper.getInstance(getApplicationContext());
        db = dbh.getWritableDatabase();
        // rough db table structure
        // SOS(groupcolor, membername, emergencyDetails, isSent)
//        String strSQL = "Select * from SOS where isSent=false";
//        db.execSQL(strSQL);
        //-----------------

        // iterate through the records and send the record through bluetooth
        // pending decision: do we create a bluetooth connection every time or once when the service is created
//        boolean a= hasBLE();
        final BluetoothManager bluetoothManager =
                (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        mBluetoothAdapter = bluetoothManager.getAdapter();



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


    public void Coms1(){
//     SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss",Locale.JAPAN);
//        return (df.format(new Date()));
    }

    public void Coms2(){

    }
    public boolean hasBLE(){
        if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
            Toast toast = Toast.makeText(getApplicationContext(), "it has BLE", Toast.LENGTH_SHORT);
            return true;

        }
        else {
            Toast toast1 = Toast.makeText(getApplicationContext(), "it dosen't have BLE", Toast.LENGTH_SHORT);
            return false;
        }
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
