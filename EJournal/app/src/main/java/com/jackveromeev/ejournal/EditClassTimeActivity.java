package com.jackveromeev.ejournal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class EditClassTimeActivity extends AppCompatActivity
        implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_class_time);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(this);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DBHelper dbh = new DBHelper();
        if(dbh.getClassesAmount() == 0){
            ((TextView)findViewById(R.id.edit_class_time_message)).setText(
                    R.string.edit_class_time_list_is_empty_message);
        }
    }

    @Override
    public void onClick(View v) {

    }
}
