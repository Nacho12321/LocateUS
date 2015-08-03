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
    //    LayoutInflater inflater1;
//    ViewGroup container1;
//    View view1 = inflater1.inflate(R.layout.fragment_student_flow, container1, false);
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
        //GroupMemberFragment a = new GroupMemberFragment();
        Bundle bundle = getArguments();
        //int myInt = bundle.getInt("position");
        int myInt = StudentFlow.groupId;
//        CheckBox Member1 = (CheckBox) getActivity().findViewById(R.id.Member1);
//        Member1.setText(myInt);
//        SQLiteDatabase.CursorFactory fac = null;
//        DBHelper mstr= new DBHelper(getActivity().getApplicationContext(),fac);
//        String[] apple = mstr.sorting(myInt);
        //get gid from parameter...bundle, interface blah...

        int gid = myInt;
        DBHelper dbh = DBHelper.getInstance(getActivity().getApplicationContext());
        db = dbh.getReadableDatabase();
        String strSQL = "Select MemberId, MemberName from GroupMemberMaster where GroupId=" + gid + " ORDER BY MemberName";
        Cursor c = db.rawQuery(strSQL, null);
        final CursorAdapter ca = new MemberName(getActivity().getApplicationContext(), c, 0);
        final ListView listview = (ListView) getView().findViewById(R.id.MemNames);
        listview.setAdapter(ca);
        int record_num = 0;

        while (c.moveToNext()) {
            Toast.makeText(getActivity().getApplicationContext(), "record number:" + record_num++ + " " + c.getString(c.getColumnIndex("MemberName")), Toast.LENGTH_SHORT).show();
        }
        c.close();
    }


}