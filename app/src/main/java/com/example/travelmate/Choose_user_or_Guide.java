package com.example.travelmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Choose_user_or_Guide extends AppCompatActivity {
     Button User;
     Button Guide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_user_or_guide);

        User=findViewById(R.id.button5);
        User.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Choose_user_or_Guide.this, LogIn.class);
                startActivity(intent);
            }
        });

        Guide=findViewById(R.id.button3);
        Guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Choose_user_or_Guide.this, LogIn.class);
                startActivity(intent);
            }
        });
    }
}