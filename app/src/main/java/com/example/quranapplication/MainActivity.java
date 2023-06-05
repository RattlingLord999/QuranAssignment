package com.example.quranapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.list);
//        Surah.add("1");
//        Surah.add("2");
//        Surah.add("3");
        QDH s=new QDH();
        ArrayList<String> Surah=s.GetSurahNames();
//        Surah.add("4");
        if(Surah!=null)
        {
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,Surah);
            list.setAdapter(arrayAdapter);


        }
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("You clicked on : "+Surah.get(i));
                Intent intent = new Intent(MainActivity.this, QDH.class);
                String surahname;
                intent.putExtra(Surah.get(i), i);

                startActivity(intent);
            }
        });

    }

}