package com.example.examendiciembre2019_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {
    private TextView txt1, txt2, txt3;
    private String s1, s2, s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt3 = (TextView) findViewById(R.id.txt3);

        txt1.setText("Nombre:" + getIntent().getStringExtra("nombre3"));
        txt2.setText("Telefono" + getIntent().getStringExtra("telefono3"));
        txt3.setText("Email " + getIntent().getStringExtra("email3"));
    }

    public void deVuelta(View view) {
        Intent i = new Intent();
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        startActivity(i.setClass(this, MainActivity.class));
        finish();
    }
}
