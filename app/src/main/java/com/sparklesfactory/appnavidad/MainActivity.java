package com.sparklesfactory.appnavidad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }
    public void Manualidades(View v)
    {
        Intent i1 = new Intent(getApplicationContext(), SegundaActivity.class);
        startActivity(i1);
    }
    public void Ideas(View v)
    {
        Intent i2 = new Intent(getApplicationContext(), TerceraActivity.class);
        startActivity(i2);
    }
    public void Recetas(View v)
    {
     //   Intent i = new Intent(getApplicationContext(), TerceraActivity.class);
      //  startActivity(i);
    }
}
