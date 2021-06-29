package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class bmiActivity extends AppCompatActivity {

    android.widget.Button mrecaculatembi;

    TextView mbmidislay,mbmicategory,mgender;

    Intent intent;
    ImageView mimageview;
    String mbmi;
    float intbmi;

    String height;
    String weight;
    float inheght,intweight;
    RelativeLayout mbackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("font color=\"White\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);


        intent=getIntent();

        mbmidislay = findViewById(R.id.bmidisplay);
        mbmicategory = findViewById(R.id.bmicategorydispaly);
        mgender=findViewById(R.id.genderdislay);
        mbackground = findViewById(R.id.contentLayout);
        mimageview = findViewById(R.id.imageView);
        mrecaculatembi = findViewById(R.id.recalculatebmi);

        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");

        inheght = Float.parseFloat(height);
        intweight = Float.parseFloat(weight);

        inheght = inheght/100;

        intbmi = intweight/(inheght*inheght);

        mbmi = Float.toString(intbmi);

        if(intbmi<16){
           mbmicategory.setText("Severe Thinness");
           mbackground.setBackgroundColor(Color.RED);
           mimageview.setImageResource(R.drawable.crosss);
        }else if(intbmi<16.9 && intbmi>16){
            mbmicategory.setText("Moderate Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
        }else if(intbmi<18.4 && intbmi>17){
            mbmicategory.setText("Mild Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
        }else if(intbmi<25 && intbmi>18.4){
            mbmicategory.setText("Normal");
            //mbackground.setBackgroundColor(Color.YELLOW);
            mimageview.setImageResource(R.drawable.ok);
        }else if(intbmi<29.4 && intbmi>25){
            mbmicategory.setText("Overweight");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }else {
            mbmicategory.setText("Obese class I");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
        }

        mgender.setText(intent.getStringExtra("gender"));
        mbmidislay.setText(mbmi);


        mrecaculatembi = findViewById(R.id.recalculatebmi);

        mrecaculatembi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bmiActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}