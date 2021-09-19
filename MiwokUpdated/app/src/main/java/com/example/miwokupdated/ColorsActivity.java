package com.example.miwokupdated;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("Red" , "Wetetti" , R.drawable.color_red));
        words.add(new Word("Red" , "Wetetti" , R.drawable.color_green));
        words.add(new Word("Red" , "Wetetti" , R.drawable.color_brown));
        words.add(new Word("Red" , "Wetetti" , R.drawable.color_gray));
        words.add(new Word("Red" , "Wetetti" , R.drawable.color_black));
        words.add(new Word("Red" , "Wetetti" , R.drawable.color_white));
        words.add(new Word("Red" , "Wetetti" , R.drawable.color_dusty_yellow));
        words.add(new Word("Red" , "Wetetti" , R.drawable.color_mustard_yellow));

        WordAdapter itemAdapter = new WordAdapter(this , words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemAdapter);
    }
}