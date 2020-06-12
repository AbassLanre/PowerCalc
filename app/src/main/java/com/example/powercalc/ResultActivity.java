package com.example.powercalc;


import Adapter.CustomAdapter;
import Adapter.DomesticAdapter;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class ResultActivity extends AppCompatActivity {
    boolean check=true;
    private TextView almostCorrect;
    private TextView correct;
    Button myButton;
    TextView myTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        almostCorrect=findViewById(R.id.almostCorrect);
        correct=findViewById(R.id.correct);

        Bundle extras =getIntent().getExtras();

        if (extras != null) {
            String[] list = extras.getStringArray("ArrayItem");
            int[] add= new int[list.length];
            int[] add2= new int[list.length];
            int[] add3= new int[list.length];
            int[] add4= new int[list.length];


            String category= extras.getString("categoryChecker");


            int result = 0;

            for (int i = 0; i < list.length; i++) {
                if (list[i] == null) {
                    check = false;
                    Log.i("mess", "enterednull");

                    return;
                } else {
                    if (list[i].equals("")) {
                        check = false;
                        Log.i("mess", "enteredfalse");

                        return;
                    }
                }
            }

            if (check && category.equals("Domestic")) {
                Log.i("mess", "entered true");
                add[0]=2500*Integer.parseInt(list[0]);
                add[1]=800*Integer.parseInt(list[1]);
                add[2]=400*Integer.parseInt(list[2]);
                add[3]=800*Integer.parseInt(list[3]);
                add[4]=10000*Integer.parseInt(list[4]);
                add[5]=1000*Integer.parseInt(list[5]);
                add[6]=1800*Integer.parseInt(list[6]);
                add[7]=50*Integer.parseInt(list[7]);
                add[8]=1000*Integer.parseInt(list[8]);
                add[9]=1400*Integer.parseInt(list[9]);
                add[10]=50*Integer.parseInt(list[10]);
                add[11]=60*Integer.parseInt(list[11]);
                add[12]=400*Integer.parseInt(list[12]);
                add[13]=450*Integer.parseInt(list[13]);
                add[14]=1500*Integer.parseInt(list[14]);
                add[15]=1000*Integer.parseInt(list[15]);
                add[16]=1500*Integer.parseInt(list[16]);
                add[17]=2200*Integer.parseInt(list[17]);
                add[18]=100*Integer.parseInt(list[18]);
                add[19]=220*Integer.parseInt(list[19]);
                add[20]=1500*Integer.parseInt(list[20]);
                add[21]=1600*Integer.parseInt(list[21]);
                add[22]=350*Integer.parseInt(list[22]);
                add[23]=1500*Integer.parseInt(list[23]);
                add[24]=350*Integer.parseInt(list[24]);
                add[25]=1500*Integer.parseInt(list[25]);
                add[26]=1000*Integer.parseInt(list[26]);
                add[27]=130*Integer.parseInt(list[27]);
                add[28]=400*Integer.parseInt(list[28]);
                add[29]=100*Integer.parseInt(list[29]);
                add[30]=1200*Integer.parseInt(list[30]);
                add[31]=250*Integer.parseInt(list[31]);
                add[32]=600*Integer.parseInt(list[32]);
                add[33]=700*Integer.parseInt(list[33]);
                add[34]=2400*Integer.parseInt(list[34]);
                add[35]=1200*Integer.parseInt(list[35]);
                add[36]=1500*Integer.parseInt(list[36]);
                add[37]=300*Integer.parseInt(list[37]);
                add[38]=100*Integer.parseInt(list[38]);
                add[39]=4000*Integer.parseInt(list[39]);
                add[40]=3000*Integer.parseInt(list[40]);
                add[41]=450*Integer.parseInt(list[41]);

                for (int i=0; i< add.length; i++){
                    result+=add[i];

                }
                double finalResult= (result*1.25)/1000;

                almostCorrect.setText("The total power required is: " +String.format("%s",result)+"W");
                correct.setText("You will need a " +String.format("%.1f",finalResult)+"KVA" + " Generator");

            }

            if (check && category.equals("Industry")){
                Log.i("mess", "Industry here");
                add2[0]=1320*Integer.parseInt(list[0]);
                add2[1]=1020*Integer.parseInt(list[1]);
                add2[2]=1050*Integer.parseInt(list[2]);
                add2[3]=2000*Integer.parseInt(list[3]);
                add2[4]=2200*Integer.parseInt(list[4]);
                add2[5]=2400*Integer.parseInt(list[5]);
                add2[6]=1020*Integer.parseInt(list[6]);
                add2[7]=2000*Integer.parseInt(list[7]);
                add2[8]=1150*Integer.parseInt(list[8]);
                add2[9]=1800*Integer.parseInt(list[9]);
                add2[10]=2200*Integer.parseInt(list[10]);
                add2[11]=6000*Integer.parseInt(list[11]);
                add2[12]=1300*Integer.parseInt(list[12]);
                add2[13]=1500*Integer.parseInt(list[13]);
                add2[14]=2400*Integer.parseInt(list[14]);
                add2[15]=3000*Integer.parseInt(list[15]);
                add2[16]=1200*Integer.parseInt(list[16]);
                add2[17]=3000*Integer.parseInt(list[17]);
                add2[18]=2000*Integer.parseInt(list[18]);
                add2[19]=1000*Integer.parseInt(list[19]);
                add2[20]=1150*Integer.parseInt(list[20]);
                add2[21]=2000*Integer.parseInt(list[21]);
                add2[22]=750*Integer.parseInt(list[22]);
                add2[23]=550*Integer.parseInt(list[23]);
                add2[24]=1500*Integer.parseInt(list[24]);
                add2[25]=750*Integer.parseInt(list[25]);
                add2[26]=4000*Integer.parseInt(list[26]);
                add2[27]=8000*Integer.parseInt(list[27]);
                add2[28]=1400*Integer.parseInt(list[28]);
                add2[29]=500*Integer.parseInt(list[29]);
                add2[30]=500*Integer.parseInt(list[30]);
                add2[31]=900*Integer.parseInt(list[31]);
                add2[32]=1500*Integer.parseInt(list[32]);
                add2[33]=3000*Integer.parseInt(list[33]);
                add2[34]=1010*Integer.parseInt(list[34]);
                add2[35]=1700*Integer.parseInt(list[35]);
                add2[36]=950*Integer.parseInt(list[36]);
                add2[37]=1050*Integer.parseInt(list[37]);
                add2[38]=1500*Integer.parseInt(list[38]);
                add2[39]=1500*Integer.parseInt(list[39]);
                add2[40]=1200*Integer.parseInt(list[40]);

                for (int i=0; i< add2.length; i++){
                    result+=add2[i];

                }
                double finalResult= (result*1.25)/1000;

                almostCorrect.setText("The total power required is: " +String.format("%s",result)+"W");
                correct.setText("You will need a " +String.format("%.1f",finalResult)+"KVA" + " Generator");
            }

            if (check && category.equals("Garden")){
                Log.i("mess", "Garden here");
                add3[0]=600*Integer.parseInt(list[0]);
                add3[1]=750*Integer.parseInt(list[1]);
                add3[2]=300*Integer.parseInt(list[2]);
                add3[3]=1400*Integer.parseInt(list[3]);
                add3[4]=1200*Integer.parseInt(list[4]);
                add3[5]=500*Integer.parseInt(list[5]);
                add3[6]=1600*Integer.parseInt(list[6]);
                add3[7]=380*Integer.parseInt(list[7]);
                add3[8]=400*Integer.parseInt(list[8]);
                add3[9]=1000*Integer.parseInt(list[9]);
                add3[10]=400*Integer.parseInt(list[10]);
                add3[11]=250*Integer.parseInt(list[11]);
                add3[12]=900*Integer.parseInt(list[12]);
                add3[13]=1500*Integer.parseInt(list[13]);
                add3[14]=860*Integer.parseInt(list[14]);
                add3[15]=350*Integer.parseInt(list[15]);
                add3[16]=1000*Integer.parseInt(list[16]);

                for (int i=0; i< add3.length; i++){
                    result+=add3[i];

                }
                double finalResult= (result*1.25)/1000;

                almostCorrect.setText("The total power required is: " +String.format("%s",result)+"W");
                correct.setText("You will need a " +String.format("%.1f",finalResult)+"KVA" + " Generator");
            }

            if (check && category.equals("Caravan")){
                Log.i("mess", "Caravan here");

                add4[0]=110*Integer.parseInt(list[0]);
                add4[1]=50*Integer.parseInt(list[1]);
                add4[2]=50*Integer.parseInt(list[2]);
                add4[3]=100*Integer.parseInt(list[3]);

                for (int i=0; i< add4.length; i++){
                    result+=add4[i];

                }
                double finalResult= (result*1.25)/1000;

                almostCorrect.setText("The total power required is: " +String.format("%s",result)+"W");
                correct.setText("You will need a " +String.format("%.1f",finalResult)+"KVA" + " Generator");            }
        }
        else{
            Log.i("mess", "enterred last else");
        }
        myButton=findViewById(R.id.resultButtonID);


        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        myTextView = findViewById(R.id.toStag);
        setClickableString("REQUEST A QUOTE", "* LEGAL DISCLAIMER: Whenever complex electrical calculations are involved, it is always wise to seek the assistance of " +
                "a certified electrician. The This app guides to assist in generating general estimations only.  In most instances, " +
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
}
