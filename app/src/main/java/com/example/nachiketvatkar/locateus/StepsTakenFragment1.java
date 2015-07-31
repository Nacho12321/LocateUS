package com.example.nachiketvatkar.locateus;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android. view.ViewGroup;
import android.widget.Button;

/**
 * Created by nachiketvatkar on 15/7/15.
 */
public class StepsTakenFragment1 extends PastStatusFlow.PlaceholderFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_steps_taken1, container, false);
        return view;

    }
}
