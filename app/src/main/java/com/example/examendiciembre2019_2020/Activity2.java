package com.example.examendiciembre2019_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Activity2 extends AppCompatActivity {
    private String emailRecibido, mensajeSalida;
    private static final int CODIGO_SIGN_OUT = 3, CODIGO_ACT_3 = 500;
    private EditText txtEmail, txtNombre, txtTelefono;
    private TextView txtEmailEnGrande;
    private CheckBox chk;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        txtEmailEnGrande = (TextView) findViewById(R.id.txtEmailCheck);
        txtEmail = (EditText) findViewById(R.id.edt3);
        txtEmail.setEnabled(false);
        emailRecibido = getIntent().getStringExtra("email");
        txtEmail.setText(emailRecibido);
        txtNombre = (EditText) findViewById(R.id.edt1);
        txtTelefono = (EditText) findViewById(R.id.edt2);
        i = getIntent();
        chk = (CheckBox) findViewById(R.id.checkBox);
        chk.setChecked(false);
        chk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk.isChecked()) {
                    txtEmailEnGrande.setText(emailRecibido.toUpperCase());
                } else {
                    txtEmailEnGrande.setText("");
                }
            }
        });
    }


    public void salir(View view) {
        mensajeSalida = "Gracias por utilizar nuestra app";
        i.putExtra("mensaje", mensajeSalida);
        setResult(CODIGO_SIGN_OUT, i);
        finish();
    }

    public void mostrar(View view) {
        String nombre = txtNombre.getText().toString();
        String telefono = txtTelefono.getText().toString();
        String email = txtEmail.getText().toString();


        if (txtNombre.getText().toString().isEmpty() || txtEmail.getText().toString().isEmpty() || txtTelefono.getText().toString().isEmpty()) {
            Toast.makeText(this, "Debe rellenar todos los datos", Toast.LENGTH_SHORT).show();
        } else {
            String toast = "Nombre :" + nombre + "\n Telefono: " + telefono + "\n Email: " + email;
            Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
        }


    }
    public void Final(View view) {

        if (chk.isChecked()) {

            if (txtNombre.getText().toString().isEmpty() || txtEmail.getText().toString().isEmpty() || txtTelefono.getText().toString().isEmpty()) {
                Toast.makeText(this, "Debe rellenar todos los datos", Toast.LENGTH_SHORT).show();
            } else {
                i.putExtra("nombre3", txtNombre.getText().toString());
                i.putExtra("telefono3", txtTelefono.getText().toString());
                i.putExtra("email3", txtEmail.getText().toString());
                startActivity(i.setClass(this, Activity3.class));
            }

        } else
        {
            if (txtNombre.getText().toString().isEmpty() || txtTelefono.getText().toString().isEmpty()) {
                Toast.makeText(this, "Debe rellenar todos los datos", Toast.LENGTH_SHORT).show();
            } else {
                i.putExtra("nombre3", txtNombre.getText().toString());
                i.putExtra("telefono3", txtTelefono.getText().toString());
                startActivity(i.setClass(this, Activity3.class));
            }
        }


    }
}
