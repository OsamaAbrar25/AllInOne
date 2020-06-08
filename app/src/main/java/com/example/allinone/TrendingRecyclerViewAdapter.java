package com.example.allinone;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cuelinks.CuelinksUtil;

import java.util.ArrayList;

public class TrendingRecyclerViewAdapter extends RecyclerView.Adapter<TrendingRecyclerViewAdapter.TrendingRecyclerViewHolder> {
    private ArrayList<String> arrayList_name;
    private ArrayList<Integer> arrayList_logo;
    private ArrayList<String> arrayList_url;

    public TrendingRecyclerViewAdapter(ArrayList<String> arrayList_name, ArrayList<Integer> arrayList_logo, ArrayList<String> arrayList_url) {
        this.arrayList_name = arrayList_name;
        this.arrayList_logo = arrayList_logo;
        this.arrayList_url = arrayList_url;
    }

    @NonNull
    @Override
    public TrendingRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.trending_holder, parent, false);
        return new TrendingRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingRecyclerViewHolder holder, int position) {
        holder.imageView_trending.setImageResource(arrayList_logo.get(position));
        holder.textView_trending.setText(arrayList_name.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList_name.size();
    }

    public class TrendingRecyclerViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView_trending;
        private TextView textView_trending;
        public TrendingRecyclerViewHolder(@NonNull final View itemView) {
            super(itemView);
            imageView_trending = itemView.findViewById(R.id.imageView_trending);
            textView_trending = itemView.findViewById(R.id.textView_trending);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), WebViewActivity.class);
                    intent.putExtra("url", CuelinksUtil.getAffiliatedUrl(arrayList_url.get(getAdapterPosition())));
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
