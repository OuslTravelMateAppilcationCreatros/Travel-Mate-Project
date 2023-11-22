package com.example.travelmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GuideLogIn extends AppCompatActivity {
    TextView SignUp;
    Button GoHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_log_in);

        SignUp=findViewById(R.id.SignUp);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GuideLogIn.this,GuideRegistration.class);
                startActivity(intent);
            }
        });

        GoHome=findViewById(R.id.button5);
        GoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GuideLogIn.this,Home.class);
                startActivity(intent);
            }
        });
    }
}