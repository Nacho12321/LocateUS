//import android.bluetooth.BluetoothAdapter;
//import android.bluetooth.BluetoothDevice;
//import android.bluetooth.BluetoothSocket;
//import android.content.Intent;
//import android.os.Bundle;
//import android.os.Handler;
//import android.support.v7.app.ActionBarActivity;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.nachiketvatkar.locateus.R;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.util.Set;
//import java.util.UUID;
//
//
//import android.app.Activity;
//import android.bluetooth.BluetoothClass;
//import android.bluetooth.BluetoothDevice;
//import android.bluetooth.BluetoothSocket;
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.content.IntentFilter;
//import android.provider.Settings;
//import android.support.v7.app.ActionBarActivity;
//import android.os.Bundle;
//import android.telephony.TelephonyManager;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.bluetooth.BluetoothAdapter;
//import android.widget.Toast;
//import android.widget.ToggleButton;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.util.Set;
//import java.util.UUID;
//import android.os.Handler;
//
//public class BluetoothPairing2 extends ActionBarActivity {
//
//    TextView myLabel;
//    EditText myTextbox;
//    BluetoothAdapter mBluetoothAdapter;
//    BluetoothSocket mmSocket;
//    BluetoothDevice mmDevice;
//    OutputStream mmOutputStream;
//    InputStream mmInputStream;
//    Thread workerThread;
//    byte[] readBuffer;
//    int readBufferPosition;
//    int counter;
//    volatile boolean stopWorker;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_bluetooth_pairing);
//
//        Button openButton = (Button)findViewById(R.id.open);
//        Button sendButton = (Button)findViewById(R.id.send);
//        Button closeButton = (Button)findViewById(R.id.close);
//        myLabel = (TextView)findViewById(R.id.label);
//        myTextbox = (EditText)findViewById(R.id.entry);
//
//        //Open Button
//        openButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                try {
//                    findBT();
//                    openBT();
//                }
//                catch (IOException ex) {
//                    showMessage("SEND FAILED at Open button");
//                }
//            }
//        });
//
//        //Send Button
//        sendButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                System.out.println(mmOutputStream.toString());
//
//                try {
//                    sendData();
//                }
//                catch (IOException ex) {
//                    showMessage("SEND FAILED");
//                }
//            }
//        });
//
//        //Close button
//        closeButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                try {
//                    closeBT();
//                }
//                catch (IOException ex) { }
//            }
//        });
//    }
//
//    void findBT() {
//        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
//        if(mBluetoothAdapter == null) {
//            myLabel.setText("No bluetooth adapter available");
//        }
//
//        if(!mBluetoothAdapter.isEnabled()) {
//            Intent enableBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//            startActivityForResult(enableBluetooth, 0);
//        }
//
//        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
//        if(pairedDevices.size() > 0) {
//            for(BluetoothDevice device : pairedDevices) {
//                System.out.println(device.getAddress());
//                System.out.println(device.getName());
//                if(device.getName().equals("Adafruit Bluefruit LE 56B4")) {
//                    mmDevice = device;
//                    break;
//                }
//            }
//        }
//
//        myLabel.setText("Bluetooth Device Found");
//    }
//
//    void openBT() throws IOException {
////        TelephonyManager tManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
////        String uuid1 = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
//        UUID uuid = UUID.fromString("6E400001-B5A3-F393-E0A9-E50E24DCCA9E"); //Standard //SerialPortService ID
////        UUID uuid = BluetoothAdapter.getBondedDevices();
//        mmSocket = mmDevice.createRfcommSocketToServiceRecord(uuid);
//        mmSocket.connect();
//        mmOutputStream = mmSocket.getOutputStream();
//        mmInputStream = mmSocket.getInputStream();
//        beginListenForData();
//        myLabel.setText("Bluetooth Opened");
//    }
//
//    void beginListenForData() {
//        final Handler handler = new Handler();
//        final byte delimiter = 10; //This is the ASCII code for a newline character
//
//        stopWorker = false;
//        readBufferPosition = 0;
//        readBuffer = new byte[1024];
//        workerThread = new Thread(new Runnable() {
//            public void run() {
//                while(!Thread.currentThread().isInterrupted() && !stopWorker) {
//                    try {
//                        int bytesAvailable = mmInputStream.available();
//                        if(bytesAvailable > 0) {
//                            byte[] packetBytes = new byte[bytesAvailable];
//                            mmInputStream.read(packetBytes);
//                            for(int i=0;i<bytesAvailable;i++) {
//                                byte b = packetBytes[i];
//                                if(b == delimiter) {
//                                    byte[] encodedBytes = new byte[readBufferPosition];
//                                    System.arraycopy(readBuffer, 0, encodedBytes, 0, encodedBytes.length);
//                                    final String data = new String(encodedBytes, "US-ASCII");
//                                    readBufferPosition = 0;
//
//                                    handler.post(new Runnable() {
//                                        public void run() {
//                                            myLabel.setText(data);
//                                        }
//                                    });
//                                }
//                                else {
//                                    readBuffer[readBufferPosition++] = b;
//                                }
//                            }
//                        }
//                    }
//                    catch (IOException ex) {
//                        stopWorker = true;
//                    }
//                }
//            }
//        });
//
//        workerThread.start();
//    }
//
//    void sendData() throws IOException {
//        System.out.println(mmOutputStream.toString());
////        String msg = myTextbox.getText().toString();
////        msg += "\n";
////        mmOutputStream.write(msg.getBytes());
//        mmOutputStream.write(65);
//        myLabel.setText("Data Sent");
//    }
//
//    void closeBT() throws IOException {
//        stopWorker = true;
//        mmOutputStream.close();
//        mmInputStream.close();
//        mmSocket.close();
//        myLabel.setText("Bluetooth Closed");
//    }
//
//    private void showMessage(String theMsg) {
//        Toast msg = Toast.makeText(getBaseContext(),
//                theMsg, Toast.LENGTH_LONG);
//        msg.show();
//    }
//}
