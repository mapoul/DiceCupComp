package com.example.dicecupcomp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    List<String> rollHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        rollHistory = getIntent().getStringArrayListExtra("history");
        ListView lv = findViewById(R.id.lvHist);

        for (String roll: rollHistory) {
            String[] item = roll.split("-");

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_list_view, R.id.imgView, rollHistory);
        lv.setAdapter(adapter);
    }


}
