package com.example.nachiketvatkar.locateus;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class QuestionActivity extends Activity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(android.R.layout.activity_list_item);
//        // trying to query the tblQuestion
//        DBHelper dbh = DBHelper.getInstance(getApplicationContext());
//        db = dbh.getReadableDatabase();
//        // _id is to be nice to CursorAdapter
//        String strSQL = "select questionid as _id, question from tblQuestion";
//        Cursor c = db.rawQuery(strSQL,null); // db.query is a bitch...don't touch with barge_pole
//        final CursorAdapter ca = new QuestionCursorAdapter(this, c, 0);
//        final ListView listview = (ListView) findViewById(blah);
//        listview.setAdapter(ca);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_question, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    private class QuestionCursorAdapter extends CursorAdapter {
//        public QuestionCursorAdapter(Context context, Cursor cursor, int flags) {
//            super(context, cursor, 0);
//        }
//
//         The newView method is used to inflate a new view and return it,
//         you don't bind any data to the view at this point.
//        @Override
//        public View newView(Context context, Cursor cursor, ViewGroup parent) {
//            return LayoutInflater.from(context).inflate(R.layout.item_answer, parent, false);
//        }
//
//         The bindView method is used to bind all data to a given view
//         such as setting the text on a TextView.
//        @Override
//        public void bindView(View view, Context context, Cursor cursor) {
//             Find fields to populate in inflated template
//            TextView tvQid = (TextView) view.findViewById(R.id.tvQid);
//            TextView tvQuestion = (TextView) view.findViewById(R.id.tvQuestion);
//             Extract properties from cursor
//            String qid = String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
//            String question = cursor.getString(cursor.getColumnIndexOrThrow("question"));
//             Populate fields with extracted properties
//            tvQid.setText(qid);
//            tvQuestion.setText(String.valueOf(question));
//        }
//    }
}
