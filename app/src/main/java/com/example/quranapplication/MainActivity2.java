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

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity2 extends AppCompatActivity {


    //Declaring the object of the QDH Class so its functions can be utilised
    QDH s=new QDH();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText editText=findViewById(R.id.edt);


        Button btn=findViewById(R.id.btn);

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
ArrayList<String> adpt=new ArrayList(Surah);

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,adpt);
            list.setAdapter(arrayAdapter);
            System.out.println("You clicked on :");



        ArrayList<String> atl=new ArrayList<String>();
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               int val=Integer.parseInt(editText.getText().toString());

               System.out.println("The verse number is given as follows "+val);
               if(val>=SurahStartIndex && val<= SurahStartIndex+SurahLength )
               {
                   System.out.println("This value should not be out of bound"+val);
                   String verse=Surah.get(val);
                   System.out.println(verse);
                   System.out.println("I am inside the button right now ");
                   atl.add(verse);
                   arrayAdapter.clear();
                   arrayAdapter.addAll(atl);

                   // Notify the adapter that the data has changed
                   arrayAdapter.notifyDataSetChanged();
                   atl.clear();
                  // arrayAdapter.clear();
                 //  arrayAdapter.


               }
           }
       });








    }
}