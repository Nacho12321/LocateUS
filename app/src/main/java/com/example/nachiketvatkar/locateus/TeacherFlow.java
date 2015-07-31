package com.example.nachiketvatkar.locateus;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class TeacherFlow extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_flow);

        Button IntroButton = (Button) findViewById(R.id.PreviousStatus);
        IntroButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(TeacherFlow.this, GroupColor.class));
                    }
                }
        );

    }

}
