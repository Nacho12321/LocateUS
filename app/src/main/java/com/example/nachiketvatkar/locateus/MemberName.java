package com.example.nachiketvatkar.locateus;

/**
 * Created by nachiketvatkar on 3/8/15.
 */

import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.content.Context;
import android.database.Cursor;
import android.view.ViewGroup;
import android.view.View;
import android.view.LayoutInflater;

public class MemberName extends CursorAdapter {
    public MemberName(Context context, Cursor cursor, int flags) {
            super(context, cursor, 0);
        }

//         The newView method is used to inflate a new view and return it,
//         you don't bind any data to the view at this point.
        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            return LayoutInflater.from(context).inflate(R.layout.member_list, parent, false);
        }

//         The bindView method is used to bind all data to a given view
//         such as setting the text on a TextView.
        @Override
        public void bindView(View view, Context context, Cursor cursor) {
//             Find fields to populate in inflated template
            CheckBox NameChecker= (CheckBox) view.findViewById(R.id.Namechecker);
//             Extract properties from cursor
            String qid = String.valueOf(cursor.getString(cursor.getColumnIndexOrThrow("MemberName")));
//             Populate fields with extracted properties
            NameChecker.setText(qid);
        }
    }

