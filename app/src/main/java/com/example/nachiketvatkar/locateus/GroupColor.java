package com.example.nachiketvatkar.locateus;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;


public class GroupColor extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_color);
        Button CheckGS= (Button) findViewById(R.id.CheckGS);
        final RadioButton Orange = (RadioButton) findViewById(R.id.Orange);
        final RadioButton Purple = (RadioButton) findViewById(R.id.Purple);
        final RadioButton Green = (RadioButton)  findViewById(R.id.Green);
        final RadioButton Red = (RadioButton)    findViewById(R.id.Red);
        final RadioButton Yellow = (RadioButton) findViewById(R.id.Yellow);
        final RadioButton Pink = (RadioButton)   findViewById(R.id.Pink);
        CheckGS.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        if (Orange.isPressed()) {
                            startActivity(new Intent(GroupColor.this, PastStatusFlow.class));

                        } else if (Red.isChecked()) {
                            startActivity(new Intent(GroupColor.this, PastStatusFlow.class));

                        } else if (Purple.isChecked()) {
                            startActivity(new Intent(GroupColor.this, PastStatusFlow.class));

                        } else if (Green.isChecked()) {
                            startActivity(new Intent(GroupColor.this, PastStatusFlow.class));
                        } else if (Yellow.isChecked()) {
                            startActivity(new Intent(GroupColor.this, PastStatusFlow.class));

                        } else if (Pink.isChecked()) {
                            startActivity(new Intent(GroupColor.this, PastStatusFlow.class));
                        }
                    }
                }
          );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_group_color, menu);
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
}
