package com.example.miwokupdated;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Father" , "Apa" , R.drawable.family_father));
        words.add(new Word("Mother" , "Ata" , R.drawable.family_mother));
        words.add(new Word("Son" , "Angsi" , R.drawable.family_son));
        words.add(new Word("Daughter" , "Tune" , R.drawable.family_daughter ));
        words.add(new Word("Older Brother" , "Taachi" , R.drawable.family_older_brother));
        words.add(new Word("Younger Brother" , "Chalitti" , R.drawable.family_younger_brother));
        words.add(new Word("Older Sister" , "Tete" , R.drawable.family_older_sister));
        words.add(new Word("Young Sister" , "Kolliti" , R.drawable.family_younger_sister));
        words.add(new Word("GrandMother" , "Ama" , R.drawable.family_grandmother));
        words.add(new Word("GrandFather" , "Paapa" , R.drawable.family_grandfather));

        WordAdapter itemAdapter = new WordAdapter(this , words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemAdapter);
    }
}