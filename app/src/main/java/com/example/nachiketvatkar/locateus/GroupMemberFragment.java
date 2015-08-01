package com.example.nachiketvatkar.locateus;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android. view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import android.content.res.AssetManager;
import java.util.StringTokenizer;
import java.io.IOException;

// Receiver
public class GroupMemberFragment extends StudentFlow.PlaceholderFragment  {
//    LayoutInflater inflater1;
//    ViewGroup container1;
//    View view1 = inflater1.inflate(R.layout.fragment_student_flow, container1, false);
    SQLiteDatabase db;

    String [] allCols = new String[]{"MemberId", "MemberName"};

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_group_member, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        Bundle bundle = getParentFragment().getArguments();
//        int myInt = bundle.getInt("position");
//        CheckBox Member1 = (CheckBox) getActivity().findViewById(R.id.Member1);
//        Member1.setText(myInt);
//        SQLiteDatabase.CursorFactory fac = null;
//        DBHelper mstr= new DBHelper(getActivity().getApplicationContext(),fac);
//        String[] apple = mstr.sorting(myInt);
        // get gid from parameter...bundle, interface blah...

        int gid=6;
        DBHelper dbh = DBHelper.getInstance(getActivity().getApplicationContext());
        db = dbh.getReadableDatabase();
        String strSQL = "Select MemberId, MemberName from GroupMemberMaster where GroupId=" + gid + " ORDER BY MemberName";
//        Cursor c = db.rawQuery(strSQL, null);
        Cursor c = db.query("GroupMemberMaster", new String[]{"MemberName"}, "GroupId="+gid, null, null,null,null,null);
        while(c.isLast()!=true) {
//            Toast.makeText(getActivity().getApplicationContext(), c.getString(3), Toast.LENGTH_LONG).show();
        c.moveToNext();
        }
        c.close();
    }

}
