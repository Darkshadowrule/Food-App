package com.example.prajjwal.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prajjwal.myapplication.Database.DatabaseCreation;

import java.util.regex.Pattern;

public class Signup extends AppCompatActivity implements View.OnClickListener {
    public Button submit;
    public EditText email, password, confirm;

    DatabaseCreation db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        db = new DatabaseCreation(this);
        submit = findViewById(R.id.submit);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirm = findViewById(R.id.confirm);
        submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.submit) {
            if (!email.getText().toString().equals("") && !password.getText().toString().equals("") &&!confirm.getText().toString().equals("")) {
                if (Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
                    if (password.getText().toString().equals(confirm.getText().toString()))
                    {
                        boolean result =db.insertData(email.getText().toString(),password.getText().toString());
                        if(result){
                        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
                        email.setText("");
                        password.setText("");
                        confirm.setText("");
                        Intent intent = new Intent(Signup.this, LogIn.class);
                        startActivity(intent);}
                        else
                            Toast.makeText(this, "Email Already Exists"+ result, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Password Not Matched!!", Toast.LENGTH_SHORT).show();
                    }
                } else
                    email.setError("Email Format incorrect");
            } else {
                //Toast.makeText(this, "Please Enter Details", Toast.LENGTH_SHORT).show();
                if(email.getText().toString().equals("") && password.getText().toString().equals("") &&confirm.getText().toString().equals(""))
                {
                    email.setError("Field can't be Empty");
                    password.setError("Field can't be Empty");
                    confirm.setError("Field can't be Empty");
                }
                else if(email.getText().toString().equals("")&& password.getText().toString().equals(""))
                {
                    email.setError("Field can't be Empty");
                    password.setError("Field can't be Empty");
                }
                else if(email.getText().toString().equals("")&&confirm.getText().toString().equals(""))
                {
                    email.setError("Field can't be Empty");
                    confirm.setError("Field can't be Empty");
                }
                else if(password.getText().toString().equals("") &&confirm.getText().toString().equals(""))
                {
                    password.setError("Field can't be Empty");
                    confirm.setError("Field can't be Empty");
                }
                else if(email.getText().toString().equals(""))
                    email.setError("Field can't be Empty");
                else if(confirm.getText().toString().equals(""))
                    confirm.setError("Field can't be Empty");
                else if(password.getText().toString().equals(""))
                    password.setError("Field can't be Empty");
            }
        }


    }
}
