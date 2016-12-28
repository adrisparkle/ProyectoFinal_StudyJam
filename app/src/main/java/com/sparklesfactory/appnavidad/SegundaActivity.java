package com.sparklesfactory.appnavidad;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SegundaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lvDatos;
    private Activity activity;
    private CustomAdapter adaptador;
    private ArrayList<Lista> datos;
    private ArrayList<Lista> envia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        getSupportActionBar().hide();
        lvDatos = (ListView) findViewById(R.id.lvLista);
        activity = this;
        datos = new ArrayList<Lista>();
        envia = new ArrayList<Lista>();
        llenarArrayList();
        adaptador = new CustomAdapter(activity, datos);
        lvDatos.setAdapter(adaptador);
        lvDatos.setOnItemClickListener(this);
    }

    public void llenarArrayList() {
        Resources resources = getResources();
        String[] arrayNombres = resources.getStringArray(R.array.nombre);
        String[] arrayMateriales= resources.getStringArray(R.array.materiales);
        String[] arrayProcedimiento = resources.getStringArray(R.array.procedimiento);
        TypedArray imgs = getResources().obtainTypedArray(R.array.image);
        for (int i = 0; i < arrayNombres.length; i++) {
            datos.add(new Lista(arrayNombres[i] , imgs.getResourceId(i, -1)));
            envia.add(new Lista(arrayNombres[i],arrayMateriales[i], arrayProcedimiento[i],  imgs.getResourceId(i, -1)));
        }
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Lista lista = envia.get(position);
        Intent intent = new Intent(
                getApplicationContext(),
                DetalleActivity.class
        );
        intent.putExtra("listita", lista);
        startActivity(intent);
    }
}
