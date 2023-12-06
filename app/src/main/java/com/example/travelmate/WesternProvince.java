package com.example.travelmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WesternProvince extends AppCompatActivity {

    Button BTN6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_western_province);

        BTN6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.google.com/maps/dir//Galle+Face,+Colombo/@6.9286609,79.8037943,13z/data=!4m9!4m8!1m0!1m5!1m1!1s0x3ae2593b8b2c88ff:0x4537fcdaf592ff11!2m2!1d79.84508!2d6.9285775!3e0?authuser=0&entry=ttu");
            }
        });
    }
    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}