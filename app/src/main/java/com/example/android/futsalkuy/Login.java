package com.example.android.futsalkuy;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.Statement;

public class Login extends AppCompatActivity {

    EditText txtUsername, txtPassword;
    Button buttonLogin;
    ConnectionClass connectionClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtPassword = (EditText) findViewById(R.id.password);
        txtUsername = (EditText) findViewById(R.id.username);
        buttonLogin = (Button) findViewById(R.id.btnLogin);
        connectionClass = new ConnectionClass();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DoLogin doLogin = new DoLogin();
                doLogin.execute("");
            }
        });

    }

    public void registerNow(View view){
        Intent i = new Intent(this, Register.class);
        startActivity(i);
    }

    public class DoLogin extends AsyncTask<String,String,String>{

        String username = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();
        String z = "";
        boolean isSuccess = false;

        @Override
        protected String doInBackground(String... params) {
            if(username.trim().equals("") || password.trim().equals(""))
                z = "Please Enter All Field.....";
            else {
                try {
                    Connection con = connectionClass.CONN();
                    if (con == null) {
                        z = "Please Check Your Internet Connection";
                    } else {
                        String query = "select * from admin where id like " + username + " and password like " + password;

                        Statement stmt = con.createStatement();

                        stmt.executeUpdate(query);


                        z = "Success";
                        isSuccess = true;


                    }
                } catch (Exception ex) {
                    isSuccess = false;
                    z = "Exeptions" + ex;
                }
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {

            if(isSuccess){

            }
                Toast.makeText(getBaseContext(),""+z,Toast.LENGTH_LONG).show();

        }
    }
}
