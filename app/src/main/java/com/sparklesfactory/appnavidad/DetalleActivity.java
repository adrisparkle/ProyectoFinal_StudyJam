package com.sparklesfactory.appnavidad;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;

import static com.sparklesfactory.appnavidad.R.id.imageView;

public class DetalleActivity extends AppCompatActivity implements Serializable{

    private ImageView ivImagen;
    private ImageView Imagen;
    private TextView tvNombre;
    private TextView tvMateriales;
    private TextView tvProcedimiento;
    private Typeface tf_thing;
    private Typeface tf_bold;
    private String e=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        getSupportActionBar().hide();
        ivImagen = (ImageView) findViewById(R.id.ivDetalleImagen);
        tvNombre = (TextView) findViewById(R.id.tvDetalleNombre);
        tvMateriales = (TextView) findViewById(R.id.tvDetalleMateriales);
        tvProcedimiento = (TextView) findViewById(R.id.tvDetalleProcedimiento);
        Imagen= (ImageView) findViewById(R.id.ivDetalleImagen);
        Lista lista = (Lista) getIntent().getSerializableExtra("listita");

        tf_thing = Typeface.createFromAsset(getAssets(), "fonts/roboto_thin.ttf");
        tf_bold = Typeface.createFromAsset(getAssets(), "fonts/roboto_black.ttf");

        tvNombre.setTypeface(tf_bold);
        tvMateriales.setTypeface(tf_thing);
        tvProcedimiento.setTypeface(tf_thing);

        ivImagen.setImageResource(lista.getImagen());
        tvNombre.setText(lista.getNombre());
        tvMateriales.setText(lista.getMateriales());
        tvProcedimiento.setText(lista.getProcedimiento());
        e=(tvNombre.getText().toString()+"\n"+tvMateriales.getText().toString())+"\n"+tvProcedimiento.getText().toString();
    }
    public void email(String em)
    {
        String[] TO = {""};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Grafo aplicado a...");
        emailIntent.putExtra(Intent.EXTRA_TEXT, em); // * configurar email aquí!
        try {
            startActivity(Intent.createChooser(emailIntent, "Enviar email."));
            Log.i("EMAIL", "Enviando email...");
        }
        catch (android.content.ActivityNotFoundException e) {
            Toast.makeText(this, "NO existe ningún cliente de email instalado!.", Toast.LENGTH_SHORT).show();
        }
    }
    public void imagencita()
    {
        ivImagen.buildDrawingCache();
        Bitmap bitmap = ivImagen.getDrawingCache();
        try {
            File file = new File(ivImagen.getContext().getCacheDir(), bitmap + ".png");
            FileOutputStream fOut = null;
            fOut = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            fOut.flush();
            fOut.close();
            file.setReadable(true, false);
            final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
            intent.setType("image/png");
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void compartir1(View view)//Envia al presionar el boton
    {
        email(e);
    }
    public void compartir2(View view)//Envia al presionar el boton
    {
        imagencita();
    }
}

