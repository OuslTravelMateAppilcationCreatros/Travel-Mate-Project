package com.example.travelmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EasternProvince extends AppCompatActivity {
<<<<<<< Updated upstream
    Button BTN4;
=======
    Button BTN6;
>>>>>>> Stashed changes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eastern_province);

<<<<<<< Updated upstream
        BTN4 = findViewById(R.id.btn5);


        BTN4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.google.com/maps/dir//Galle+Dutch+Fort,+Galle+80000/@6.0270849,80.2136923,17z/data=!4m9!4m8!1m0!1m5!1m1!1s0x3ae173a378ee025d:0xb96f8a16ae16c3fe!2m2!1d80.2150207!2d6.0304592!3e0?authuser=0&entry=ttu");
            }
        });
    }
=======

       BTN6 = findViewById(R.id.btn6);


        BTN6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.google.com/maps/dir//Trincomalee/@8.5874465,81.1739265,13z/data=!4m9!4m8!1m0!1m5!1m1!1s0x3afbbcb6902dbe27:0x7de76a7a331b0fbb!2m2!1d81.2152121!2d8.5873638!3e0?authuser=0&entry=ttu");
            }
        });
    }

>>>>>>> Stashed changes
    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}