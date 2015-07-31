package com.example.nachiketvatkar.locateus;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nachiketvatkar on 14/7/15.
 */
public class PastStatus extends PastStatusFlow.PlaceholderFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_past_status_flow, container, false);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String[] feed = {"apple", "bannan","taco","truck","cheese","honneybooboo"};
        String[] feed1={"1","2","3","4","5","6"};
        ListAdapter feeder = new StatusFeedAdapter(getActivity().getApplicationContext(),feed,feed1);
        ListView statusFeed =  (ListView) getView().findViewById(R.id.statusFeed);
        statusFeed.setAdapter(feeder);
    }

}