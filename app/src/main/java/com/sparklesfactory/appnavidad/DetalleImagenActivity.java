package com.sparklesfactory.appnavidad;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;

public class DetalleImagenActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_imagen);
        getSupportActionBar().hide();
        Intent i = getIntent();
        int position = i.getExtras().getInt("id");
        ImageAdapter adapter = new ImageAdapter(this);
        imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setImageResource(adapter.images[position]);
    }
    public void imagencita()
    {
        imageView.buildDrawingCache();
        Bitmap bitmap = imageView.getDrawingCache();
        try {
            File file = new File(imageView.getContext().getCacheDir(), bitmap + ".png");
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
    public void share(View v){imagencita();}
}
