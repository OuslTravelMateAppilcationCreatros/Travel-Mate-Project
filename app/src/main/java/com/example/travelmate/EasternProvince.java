package com.example.travelmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EasternProvince extends AppCompatActivity {
    Button BTN4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eastern_province);

        BTN4 = findViewById(R.id.btn5);


        BTN4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.google.com/maps/dir//Galle+Dutch+Fort,+Galle+80000/@6.0270849,80.2136923,17z/data=!4m9!4m8!1m0!1m5!1m1!1s0x3ae173a378ee025d:0xb96f8a16ae16c3fe!2m2!1d80.2150207!2d6.0304592!3e0?authuser=0&entry=ttu");
            }
        });
    }
    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}