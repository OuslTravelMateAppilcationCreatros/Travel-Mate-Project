
package com.example.travelmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Hire_Guide extends AppCompatActivity {

    FloatingActionButton fab;
    DatabaseReference databaseReference;
    ValueEventListener eventListener;
    RecyclerView recyclerView;

    List<HireGuideDataClass> dataList;
    HireGuideAdapter adapter;// Change
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire_guide);

        recyclerView = findViewById(R.id.GuiderecyclerView);// Change
        fab = findViewById(R.id.Guide);// Change
        //  searchView = findViewById(R.id.search);
        //  searchView.clearFocus();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(Hire_Guide.this, 1);// Change
        recyclerView.setLayoutManager(gridLayoutManager);

        AlertDialog.Builder builder = new AlertDialog.Builder(Hire_Guide.this);// Change
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        AlertDialog dialog = builder.create();
        dialog.show();

        dataList = new ArrayList<HireGuideDataClass>();

        adapter = new  HireGuideAdapter(Hire_Guide.this, dataList);// Change
        recyclerView.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("Hire_Guide_Details");// database path  // Change
        dialog.show();
        eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override// for change data
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataList.clear();
                for (DataSnapshot itemSnapshot: snapshot.getChildren()){
                    HireGuideDataClass dataClass = itemSnapshot.getValue(HireGuideDataClass.class);// Change
                    dataClass.setKey(itemSnapshot.getKey());
                    dataList.add(dataClass);
                }
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                dialog.dismiss();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Hire_Guide.this,GuideUpload.class);// Change
                startActivity(intent);
            }
        });


    }

}