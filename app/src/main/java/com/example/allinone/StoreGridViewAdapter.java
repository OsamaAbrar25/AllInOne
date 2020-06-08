package com.example.allinone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class StoreGridViewAdapter extends BaseAdapter {
    private ArrayList<Integer> arrayList_logo;
    private ArrayList<String> arrayList_name;

    public StoreGridViewAdapter(ArrayList<Integer> arrayList_logo, ArrayList<String> arrayList_name) {
        this.arrayList_logo = arrayList_logo;
        this.arrayList_name = arrayList_name;
    }

    @Override
    public int getCount() {
        return arrayList_name.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList_name.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public static class ViewHolder {
        ImageView imageView;
        TextView textView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        viewHolder = new ViewHolder();
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.store_holder, parent, false);
        }
        viewHolder.textView = convertView.findViewById(R.id.textView_store);
        viewHolder.imageView = convertView.findViewById(R.id.imageView_store);
        viewHolder.imageView.setImageResource(arrayList_logo.get(position));

        viewHolder.textView.setText(arrayList_name.get(position));
        return convertView;
    }
}
