package com.example.travelmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GuideRegistration extends AppCompatActivity {
    Button Register;
    TextView LogIn;

    EditText Name, Email, Username, Password, ConfirmPassword;

    FirebaseDatabase database;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_registration);

        Register=findViewById(R.id.Register);
        LogIn=findViewById(R.id.LogIn);

        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GuideRegistration.this,GuideLogIn.class);
                startActivity(intent);
            }
        });



        Name = findViewById(R.id.editTextText13);
        Email = findViewById(R.id.editTextText14);
        Username =findViewById(R.id.username);
        Password = findViewById(R.id.editTextText3);
        ConfirmPassword = findViewById(R.id.editTextText2);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");

                String name = Name.getText().toString();
                String email = Email.getText().toString();
                String username = Username.getText().toString();
                String password = Password.getText().toString();
                String confirmPassword =  ConfirmPassword.getText().toString();


                GuideHelperClass helperClass = new GuideHelperClass(name, email, username, password,confirmPassword);
                reference.child(username).setValue(helperClass);

                Toast.makeText(GuideRegistration.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(GuideRegistration.this, GuideLogIn.class);
                startActivity(intent);
            }
        });

    }
}