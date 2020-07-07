package com.example.examendiciembre2019_2020;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static int CODIGO_IDA = 1;
    private ImageView pantalon;

    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pantalon = (ImageView) findViewById(R.id.InitialImageView);
        texto = (TextView) findViewById(R.id.textViewInicial);
    }

    public void inicio(View view) {
        Intent i = new Intent();
        Toast.makeText(this, "Bienvenid@ a nuestra app", Toast.LENGTH_SHORT).show();
        startActivityForResult(i.setClass(this, Actividad1.class), CODIGO_IDA);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == CODIGO_IDA && resultCode == 500) {
            texto.setText(data.getStringExtra("mensaje"));
        }
    }
}
