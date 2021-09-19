package com.example.miwokupdated;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> word = new ArrayList<Word>();
        word.add(new Word("One" , "Lutti" , R.drawable.number_one));
        word.add(new Word("Two" , "Atiiko" , R.drawable.number_two));
        word.add(new Word("Three" , "Tolookosu" , R.drawable.number_three));
        word.add(new Word("Four" , "Oyyisa" , R.drawable.number_four));
        word.add(new Word("Five" , "Massokka" , R.drawable.number_five));
        word.add(new Word("Six" , "Temmokka" , R.drawable.number_six));
        word.add(new Word("Seven" , "Kenekaku" , R.drawable.number_seven));
        word.add(new Word("Eight" , "Kawinta" , R.drawable.number_eight));
        word.add(new Word("Nine" , "Wo'e" , R.drawable.number_nine));
        word.add(new Word("Ten" , "Na'aacha" , R.drawable.number_ten));

        WordAdapter itemAdapter = new WordAdapter(this , word);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemAdapter);

    }
}