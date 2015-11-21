package com.example.nachiketvatkar.locateus;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Button;
import android.os.IBinder;
import android.content.Context;
import android.content.ComponentName;
import android.content.ServiceConnection;
//import com.example.nachiketvatkar.locateus.Bluetooth.MyLocalBinder;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class MainActivity extends ActionBarActivity {

    Bluetooth nachoService;
     boolean isBound=false;
    private BluetoothAdapter mBluetoothAdapter;

   // private Formatter y;
   // private GroupColorFragment filemaker =new GroupColorFragment();

   // public void openFile(String user) throws FileNotFoundException {
     //   y= new Formatter(user);
    //}

    //public void close(){
      //  y.close();
    //}
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(this, Bluetooth.class);
        startService(i);
        Button IntroButton = (Button) findViewById(R.id.IntroButton);
        final RadioButton GroupRadio = (RadioButton) findViewById(R.id.GroupRadio);
        final RadioButton TeacherRadio = (RadioButton) findViewById(R.id.TeacherRadio);

        IntroButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        if(GroupRadio.isChecked()){
                            //Call Coms1
                            startActivity(new Intent(MainActivity.this, StudentFlow.class));

                        }
                        else if(TeacherRadio.isChecked()){
                           //Coms2
                           startActivity(new Intent(MainActivity.this,TeacherFlow.class));
                        }
                    }
                }
        );
        Intent intent = new Intent(this,Bluetooth.class );
        bindService(i,nachoConnection,Context.BIND_AUTO_CREATE);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private ServiceConnection nachoConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
        Bluetooth.MyLocalBinder binder = (Bluetooth.MyLocalBinder) service;
          nachoService = binder.getService();
            isBound = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;

        }
    };
}
