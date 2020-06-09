package com.example.allinone;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UtilitiesRecyclerViewAdapter extends RecyclerView.Adapter<UtilitiesRecyclerViewAdapter.UtilitiesRecyclerViewHolder> {


    @NonNull
    @Override
    public UtilitiesRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull UtilitiesRecyclerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class UtilitiesRecyclerViewHolder extends RecyclerView.ViewHolder {
        public UtilitiesRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
