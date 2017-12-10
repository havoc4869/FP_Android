package com.example.android.futsalkuy;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.telecom.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by febi on 10/12/2017.
 */

public class ConnectionClass {
    String Classs = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://192.168.100.16/futsalkuy";
    String un = "root";
    String password = "";

    @SuppressLint("NewApi")
    public java.sql.Connection CONN(){
        StrictMode.ThreadPolicy policy = new  StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        java.sql.Connection conn = null;
        String ConnURL = null;
        try {
            Class.forName(Classs);

            conn = DriverManager.getConnection(url, un, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
