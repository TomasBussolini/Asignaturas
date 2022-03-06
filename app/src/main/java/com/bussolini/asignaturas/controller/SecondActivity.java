package com.bussolini.asignaturas.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bussolini.asignaturas.R;

public class SecondActivity extends AppCompatActivity {

    private Button volver;

    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, SecondActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView text_titulo = (TextView) findViewById(R.id.titulo);
        TextView text_descripcion = (TextView) findViewById(R.id.descripcion);
        ImageView img = (ImageView) findViewById(R.id.img);
        TextView text_creditos = (TextView) findViewById(R.id.creditos);
        TextView text_horarios = (TextView) findViewById(R.id.horarios);
        TextView text_profesor = (TextView) findViewById(R.id.profesor);

        text_titulo.setText(getIntent().getStringExtra("nombre"));
        text_descripcion.setText(getIntent().getStringExtra("descripcion"));
        text_creditos.setText(getIntent().getStringExtra("creditos"));
        text_horarios.setText(getIntent().getStringExtra("horarios"));
        text_profesor.setText(getIntent().getStringExtra("profesor"));

        if (getIntent().getStringExtra("imagen").equals("1"))
            img.setBackground(getDrawable(R.drawable.subject1));
        else
            img.setBackground(getDrawable(R.drawable.subject2));

        volver = (Button) findViewById(R.id.volver);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = MainActivity.newIntent(SecondActivity.this);
                startActivity(intent);
            }
        });
    }
}