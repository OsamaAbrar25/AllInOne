package com.example.tapfo;

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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.cuelinks.Cuelinks;
import com.cuelinks.CuelinksListener;


import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity implements CuelinksListener{
    private CategoryGridViewAdapter categoryGridViewAdapter;
    private CategoryRecyclerViewAdapter categoryRecyclerViewAdapter, categoryRecyclerViewAdapter2;
    private GridLayoutManager gridLayoutManager, gridLayoutManager2;
    private ArrayList<Integer> arrayList_logo, arrayList_logo2;
    private ArrayList<String> arrayList_name, arrayList_name2;
    private ArrayList<Integer> arrayList_logo_trending;
    private ArrayList<String> arrayList_name_trending, arrayList_url_trending;
    private RecyclerView gridView;
    private RecyclerView recyclerView_trending, recyclerView_utility;
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
        recyclerView_trending = findViewById(R.id.recyclerView_trending);
        recyclerView_utility = findViewById(R.id.recyclerView_utilities);
        toolbar = findViewById(R.id.toolbar_category);

        //

        RateThisApp.init(new RateThisApp.Config(3, 3));

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
        recyclerView_trending.setLayoutManager(linearLayoutManager);
        recyclerView_trending.setAdapter(trendingRecyclerViewAdapter);
        recyclerView_trending.setNestedScrollingEnabled(true);

        prepareList();
        //categoryGridViewAdapter = new CategoryGridViewAdapter(arrayList_logo, arrayList_name);
        categoryRecyclerViewAdapter = new CategoryRecyclerViewAdapter(arrayList_logo, arrayList_name);
        gridLayoutManager = new GridLayoutManager(CategoryActivity.this, 3);
        gridView.setLayoutManager(gridLayoutManager);
        gridView.setAdapter(categoryRecyclerViewAdapter);
        //gridView.setHasFixedSize(true);
        gridView.setNestedScrollingEnabled(false);

        utilityList();
        categoryRecyclerViewAdapter2 = new CategoryRecyclerViewAdapter(arrayList_logo2, arrayList_name2);
        gridLayoutManager2 = new GridLayoutManager(CategoryActivity.this, 3);
        recyclerView_utility.setLayoutManager(gridLayoutManager2);
        recyclerView_utility.setAdapter(categoryRecyclerViewAdapter2);
        //gridView.setHasFixedSize(true);
        recyclerView_utility.setNestedScrollingEnabled(false);


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
        arrayList_name_trending.add("Dominos");
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
        arrayList_url_trending.add("https://pizzaonline.dominos.co.in");
        arrayList_url_trending.add("www.shopclues.com");
        arrayList_url_trending.add("www.tatacliq.com");
        arrayList_url_trending.add("https://www.flipkart.com");
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
        arrayList_logo_trending.add(R.drawable.dominos);
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
        arrayList_name.add("Recharges & Bills");
        arrayList_name.add("Movies & Events");
        arrayList_name.add("Women's Store");
        arrayList_name.add("Men's Store");
        arrayList_name.add("Mom & Kids");
        arrayList_name.add("Online Food");
        arrayList_name.add("Pizza & Cafe");
        arrayList_name.add("Grocery");
        arrayList_name.add("Tour & Travel");
        arrayList_name.add("Bus");
        arrayList_name.add("Cabs & Bikes");
        arrayList_name.add("Flights");
        arrayList_name.add("Hotel & Stay");
        arrayList_name.add("Train");
        arrayList_name.add("Meat & Dairy");
        arrayList_name.add("Beauty & Groom");
        arrayList_name.add("Health & Medicine");
        arrayList_name.add("Flowers & Gifts");
        arrayList_name.add("Decor & Furniture");
        arrayList_name.add("Services & Repairs");
        //arrayList_name.add("Shopping Stores");


        arrayList_logo = new ArrayList<>();
        arrayList_logo.add(R.drawable.popular2);
        arrayList_logo.add(R.drawable.recharge2);
        arrayList_logo.add(R.drawable.movies2);
        arrayList_logo.add(R.drawable.women2);
        arrayList_logo.add(R.drawable.men2);
        arrayList_logo.add(R.drawable.mom2);
        arrayList_logo.add(R.drawable.online_food2);
        arrayList_logo.add(R.drawable.pizza2);
        arrayList_logo.add(R.drawable.grocery2);
        arrayList_logo.add(R.drawable.travel2);
        arrayList_logo.add(R.drawable.bus2);
        arrayList_logo.add(R.drawable.cab2);
        arrayList_logo.add(R.drawable.flights2);
        arrayList_logo.add(R.drawable.hotel2);
        arrayList_logo.add(R.drawable.train2);
        arrayList_logo.add(R.drawable.meat2);
        arrayList_logo.add(R.drawable.beauty2);
        arrayList_logo.add(R.drawable.health2);
        arrayList_logo.add(R.drawable.gifts2);
        arrayList_logo.add(R.drawable.decor2);
        arrayList_logo.add(R.drawable.service2);
        //arrayList_logo.add(R.drawable.shopping_store);

    }

    public void utilityList() {
        arrayList_name2 = new ArrayList<>();
        arrayList_name2.add("Social Media");
        arrayList_name2.add("Entertainment");
        arrayList_name2.add("News & Magazines");
        arrayList_name2.add("Matrimonial");
        arrayList_name2.add("Finance & Stocks");
        arrayList_name2.add("Cricket & Sports");

        arrayList_logo2 = new ArrayList<>();
        arrayList_logo2.add(R.drawable.social_media);
        arrayList_logo2.add(R.drawable.entertainment);
        arrayList_logo2.add(R.drawable.news_magzines);
        arrayList_logo2.add(R.drawable.matrimonial);
        arrayList_logo2.add(R.drawable.finance_stocks);
        arrayList_logo2.add(R.drawable.cricket_sports);
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
