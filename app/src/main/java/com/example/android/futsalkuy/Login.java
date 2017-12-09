package com.example.android.futsalkuy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText txtUsername, txtPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtPassword = (EditText) findViewById(R.id.password);
        txtUsername = (EditText) findViewById(R.id.username);
    }

    public void registerNow(View view){
        Intent i = new Intent(this, Register.class);
        startActivity(i);
    }

    public void Login(){
        String username = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();
    }
}
