package com.jackveromeev.ejournal;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.jackveromeev.ejournal.R;
import com.jackveromeev.ejournal.entity.ClassTime;
import com.jackveromeev.ejournal.filework.ClassTimeFile;

import java.util.ArrayList;

public class EditClassTimeActivity extends AppCompatActivity
        implements View.OnClickListener{

    private final int DELETE_BUTTON_ID = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_class_time);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fillContent();
    }

    private void fillContent() {
        TableLayout table = (TableLayout) findViewById(R.id.edit_class_time_table);
        ArrayList<ClassTime> data = ClassTimeFile.getData();
        if(data.size() != 0) {
            addTableHat(table);
            for (int i = 0; i < data.size(); i++) {

            }
        } else {
            addMessageEmpty();
        }
    }

    private void addMessageEmpty() {
    }

    private void addRow( TableLayout table, int n) {
        ArrayList<ClassTime> data = ClassTimeFile.getData();
        String params[] = data.get(n).toString().split(" ");
        Button bDelete = new Button(this);
        bDelete.setText("X");
        bDelete.setTextSize(30);
        bDelete.setId(DELETE_BUTTON_ID + n);
        bDelete.setOnClickListener(this);
    }

    private void addTableHat(TableLayout table) {
        table.addView(createRow("#", "Start", "End", null));
    }

    private TableRow createRow(String s1, String s2,
                               String s3, Button bDelete) {
        TableRow tr = new TableRow(this);
        tr.setScrollContainer(true);

        TextView col1 = new TextView(this);
        col1.setText(s1);
        col1.setPadding(10, 10, 10, 10);
        col1.setTextSize(40);
        tr.addView(col1,0);

        TextView col2 = new TextView(this);
        col2.setText(s2);
        col2.setPadding(10, 10, 10, 10);
        col2.setTextSize(40);
        tr.addView(col2,1);

        TextView col3 = new TextView(this);
        col3.setText(s3);
        col3.setPadding(10, 10, 10, 10);
        col3.setTextSize(40);
        tr.addView(col3,2);

        if(bDelete != null) {
            tr.addView(bDelete, 3);
        }

        return tr;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        ArrayList<ClassTime> data =  ClassTimeFile.getData();
        if(id >= DELETE_BUTTON_ID && id < DELETE_BUTTON_ID + data.size()) {
            data.remove(id - DELETE_BUTTON_ID);
            clearTable();
            fillContent();
        }
    }

    private void clearTable() {
        TableLayout table =
                (TableLayout) findViewById(R.id.edit_class_time_table);
        if (table != null) {
            table.removeAllViews();
        }
    }
}
