package com.example.allinone;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRecyclerViewAdapter.CategoryRecyclerViewHolder> {
    private ArrayList<Integer> arrayList_logo;
    private ArrayList<String> arrayList_name;

    public CategoryRecyclerViewAdapter(ArrayList<Integer> arrayList_logo, ArrayList<String> arrayList_name) {
        this.arrayList_logo = arrayList_logo;
        this.arrayList_name = arrayList_name;
    }

    @NonNull
    @Override
    public CategoryRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.category_holder, parent, false);
        return new CategoryRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryRecyclerViewHolder holder, int position) {
        Picasso.get()
                .load(arrayList_logo.get(position))
                .resize(500, 500)
                //.centerCrop()
                .into(holder.imageView);
        //holder.imageView.setImageResource(arrayList_logo.get(position));
        holder.textView.setText(arrayList_name.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList_name.size();
    }

    public class CategoryRecyclerViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        public CategoryRecyclerViewHolder(@NonNull final View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView_category);
            textView = itemView.findViewById(R.id.textView_category);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                            Intent intent = new Intent(itemView.getContext(), StoreActivity.class);
                            //Object object = parent.getAdapter().getItem(position);
                            Object object = textView.getText();
                            String name = object.toString();
                            Log.e("name", name);
                            intent.putExtra("name", name);
                            itemView.getContext().startActivity(intent);

                }
            });
        }
    }
}
