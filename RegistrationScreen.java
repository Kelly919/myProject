package com.example.inventorymanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegistrationScreen extends AppCompatActivity {

    private TextView FirstName;
    private TextView LastName;
    private TextView tvEmail;
    private TextView tvPassword;
    private TextView cPassword;

    private Button button4;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_screen);

        FirstName = (TextView) findViewById(R.id.FirstName);
        LastName = (TextView) findViewById(R.id.LastName);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvPassword = (TextView) findViewById(R.id.tvPassword);
        cPassword = (TextView) findViewById(R.id.cPassword);

        button4 = (Button) findViewById(R.id.button4);
        button3 = (Button) findViewById(R.id.button3);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationScreen.this,Menu.class);
                startActivity(intent);
            }
        });



        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationScreen.this,LoginScreen.class);
                startActivity(intent);
            }
        });
    }
}