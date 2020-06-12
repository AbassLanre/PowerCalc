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

public class CaravanActivity extends AppCompatActivity {

    Button btn;
    RecyclerView recyclerView;
    DomesticAdapter adapter;
    ImageView backButton;
    public List<String> list= Arrays.asList("Electrolux Fridge 110W","Low Voltage Caravaner Electric Kettle 50W","TV BW Portable 50W","TV Colour Portable 100W");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caravan);

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
                Intent intent= new Intent(CaravanActivity.this, ResultActivity.class);
                intent.putExtra("ArrayItem", adapter.getDomesticValue());
                intent.putExtra("categoryChecker","Caravan");
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(CaravanActivity.this, R.anim.back_button));

                backButton.animate().alpha((float) 0.3).setDuration(1000);
                Intent intent= new Intent(CaravanActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
