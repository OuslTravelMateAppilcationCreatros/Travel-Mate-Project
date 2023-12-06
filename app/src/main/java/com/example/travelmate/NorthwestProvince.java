package com.example.travelmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NorthwestProvince extends AppCompatActivity {
    Button BTN2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_northwest_province);

        BTN2 = findViewById(R.id.btn2);


        BTN2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.google.com/maps/dir//Yapahuwa/@7.8293673,80.260069,13z/data=!4m9!4m8!1m0!1m5!1m1!1s0x3afccf94f3a356bf:0x9d90904281c78146!2m2!1d80.3013547!2d7.8292843!3e0?authuser=0&entry=ttu"}
        });
    }
    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}