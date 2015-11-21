package com.example.nachiketvatkar.locateus;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android. view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;


public class StepsTakenFragment extends StudentFlow.PlaceholderFragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_steps_taken, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button SelectAll = (Button) getView().findViewById(R.id.SelectAll);
        Button finish = (Button) getView().findViewById(R.id.finish);
        final CheckBox FirstHelp = (CheckBox) getView().findViewById(R.id.FirstHelp);
        final CheckBox LocalHelp = (CheckBox) getView().findViewById(R.id.LocalHelp);
        final CheckBox Isos = (CheckBox) getView().findViewById(R.id.Isos);
        final CheckBox TemporaryFirstAid = (CheckBox) getView().findViewById(R.id.TemporaryFirstAid);


        SelectAll.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        FirstHelp.setChecked(true);
                        LocalHelp.setChecked(true);
                        Isos.setChecked(true);
                        TemporaryFirstAid.setChecked(true);

                    }
                }
        );
        finish.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(getActivity(), BluetoothPairing.class));
                    }
                }
        );
    }
}
