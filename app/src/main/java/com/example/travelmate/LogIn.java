package com.example.travelmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class LogIn extends AppCompatActivity {
    TextView SignUp;
    Button GoHome;

    EditText Email, Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        Email = findViewById(R.id.editTextText13);
        Password = findViewById(R.id.editTextText14);

        SignUp=findViewById(R.id.SignUp);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogIn.this,Sign_up.class);
                startActivity(intent);
            }
        });


        GoHome = findViewById(R.id.button5);
        GoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!validateEmail() | !validatePassword()) {

                } else {
                    checkEmail();//when user click login button this call checkEmail function to validate email and password.
                }

            }
        });
    }


    //email validate part user need to enter email if not its showing email cannot be empty message.
    public Boolean validateEmail() {

        String val = Email.getText().toString();
        if (val.isEmpty()) {
            Email.setError("S number cannot be empty");
            return false;
        } else {
            Email.setError(null);
            return true;
        }

    }
    //Password validate part user need to enter password if not its showing password cannot be empty message.
    public Boolean validatePassword() {

        String val = Password.getText().toString();
        if (val.isEmpty()) {
            Password.setError("Password cannot be empty");
            return false;
        } else {
            Password.setError(null);
            return true;
        }

    }

    //check user already register or not using email and password data in the RealTime database in firebase.
    public void checkEmail() {
        String userEmail = Email.getText().toString().trim();
        String userPassword = Password.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
        Query checkUsersDatabase = reference.orderByChild("email").equalTo(userEmail);


        checkUsersDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {
                    Email.setError(null);
                    String passwordFromDB = snapshot.child(userEmail).child("s_num").getValue(String.class);

                    if (!Objects.equals(passwordFromDB, userPassword)) {
                        Email.setError(null);
                        Intent intent = new Intent(LogIn.this, Home.class);
                        startActivity(intent);

                    } else {
                        Password.setError("Invalid password");
                        Password.requestFocus();
                    }
                } else {
                    Email.setError("S number does not exist");
                    Email.requestFocus();
                    //If user entered password is incorrect, its showing error message.
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}