package com.example.powercalc;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button domesticButton;
    private Button industryButton;
    private Button gardenButton;
    private Button caravanButton;
    HorizontalScrollView myScrollView;
    TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        domesticButton = findViewById(R.id.domesticID);
        industryButton = findViewById(R.id.industryID);
        gardenButton = findViewById(R.id.gardenID);
        caravanButton= findViewById(R.id.caravanID);
        myScrollView=findViewById(R.id.myScrollView);

        myScrollView.setHorizontalScrollBarEnabled(false);


        domesticButton.setOnClickListener(this);
        industryButton.setOnClickListener(this);
        gardenButton.setOnClickListener(this);
        caravanButton.setOnClickListener(this);

        myTextView = findViewById(R.id.toStag);
        setClickableString("REQUEST A QUOTE", "* LEGAL DISCLAIMER: Whenever complex electrical calculations are involved, it is always wise to seek the assistance of " +
                "a certified electrician. This app guides to assist in generating general estimations only.  In most instances, " +
                "there are numerous additional factors that should be accounted for (such as altitude, site conditions, iron losses, motor efficiencies, etc.). \n" +
                "If you are still unsure or would like assistance analyzing your current situation, feel free to REQUEST A QUOTE with your questions.", myTextView);


    }

    public void setClickableString(String clickableValue, String wholeValue, TextView yourTextView){
        String value = wholeValue;
        SpannableString spannableString = new SpannableString(value);
        int startIndex = value.indexOf(clickableValue);
        int endIndex = startIndex + clickableValue.length();
        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false); // <-- this will remove automatic underline in set span
            }

            @Override
            public void onClick(View v)
            {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("http://www.stagengineering.com/new/contact-us/"));
                startActivity(browserIntent);
            }
        }, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        yourTextView.setText(spannableString);
        yourTextView.setMovementMethod(LinkMovementMethod.getInstance()); // <-- important, onClick in ClickableSpan won't work without this
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.domesticID:
                Intent domestic = new Intent(MainActivity.this, DomesticActivity.class);
                startActivity(domestic);
                break;

            case R.id.industryID:
                Intent industry = new Intent(MainActivity.this, IndustryActivity.class);
                startActivity(industry);
                break;

            case R.id.gardenID:
                Intent garden = new Intent(MainActivity.this, GardenActivity.class);
                startActivity(garden);
                break;

            case R.id.caravanID:
                Intent caravan = new Intent(MainActivity.this, CaravanActivity.class);
                startActivity(caravan);
                break;
        }

    }

    public void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
}

