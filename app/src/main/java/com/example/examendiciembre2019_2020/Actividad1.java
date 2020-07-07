package com.example.examendiciembre2019_2020;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Actividad1 extends AppCompatActivity {
    private static final int CODIGO_IDA_2 = 2, CODIGO_VUELTA_1 = 500;
    private EditText email, password;
    private String emailEnviado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);
        email = (EditText) findViewById(R.id.edtTipeEmal);
        password = (EditText) findViewById(R.id.edtTypePass);
    }

    public void Login(View view0) {

        if (!email.getText().toString().equals("vsalmantino@gmail.com") || !password.getText().toString().equals("colegio")) {
            Toast.makeText(getApplicationContext(), "Los datos introducidos no son correctos", Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(getApplicationContext(), Activity2.class);
            emailEnviado = email.getText().toString();
            i.putExtra("email", emailEnviado);
            startActivityForResult(i, CODIGO_IDA_2);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODIGO_IDA_2 && resultCode == 3) {
            setResult(CODIGO_VUELTA_1, data);
            finish();
        }
    }
}
