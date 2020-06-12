package com.example.powercalc;

import Adapter.DomesticAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.List;

public class IndustryActivity extends AppCompatActivity {

    Button btn;
    RecyclerView recyclerView;
    ImageView backButton;
    DomesticAdapter adapter;
    public List<String> list= Arrays.asList("Cement Mixer 1320W","Alligator Saw 1020W","Angle Grinder 125mm dia 1050W"
            ,"Angle Grinder 180mm dia 2000W","Angle Grinder 230mm dia 2200W","Angle Grinder 12in dia 2400W","Belt Sander 1020W"
            ,"Centrifugal Pump 2000W","Chain Saw 1150W","Circular saw 1800W","Compressor 6cfm 2200W"
            ,"Compressor 14cfm 6000W","Concrete Mixer 1300W","Concrete Poker 1500W","Cut off machine 2400W"
            ,"Dehumidifier 3000W","Disc Sander 1200W","Fan Heater 3000W","Floor Sander 2000W"
            ,"Floor Scrubber 1000W","Hammer Drill 1150W","Hot Air Gun 2000W","Impact Wrench 750W"
            ,"Jigsaw 550W","Kango Demolition Hammer 1500","Lathe 750W","Masonry saw 10in 4000W"
            ,"Masonry saw 14in 8000W","Mitre saw 1400W","Nibbler 500W","Orbital sander 500W"
            ,"Planer 900W","Power Float 1500W","Pressure Water(2.4gpm) 3000W","Rotary Hammer 1010W"
            ,"Router 1700W","Polisher 950W","Stone Cutter 1050W","Tamper Z-Beam 1500W"
            ,"Vacuum Pump 1500W","Wallpaper Stripper");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_industry);

        recyclerView= findViewById(R.id.recyclerID);
        backButton= findViewById(R.id.backButtonId);
        backButton.setImageResource(R.drawable.bigblack);
        btn = findViewById(R.id.btn);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemViewCacheSize(list.size());

        adapter = new DomesticAdapter(list);

        recyclerView.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(IndustryActivity.this, ResultActivity.class);
                intent.putExtra("ArrayItem", adapter.getDomesticValue());
                intent.putExtra("categoryChecker","Industry");
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(IndustryActivity.this, R.anim.back_button));

                Intent intent= new Intent(IndustryActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
