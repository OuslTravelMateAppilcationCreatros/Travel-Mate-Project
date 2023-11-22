package com.example.travelmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GuideRegistration extends AppCompatActivity {
    Button Register;
    TextView LogIn;

    EditText Name, Email, Password, ConfirmPassword;

    FirebaseDatabase rootNode;
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
        Password = findViewById(R.id.editTextText3);
        ConfirmPassword = findViewById(R.id.editTextText2);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(GuideRegistration.this,GuideLogIn.class);
                startActivity(intent);

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Guide");

                String name = Name.getText().toString();
                String email = Email.getText().toString();
                String password = Password.getText().toString();
                String confirmPassword = ConfirmPassword.getText().toString();


                UserHelperClass helperClass = new UserHelperClass(name,email, password,confirmPassword);
                reference.child(email).setValue(helperClass);
            }
        });


    }
}