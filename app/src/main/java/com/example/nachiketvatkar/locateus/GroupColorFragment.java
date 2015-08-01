package com.example.nachiketvatkar.locateus;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android. view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import android.database.Cursor;


public class GroupColorFragment extends StudentFlow.PlaceholderFragment {
    SQLiteDatabase db;


    public int k;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
     View view = inflater.inflate(R.layout.fragment_student_flow, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        RadioButton Orange = (RadioButton) getView().findViewById(R.id.Orange);
        RadioButton Purple = (RadioButton) getView().findViewById(R.id.Purple);
        RadioButton Green = (RadioButton) getView().findViewById(R.id.Green);
        RadioButton Red = (RadioButton) getView().findViewById(R.id.Red);
        RadioButton Yellow = (RadioButton) getView().findViewById(R.id.Yellow);
        RadioButton Pink = (RadioButton) getView().findViewById(R.id.Pink);

//
        // reading the csv from /src/main/assets/test.csv
            AssetManager assetManager = getActivity().getApplicationContext().getAssets();
            StringTokenizer st = null;
            try {

//                if(dbh.Val(dbh)==false) {
                    InputStream csvStream = assetManager.open("GPS_TRACKER_DATABASE1.csv");
                    InputStreamReader csvStreamReader = new InputStreamReader(csvStream);
                    BufferedReader br = new BufferedReader(csvStreamReader);
                    DBHelper dbh = DBHelper.getInstance(getActivity().getApplicationContext());
                    db = dbh.getWritableDatabase();

//                  db.execSQL("Create Table GroupMemberMaster (MemberId char(2), MemberName char(20), GroupId int);");
                    String line;
                    while ((line = br.readLine()) != null) {
                    st = new StringTokenizer(line, ",");

                    String s1 = st.nextToken();
                    String s2 = st.nextToken();
                    String s3 = st.nextToken();
//                    Toast.makeText(getActivity().getApplicationContext(), s1 + ":"+ s2 + ":" + s3, Toast.LENGTH_LONG).show();
                    String strSQL = "Insert into GroupMemberMaster (MemberId, MemberName, GroupId) Values('" + s2 + "','" + s3 + "'," + s1 + ")";
                    db.execSQL(strSQL);
                    // to read: strSQL = "Select MemberId, MemberName from GroupMemberMaster where GroupId=" + gid + " ORDER BY MemberName"
//                    Toast.makeText(getActivity().getApplicationContext(), strSQL, Toast.LENGTH_LONG).show();
                    }


                    if (Orange.isChecked()) {
                        k = 1;
                     } else if (Red.isChecked()) {
                        k = 2;
                     } else if (Purple.isChecked()) {
                        k = 3;
                     } else if (Green.isChecked()) {
                        k = 4;
                     } else if (Yellow.isChecked()) {
                        k = 5;
                     } else if (Pink.isChecked()) {
                        k = 6;
                     }

//                }
//        else{
//            if (Orange.isChecked()) {
//                k = 1;
//            } else if (Red.isChecked()) {
//                k = 2;
//            } else if (Purple.isChecked()) {
//                k = 3;
//            } else if (Green.isChecked()) {
//                k = 4;
//            } else if (Yellow.isChecked()) {
//                k = 5;
//            } else if (Pink.isChecked()) {
//                k = 6;
//            }
//        }

//            GroupMemberFragment fragment = new GroupMemberFragment(); //  object of next fragment
//            Bundle bundle = new Bundle();
//            bundle.putInt("position",k);
//            fragment.setArguments(bundle);

            } catch (IOException e) {
                e.printStackTrace();
            }



    }

//    private void executeSQL(String str) {
//        SQLiteDatabase.CursorFactory c = null;
//        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase("JapTrip", c, null);
//        db.execSQL("Create Table GroupMemberMaster (MemberId char(2), MemberName char(20), GroupId int");
////        Cursor points to a location in your results
//        Cursor c= db.rawQuery(str,null);
//
//    }
}
