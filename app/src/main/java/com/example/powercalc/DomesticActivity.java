package com.example.powercalc;

import Adapter.DomesticAdapter;
//import Model.EditModel;
//import Model.EditName;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DomesticActivity extends AppCompatActivity {
    Button btn;
    ImageView backButton;
    RecyclerView recyclerView;
    //private CustomAdapter customAdapter;

    DomesticAdapter adapter;
    public List<String> list= Arrays.asList("Air Conditioning (2HP, 2500W)","Central Heating Pump 800W","Computer 400W"
            ,"Coffee Percolator 800W","Cooker 10000W","Deep Freeze 1000W"
            ,"Dish Washer 1800W","Electric Blanket 50W","Electric fire Per bar 1000W"
            ,"Electric Grill 1400W","Fan 50W","Fluorescent Lamp 60W","Food Processor 400W"
            ,"Food Mixer 450W","Hair Dryer 1500W","Iron Conventional 1000W","Iron Steam 1500W"
            ,"Kettle 2200W","Lights 100W","Microfiche 220W","Microwave 1500W"
            ,"Photocopier 1600W","Printer 350W","Radiator(Oil-filled) 1500W","Radio 350W","Hair Dryer 1500W","Sewing Machine 1000W"
            ,"Slow Cooker 130W","Spin Dryer 400W","Stereo 100W","Toaster 1200W","TV Colour 250W"
            ,"TeleFax 600W","Telephone PBX 700W","Tumble Dryer 2400W","Vacuum Cleaner 1200W"
            ,"Vacuum Cleaner (Upright)1500W","VDU 300W","Video Player 100W","Washing Machine 4000W"
            ,"Water Heater 3000W","Word Processor 450W");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domestic);

        recyclerView= findViewById(R.id.recyclerID);
        backButton=findViewById(R.id.backButtonId);
        btn = findViewById(R.id.btn);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemViewCacheSize(list.size());

        backButton.setImageResource(R.drawable.bigblack);

        adapter = new DomesticAdapter(list);

        recyclerView.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(DomesticActivity.this, ResultActivity.class);
                intent.putExtra("ArrayItem", adapter.getDomesticValue());
                intent.putExtra("categoryChecker","Domestic");
                startActivity(intent);
            }
        });

       backButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               v.startAnimation(AnimationUtils.loadAnimation(DomesticActivity.this, R.anim.back_button));

               Intent intent= new Intent(DomesticActivity.this, MainActivity.class);
               startActivity(intent);
           }
       });



        }
    }



