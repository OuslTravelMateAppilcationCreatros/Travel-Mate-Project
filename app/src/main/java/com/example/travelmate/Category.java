package com.example.travelmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Category extends AppCompatActivity {

    ImageView ShowMap, Places ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        ShowMap = findViewById(R.id.Direction);
        Places = findViewById(R.id.Places);

        ShowMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Category.this, Map.class);
                startActivity(intent);
            }
        });

        Places.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Category.this, Places.class);
                startActivity(intent);
            }
        });

    }
}