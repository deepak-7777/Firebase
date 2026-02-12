package com.example.firebase2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {

    private EditText password;
    private Button register2;
    private EditText email;

    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        email = findViewById(R.id.ed_email1 );
        register2 = findViewById(R.id.btn_register ) ;
        password = findViewById(R.id.ed_password1 );
        auth = FirebaseAuth.getInstance();

        register2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1 = email.getText().toString();
                String password1 = password.getText().toString();

                if (TextUtils.isEmpty(email1) || TextUtils.isEmpty(password1)) {
                    Toast.makeText(register.this, "Enter email and password both", Toast.LENGTH_SHORT).show();
                } else {
                    regis(email1, password1);
                }


            }
        }) ;

    }

    private void regis (String email, String password) {
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(register.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),  MainActivity.class));

                        } else {
                            String errorMessage = task.getException() != null ? task.getException().getMessage() : "Registration failed";
                            Toast.makeText(register.this, "Error: " + errorMessage, Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }



}
