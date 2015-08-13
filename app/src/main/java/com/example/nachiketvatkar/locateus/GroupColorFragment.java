package com.example.nachiketvatkar.locateus;

import android.app.FragmentManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import android.database.Cursor;


public class GroupColorFragment extends StudentFlow.PlaceholderFragment  {
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

        RadioGroup Grouper1 = (RadioGroup) getView().findViewById(R.id.Grouper1);
        final RadioButton Orange = (RadioButton) getView().findViewById(R.id.Orange);
        final RadioButton Purple = (RadioButton) getView().findViewById(R.id.Purple);
        final RadioButton Green = (RadioButton) getView().findViewById(R.id.Green);
        final RadioButton Red = (RadioButton) getView().findViewById(R.id.Red);
        final RadioButton Yellow = (RadioButton) getView().findViewById(R.id.Yellow);
        final RadioButton Pink = (RadioButton) getView().findViewById(R.id.Pink);
        StudentFlow.groupIdr = 2;
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

                    Grouper1.setOnCheckedChangeListener(
                            new RadioGroup.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(RadioGroup group, int checkedId) {
                                    switch (checkedId){
                                        case R.id.Orange:
                                            Toast.makeText(getActivity().getApplicationContext(), "CheckedID"+checkedId, Toast.LENGTH_SHORT).show();
                                            Orange.setOnClickListener(
                                            new RadioButton.OnClickListener() {

                                                @Override
                                                public void onClick(View v) {
                                                    Orange1(v);

                                                }
                                            }
                                        );
                                            break;
                                        case R.id.Red:
                                            Toast.makeText(getActivity().getApplicationContext(), "CheckedID"+checkedId, Toast.LENGTH_SHORT).show();
                                            Red.setOnClickListener(
                                                    new RadioButton.OnClickListener() {

                                                        @Override
                                                        public void onClick(View v) {
                                                            Red1(v);
                                                        }
                                                    }
                                        );
                                            break;
                                        case R.id.Yellow:
                                            Toast.makeText(getActivity().getApplicationContext(), "CheckedID"+checkedId, Toast.LENGTH_SHORT).show();
                                            Yellow.setOnClickListener(
                                                    new RadioButton.OnClickListener() {

                                                        @Override
                                                        public void onClick(View v) {
                                                            Yellow1(v);
                                                        }
                                                    }
                                        );
                                            break;
                                        case R.id.Green:
                                            Toast.makeText(getActivity().getApplicationContext(), "CheckedID"+checkedId, Toast.LENGTH_SHORT).show();
                                            Green.setOnClickListener(
                                                    new RadioButton.OnClickListener() {

                                                        @Override
                                                        public void onClick(View v) {
                                                            Green1(v);
                                                        }
                                                    }
                                        );
                                            break;
                                        case R.id.Purple:
                                            Toast.makeText(getActivity().getApplicationContext(), "CheckedID"+checkedId, Toast.LENGTH_SHORT).show();
                                            Purple.setOnClickListener(
                                                    new RadioButton.OnClickListener() {

                                                        @Override
                                                        public void onClick(View v) {
                                                            Purple1(v);
                                                        }
                                                    }
                                        );
                                            break;
                                        case R.id.Pink:
                                            Toast.makeText(getActivity().getApplicationContext(), "CheckedID"+checkedId, Toast.LENGTH_SHORT).show();
                                            Pink.setOnClickListener(
                                                    new RadioButton.OnClickListener() {

                                                        @Override
                                                        public void onClick(View v) {
                                                            Pink1(v);
                                                        }
                                                    }
                                        );
                                            break;
                                    }
                                }

                            }
                    );


        } catch (IOException e) {
            e.printStackTrace();
        }

//        Toast.makeText(getActivity().getApplicationContext(), "hello fragment", Toast.LENGTH_LONG).show();
        //Fragment fragment = this.getTargetFragment(); //  object of next fragment
//        GroupMemberFragment gmf = new GroupMemberFragment();

//        Bundle bundle = new Bundle();
//        bundle.putInt("position", 1);
//        gmf.setArguments(bundle);

//        FragmentManager fm = getFragmentManager();

        FragmentTransaction ft = getFragmentManager().beginTransaction();
//        ft.replace(R.id.the_fragg, gmf);
//        ft.show(getFragmentManager().findFragmentById(R.id.the_fragg));
//        ft.addToBackStack(null);
        ft.commit();

    }

    public void Orange1(View view){
        StudentFlow.groupIdr = 1;
    }

    public void Red1(View view){StudentFlow.groupIdr = 2;}

    public void Purple1(View view){
        StudentFlow.groupIdr = 3;
    }

    public void Green1(View view){
        StudentFlow.groupIdr = 4;
    }

    public void Yellow1(View view){
        StudentFlow.groupIdr = 5;
    }

    public void Pink1(View view){ StudentFlow.groupIdr = 6; }
//    private void executeSQL(String str) {
//        SQLiteDatabase.CursorFactory c = null;
//        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase("JapTrip", c, null);
//        db.execSQL("Create Table GroupMemberMaster (MemberId char(2), MemberName char(20), GroupId int");
////        Cursor points to a location in your results
//        Cursor c= db.rawQuery(str,null);
//
//    }
}
