package com.example.nachiketvatkar.locateus;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.Toast;


// Receiver
public class GroupMemberFragment extends StudentFlow.PlaceholderFragment {

    SQLiteDatabase db;

    String[] allCols = new String[]{"MemberId", "MemberName"};

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
        int myInt = StudentFlow.groupIdr;
//        int gid = myInt;
//        int gid=1;
        Toast.makeText(getActivity().getApplicationContext(), "SentInfo:" + myInt, Toast.LENGTH_SHORT).show();

        DBHelper dbh = DBHelper.getInstance(getActivity().getApplicationContext());
        db = dbh.getReadableDatabase();
        String strSQL = "Select MemberId, MemberName, GroupId as _id from GroupMemberMaster where GroupId=" + myInt + " ORDER BY MemberName";
        Cursor c = db.rawQuery(strSQL, null);

        CursorAdapter ca = new MemberName(getActivity().getApplicationContext(), c, 0);
        ListView listview = (ListView) getView().findViewById(R.id.MemNames);
        listview.setAdapter(ca);
//        int record_num = 0;

//        while (c.moveToNext()) {
//            Toast.makeText(getActivity().getApplicationContext(), "record number:" + record_num++ + " " + c.getString(c.getColumnIndex("MemberName")), Toast.LENGTH_SHORT).show();
//        }
//        c.close();
    }
 

}