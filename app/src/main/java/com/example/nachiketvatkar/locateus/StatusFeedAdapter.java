package com.example.nachiketvatkar.locateus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by nachiketvatkar on 15/7/15.
 */
class StatusFeedAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater linflater;
    private TextView txt_1, txt_2;
    private String[] str1;
    private String[] str2;

    public StatusFeedAdapter (Context context, String[] s1, String[] s2) {
        mContext = context;
        str1 = s1;
        str2 = s2;
        linflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return str1.length;
    }

    @Override
    public Object getItem(int arg0) {
        return str1[arg0];
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            convertView = linflater.inflate(R.layout.custom_row, null);

        }
        EditText IGM1 = (EditText) convertView.findViewById(R.id.IGM1);
        EditText ITL1 = (EditText) convertView.findViewById(R.id.ITL1);
        IGM1.setText(str1[position]);
        ITL1.setText(str2[position]);

        return convertView;

    }
}

