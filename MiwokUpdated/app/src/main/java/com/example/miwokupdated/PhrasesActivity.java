package com.example.miwokupdated;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?" , "Minto wuksus"));
        words.add(new Word("What is your name?" , "Tinna oyaase'na"));
        words.add(new Word("My name is..." , "Oyaaset"));
        words.add(new Word("How are you feeling?" , "Michaksas?"));
        words.add(new Word("I'm feeling good." , "Kuchi achit"));
        words.add(new Word("Are you coming?" , "Aanas'aa?"));
        words.add(new Word("Yes, I'm coming." , "Haa'aanam"));
        words.add(new Word("I'm coming." , "Aanam"));
        words.add(new Word("Let's go." , "Yoowutis"));
        words.add(new Word("Come here." , "Anni'nem"));

        WordAdapter itemAdapter = new WordAdapter(this , words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemAdapter);
    }
}