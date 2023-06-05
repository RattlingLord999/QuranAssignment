package com.example.quranapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity2 extends AppCompatActivity {
    QDH s=new QDH();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        System.out.println("inside function of main activity 2");
        QuranArabicText qat=new QuranArabicText();
        Intent intent = getIntent();
        int indexSurah= intent.getIntExtra("index",-1);

        int SurahStartIndex=s.getSurahStart(indexSurah);
        int SurahLength=s.getSurahVerses(indexSurah);
        System.out.println("The surah start index is "+SurahStartIndex);
        System.out.println("The Length Of The Surah is "+SurahLength);
        ListView list=findViewById(R.id.list2);

        ArrayList<String>  Surah = qat.GetData(SurahStartIndex,SurahStartIndex+SurahLength);
        System.out.println("The size of the arraylist is "+Surah.size());
        for (String element : Surah) {
            // Do something with each element
            System.out.println("How is you ");
            System.out.println(element);
        }

        if(Surah!=null)
        {
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,Surah);
            list.setAdapter(arrayAdapter);
            System.out.println("You clicked on :");

        }



    }
}