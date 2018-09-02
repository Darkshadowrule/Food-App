package com.example.prajjwal.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prajjwal.myapplication.Database.DatabaseCreation;

public class LogIn extends AppCompatActivity implements View.OnClickListener {
    public Button login, signup;
    public EditText email, password;
    DatabaseCreation db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        db = new DatabaseCreation(this);
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login.setOnClickListener(this);
        signup.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login) {
            String email1=email.getText().toString();
            String password1=password.getText().toString();
            String storedPassword=db.getSinlgeEntry(email1);
            //Toast.makeText(this,storedPassword, Toast.LENGTH_SHORT).show();
            if(password1.equals(storedPassword))
            {              email.setText("");
                           password.setText("");
                Intent intent = new Intent(LogIn.this, MainActivity.class);
                startActivity(intent);
            } else if (email.getText().toString().equals("") && password.getText().toString().equals("")) {
                   email.setError("Field can,t be Empty");
                   password.setError("Field can,t be Empty");
                //Toast.makeText(this, "Please Enter Details", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Wrong Email Or Password", Toast.LENGTH_SHORT).show();
                //email.setText("");
                //password.setText("");
            }
        }
        if (view.getId() == R.id.signup) {
            Intent intent = new Intent(this, Signup.class);
            startActivity(intent);
        }
    }
}
