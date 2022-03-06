package com.bussolini.asignaturas.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.bussolini.asignaturas.R;

import model.Asignatura;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LogLifecycleCallbacks";
    private static final String KEY_INDEX = "index";

    private Button verMasButton1;
    private Button verMasButton2;

    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_main);

        Asignatura vic = new Asignatura(getString(R.string.asignatura1), getString(R.string.descripcion_corta1), getString(R.string.descripcion_larga1), getDrawable(R.drawable.subject1), getString(R.string.creditos1), getString(R.string.horarios1), getString(R.string.profesor1));
        Asignatura dew = new Asignatura(getString(R.string.asignatura2), getString(R.string.descripcion_corta2), getString(R.string.descripcion_larga2), getDrawable(R.drawable.subject2), getString(R.string.creditos2), getString(R.string.horarios2), getString(R.string.profesor2));

        //if (savedInstanceState != null)
            //currentIndex = savedInstanceState.getInt(KEY_INDEX, 0);

        verMasButton1 = (Button) findViewById(R.id.ver_mas1);
        verMasButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = SecondActivity.newIntent(MainActivity.this);

                intent.putExtra("nombre", vic.getNombre());
                intent.putExtra("descripcion", vic.getDescripcion_larga());
                intent.putExtra("imagen", "1");
                intent.putExtra("creditos", vic.getCreditos());
                intent.putExtra("horarios", vic.getHorarios());
                intent.putExtra("profesor", vic.getProfesor());

                startActivity(intent);
            }
        });

        verMasButton2 = (Button) findViewById(R.id.ver_mas2);
        verMasButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = SecondActivity.newIntent(MainActivity.this);

                intent.putExtra("nombre", dew.getNombre());
                intent.putExtra("descripcion", dew.getDescripcion_larga());
                intent.putExtra("imagen", "2");
                intent.putExtra("creditos", dew.getCreditos());
                intent.putExtra("horarios", dew.getHorarios());
                intent.putExtra("profesor", dew.getProfesor());

                startActivity(intent);
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart(Bundle) called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume(Bundle) called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause(Bundle) called");
    }

    /*@Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, currentIndex);
    }*/

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop(Bundle) called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy(Bundle) called");
    }
}