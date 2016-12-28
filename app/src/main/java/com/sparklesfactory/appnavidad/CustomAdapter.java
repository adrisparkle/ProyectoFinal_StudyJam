package com.sparklesfactory.appnavidad;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Lista> items;

    public CustomAdapter(Activity activity, ArrayList data) {
        this.context = activity;
        this.items = data;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_lista, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Typeface tf_thing = Typeface.createFromAsset(
                context.getAssets(), "fonts/roboto_thin.ttf");
        Typeface tf_bold = Typeface.createFromAsset(
                context.getAssets(), "fonts/roboto_light.ttf");

        viewHolder.itemNombre.setTypeface(tf_bold);
//        viewHolder.itemMateriales.setTypeface(tf_thing);
     //   viewHolder.itemProcedimiento.setTypeface(tf_thing);

        Lista currentItem = (Lista) getItem(position);
        viewHolder.itemNombre.setText(currentItem.getNombre());
       // viewHolder.itemMateriales.setText(currentItem.getMateriales());
       // viewHolder.itemProcedimiento.setText(currentItem.getProcedimiento());
        viewHolder.itemImagen.setImageResource(currentItem.getImagen());

        return convertView;
    }

    private class ViewHolder {
        TextView itemNombre;
      //  TextView itemProcedimiento;
        ImageView itemImagen;
        //TextView itemMateriales;

        public ViewHolder(View view) {
            itemNombre = (TextView)view.findViewById(R.id.tvNombre);
          //  itemMateriales = (TextView) view.findViewById(R.id.tvMateriales);
          //  itemProcedimiento = (TextView) view.findViewById(R.id.tvProcedimiento);
            itemImagen = (ImageView) view.findViewById(R.id.ivImagen);
        }
    }

}
