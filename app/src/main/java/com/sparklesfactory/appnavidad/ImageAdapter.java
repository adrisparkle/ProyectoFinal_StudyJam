package com.sparklesfactory.appnavidad;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Adriana on 27/12/2016.
 */

public class ImageAdapter extends BaseAdapter {
    private Context context;
    public Integer[] images = {
            R.drawable.g1,
            R.drawable.g2,
            R.drawable.g3,
            R.drawable.g4,
            R.drawable.g5,
            R.drawable.g6,
            R.drawable.g7,
            R.drawable.g8,
            R.drawable.g9,
            R.drawable.g10,
            R.drawable.g11,
            R.drawable.g12,
            R.drawable.g13,
            R.drawable.g14,
            R.drawable.g15,
            R.drawable.g16,
            R.drawable.g17,
            R.drawable.g18,
            R.drawable.g19,
            R.drawable.g20,
            R.drawable.g21

    };
    public ImageAdapter(Context c){
        context = c;
    }
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View covertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(240, 240));
        return imageView;
    }
}
