package com.example.quranapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity2 extends AppCompatActivity {
    //Declaring the object of the QDH Class so its functions can be utilised
    QDH s = new QDH();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //Initialzing our references to views
        EditText editText = findViewById(R.id.edt);
        Button btn = findViewById(R.id.btn);
        Button btn2=findViewById(R.id.btn2);
        ListView list = findViewById(R.id.list2);
        //Initializing ArabicText
        QuranArabicText qat = new QuranArabicText();
        //Getting Data From The Intents
        Intent intent = getIntent();
        int indexSurah = intent.getIntExtra("index", -1);
        int SurahStartIndex = s.getSurahStart(indexSurah);
        int SurahLength = s.getSurahVerses(indexSurah);
        int SurahEndIndex = SurahStartIndex + (SurahLength - 1);
        //Initializing The Array Lists
        ArrayList<String> Surah = qat.GetData(SurahStartIndex, SurahEndIndex);
        ArrayList<String> adpt = new ArrayList(Surah);
        ArrayList<String> bdpt=new ArrayList(Surah);
        ArrayList<String> atl = new ArrayList<String>();//For Storing the single Selection Of Verse
        //Setting the Adapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, adpt);
        list.setAdapter(arrayAdapter);
        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       int val = Integer.parseInt(editText.getText().toString());
                                       if (val >= 1 && (val + SurahStartIndex) - 1 <= SurahEndIndex) {
                                           String verse = Surah.get(val - 1);
                                           atl.add(verse);
                                           arrayAdapter.clear();
                                           arrayAdapter.addAll(atl);
                                           // Notify the adapter that the data has changed
                                           arrayAdapter.notifyDataSetChanged();
                                           atl.clear();
                                           // arrayAdapter.clear();
                                           //  arrayAdapter.

                                       } else {

                                           Toast.makeText(MainActivity2.this, "The Verse Does Not Exist", Toast.LENGTH_SHORT).show();
                                       }
                                   }
                               }
        );

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayAdapter.clear();
                arrayAdapter.addAll(bdpt);
                arrayAdapter.notifyDataSetChanged();


            }
        });




    }
}