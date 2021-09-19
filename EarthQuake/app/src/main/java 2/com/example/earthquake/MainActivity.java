package com.example.earthquake;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<EarthQuake> words = QueryUtility.extractEarthquakes();

        EarthQuakeAdapter adapter = new EarthQuakeAdapter(this  , words);

        ListView lView = (ListView) findViewById(R.id.list);

        lView.setAdapter(adapter);

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EarthQuake currentEQ = adapter.getItem(position);
                Uri eQUri = Uri.parse(currentEQ.getmURL());

                Intent i = new Intent(Intent.ACTION_VIEW , eQUri);
                startActivity(i);
            }
        });
    }
}