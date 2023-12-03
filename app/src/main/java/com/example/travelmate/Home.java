package com.example.travelmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    ImageView Go;
    TextView PF, SeeAll;
    TextView Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Go=findViewById(R.id.Go);
        PF =findViewById(R.id.textVie1);
        Name =findViewById(R.id.Name);
        SeeAll = findViewById(R.id.SeeAll);


        showUserData();

        //When click see all move to Category page
        SeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,Category.class);
                startActivity(intent);
            }
        });

        //When click Profile then move to username check page
        Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,Profile_log_in_Check_userName.class);
                startActivity(intent);
            }
        });

        //When click Profile then move to username check page
        PF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,Profile_log_in_Check_userName.class);
                startActivity(intent);
            }


        });


        // auto image slider java code ,
        ImageSlider imageSlider = findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.img1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img4, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img5, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img6, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img7, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img8, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img9, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img10, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels,ScaleTypes.FIT);
    }
   //Show user data
    public void showUserData(){

        Intent intent = getIntent();

        String nameUser = intent.getStringExtra("name");
        Name.setText(nameUser);

    }

    // pass user data and  display
    public void passUserData(){
        String userUsername = Name.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUsername);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {

                    String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);
                    String emailFromDB = snapshot.child(userUsername).child("email").getValue(String.class);
                    String usernameFromDB = snapshot.child(userUsername).child("username").getValue(String.class);
                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);

                    Intent intent = new Intent(Home.this, EditProfileActivity.class);

                    intent.putExtra("name", nameFromDB);
                    intent.putExtra("email", emailFromDB);
                    intent.putExtra("username", usernameFromDB);
                    intent.putExtra("password", passwordFromDB);

                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }



}