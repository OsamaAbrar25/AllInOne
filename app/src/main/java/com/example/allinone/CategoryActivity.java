package com.example.allinone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.cuelinks.Cuelinks;
import com.cuelinks.CuelinksListener;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity implements CuelinksListener{
    private CategoryGridViewAdapter categoryGridViewAdapter;
    private CategoryRecyclerViewAdapter categoryRecyclerViewAdapter;
    private GridLayoutManager gridLayoutManager;
    private ArrayList<Integer> arrayList_logo;
    private ArrayList<String> arrayList_name;
    private ArrayList<Integer> arrayList_logo_trending;
    private ArrayList<String> arrayList_name_trending, arrayList_url_trending;
    private RecyclerView gridView;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private TrendingRecyclerViewAdapter trendingRecyclerViewAdapter;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        if (ContextCompat.checkSelfPermission(CategoryActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(CategoryActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(CategoryActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 101);
        }

        Cuelinks.initialize(this);
        gridView = findViewById(R.id.gridView);
        recyclerView = findViewById(R.id.recyclerView_trending);
        toolbar = findViewById(R.id.toolbar_category);

        //

        RateThisApp.init(new RateThisApp.Config(3, 5));

        // Set callback (optional)
        RateThisApp.setCallback(new RateThisApp.Callback() {
            @Override
            public void onYesClicked() {
                //Toast.makeText(CategoryActivity.this, "Yes event", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNoClicked() {
                //Toast.makeText(CategoryActivity.this, "No event", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelClicked() {
                //Toast.makeText(CategoryActivity.this, "Cancel event", Toast.LENGTH_SHORT).show();
            }
        });

        // Monitor launch times and interval from installation
        RateThisApp.onCreate(this);
        // Show a dialog if criteria is satisfied
        RateThisApp.showRateDialogIfNeeded(this);

        //

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setIcon(R.mipmap.app_icon);

        trendingList();
        trendingRecyclerViewAdapter = new TrendingRecyclerViewAdapter(arrayList_name_trending, arrayList_logo_trending, arrayList_url_trending);
        linearLayoutManager = new LinearLayoutManager(getApplication(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(trendingRecyclerViewAdapter);
        recyclerView.setNestedScrollingEnabled(true);

        prepareList();
        //categoryGridViewAdapter = new CategoryGridViewAdapter(arrayList_logo, arrayList_name);
        categoryRecyclerViewAdapter = new CategoryRecyclerViewAdapter(arrayList_logo, arrayList_name);
        gridLayoutManager = new GridLayoutManager(CategoryActivity.this, 3);
        gridView.setLayoutManager(gridLayoutManager);
        gridView.setAdapter(categoryRecyclerViewAdapter);
        //gridView.setHasFixedSize(true);
        gridView.setNestedScrollingEnabled(false);


        /*gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CategoryActivity.this, StoreActivity.class);
                //intent.putExtra("position", position);
                Object object = parent.getAdapter().getItem(position);
                String name = object.toString();
                Log.e("name", name);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });*/

    }

    @Override
    public void openUrl(String url, Context context) {

        Toast.makeText(context, url, Toast.LENGTH_LONG).show();

    }

    private void trendingList() {
        arrayList_name_trending = new ArrayList<>();
        arrayList_name_trending.add("Amazon");
        arrayList_name_trending.add("Shopclues");
        arrayList_name_trending.add("Tatacliq");
        arrayList_name_trending.add("Flipkart");
        arrayList_name_trending.add("Beardo");
        arrayList_name_trending.add("Myntra");
        arrayList_name_trending.add("Paytm Mall");
        arrayList_name_trending.add("Limeroad");
        arrayList_name_trending.add("Nykaa");
        arrayList_name_trending.add("Ajio");
        arrayList_name_trending.add("Aliexpress");
        arrayList_name_trending.add("Firstcry");
        arrayList_name_trending.add("Snapdeal");

        arrayList_url_trending = new ArrayList<>();
        arrayList_url_trending.add("www.amazon.in");
        arrayList_url_trending.add("www.shopclues.com");
        arrayList_url_trending.add("www.tatacliq.com");
        arrayList_url_trending.add("www.flipkart.com");
        arrayList_url_trending.add("www.beardo.in");
        arrayList_url_trending.add("www.myntra.com");
        arrayList_url_trending.add("www.paytmmall.com");
        arrayList_url_trending.add("www.limeroad.com");
        arrayList_url_trending.add("www.nykaa.com");
        arrayList_url_trending.add("www.ajio.com");
        arrayList_url_trending.add("www.aliexpress.com");
        arrayList_url_trending.add("www.firstcry.com");
        arrayList_url_trending.add("www.snapdeal.com");


        arrayList_logo_trending = new ArrayList<>();
        arrayList_logo_trending.add(R.drawable.amazon);
        arrayList_logo_trending.add(R.drawable.shopclues);
        arrayList_logo_trending.add(R.drawable.tatacliq);
        arrayList_logo_trending.add(R.drawable.flipkart);
        arrayList_logo_trending.add(R.drawable.beardo);
        arrayList_logo_trending.add(R.drawable.myntra);
        arrayList_logo_trending.add(R.drawable.paytmmall);
        arrayList_logo_trending.add(R.drawable.limeroad);
        arrayList_logo_trending.add(R.drawable.nykaa);
        arrayList_logo_trending.add(R.drawable.ajio);
        arrayList_logo_trending.add(R.drawable.aliexpress);
        arrayList_logo_trending.add(R.drawable.firstcry);
        arrayList_logo_trending.add(R.drawable.snapdeal);


    }

    private void prepareList() {
        arrayList_name = new ArrayList<>();
        arrayList_name.add("Popular Stores");
        arrayList_name.add("Shopping Stores");
        arrayList_name.add("Meat & Dairy");
        arrayList_name.add("Men's Store");
        arrayList_name.add("Women's Store");
        arrayList_name.add("Mom & Kids");
        arrayList_name.add("Health & Medicine");
        arrayList_name.add("Movies & Events");
        arrayList_name.add("Tour & Travel");
        arrayList_name.add("Hotel & Stay");
        arrayList_name.add("Recharges & Bills");
        arrayList_name.add("Bus");
        arrayList_name.add("Cabs & Bikes");
        arrayList_name.add("Online Food");
        arrayList_name.add("Pizza & Cafe");
        arrayList_name.add("Grocery");
        arrayList_name.add("Decor & Furniture");
        arrayList_name.add("Beauty & Groom");
        arrayList_name.add("Flights");
        arrayList_name.add("Train");
        arrayList_name.add("Flowers & Gifts");
        arrayList_name.add("Services & Repairs");

        arrayList_logo = new ArrayList<>();
        arrayList_logo.add(R.drawable.popular_store);
        arrayList_logo.add(R.drawable.shopping_store);
        arrayList_logo.add(R.drawable.meat);
        arrayList_logo.add(R.drawable.men);
        arrayList_logo.add(R.drawable.women);
        arrayList_logo.add(R.drawable.mom);
        arrayList_logo.add(R.drawable.health);
        arrayList_logo.add(R.drawable.movie);
        arrayList_logo.add(R.drawable.travel);
        arrayList_logo.add(R.drawable.hotel);
        arrayList_logo.add(R.drawable.recharge);
        arrayList_logo.add(R.drawable.bus);
        arrayList_logo.add(R.drawable.cabs);
        arrayList_logo.add(R.drawable.online_food);
        arrayList_logo.add(R.drawable.pizza_n_cafe);
        arrayList_logo.add(R.drawable.grocery);
        arrayList_logo.add(R.drawable.decor);
        arrayList_logo.add(R.drawable.beauty);
        arrayList_logo.add(R.drawable.flight);
        arrayList_logo.add(R.drawable.train);
        arrayList_logo.add(R.drawable.flower);
        arrayList_logo.add(R.drawable.service);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.policy_menu) {
            Intent intent = new Intent(CategoryActivity.this, PolicyActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.share) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT,
                    "Hey check out my app at: https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID);
            intent.setType("text/plain");
            startActivity(intent);
        }
        return true;
    }
}
