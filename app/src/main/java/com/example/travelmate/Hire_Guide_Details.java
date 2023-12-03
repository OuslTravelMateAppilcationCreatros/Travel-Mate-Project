package com.example.travelmate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Hire_Guide_Details extends AppCompatActivity {

    TextView detailDesc, detailTitle, detailLang;
    ImageView detailImage;
    FloatingActionButton deleteButton, editButton;
    String key = "";
    String imageUrl = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire_guide_details);

        detailDesc = findViewById(R.id.Hire_Guide_detailDesc);// Change
        detailImage = findViewById(R.id.Hire_Guide_detailImage);// Change
        detailTitle = findViewById(R.id.Hire_Guide_detailTitle);// Change
        detailLang = findViewById(R.id.detailLang);// Change



        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            detailDesc.setText(bundle.getString("Description"));
            detailTitle.setText(bundle.getString("Title"));
            detailLang.setText(bundle.getString("Language"));
            Glide.with(this).load(bundle.getString("Image")).into(detailImage);
        }
    }
}