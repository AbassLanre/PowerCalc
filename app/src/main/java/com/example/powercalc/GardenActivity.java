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

public class GardenActivity extends AppCompatActivity {

    Button btn;
    ImageView backButton;
    RecyclerView recyclerView;
    DomesticAdapter adapter;
    public List<String> list= Arrays.asList("Angle Grinder 600W","Belt Sander 750W","Bench grinder 300W"
            ,"Chain Saw 1400W","Circular Saw 1200W","Hedge Trimmer 500W","Hot Air Gun 1600W"
            ,"JigSaw 380W","Lawn-mower 12in cylinder 280-400W","Lawn-Mower 12in hover 900-1150W","Lawn Raker 400W"
            ,"Orbital Sander 250W","Planer 900W","Rotavator 750W-1500W","Router 860W"
            ,"Strimmer 10in 350W","Submersible pump 1000W");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garden);

        recyclerView= findViewById(R.id.recyclerID);
        backButton=findViewById(R.id.backButtonId);
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
                Intent intent= new Intent(GardenActivity.this, ResultActivity.class);
                intent.putExtra("ArrayItem", adapter.getDomesticValue());
                intent.putExtra("categoryChecker","Garden");
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(GardenActivity.this, R.anim.back_button));

                Intent intent= new Intent(GardenActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
