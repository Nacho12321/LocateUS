package com.example.nachiketvatkar.locateus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android. view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by nachiketvatkar on 14/7/15.
 */
public class Location extends PastStatusFlow.PlaceholderFragment{

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
                View view=inflater.inflate(R.layout.fragment_location,container,false);
                return view;
        }


        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
                ImageView blue= (ImageView) getView().findViewById(R.id.BlueBox);
                blue.setImageResource(R.drawable.blue);
        }
}