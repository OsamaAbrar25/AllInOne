package com.example.allinone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.cuelinks.CuelinksUtil;

import java.util.ArrayList;

public class StoreActivity extends AppCompatActivity {
    //private int position;
    private String name;
    private ArrayList<Integer> arrayList_logo;
    private ArrayList<String> arrayList_name;
    private ArrayList<String> arrayList_url;
    private StoreGridViewAdapter storeGridViewAdapter;
    private GridView gridView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        gridView = findViewById(R.id.gridView2);
        toolbar = findViewById(R.id.toolbar_store);
        //position = getIntent().getIntExtra("position", 0);
        name = getIntent().getStringExtra("name");
        toolbar.setTitle(name);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        switch (name) {
            case "Popular Stores":
                arrayList_name = new ArrayList<>();
                arrayList_name.add("Amazon");
                arrayList_name.add("Flipkart");
                arrayList_name.add("Myntra");
                arrayList_name.add("Ali Express");
                arrayList_name.add("Snapdeal");
                arrayList_name.add("Nykaa");
                arrayList_name.add("Paytm Mall");
                arrayList_name.add("Shopclues");
                arrayList_name.add("Abof");
                arrayList_name.add("Ajio");
                arrayList_name.add("Bang Good");
                arrayList_name.add("Beardo");
                arrayList_name.add("Chumbak");
                arrayList_name.add("Clovia");
                arrayList_name.add("Clubfactory");
                arrayList_name.add("Fabindia");
                arrayList_name.add("First Cry");
                arrayList_name.add("Forever 21");
                arrayList_name.add("Health Kart");
                arrayList_name.add("Homeshop18");
                arrayList_name.add("Jockey");
                arrayList_name.add("Koovs");
                arrayList_name.add("Lenskart");
                arrayList_name.add("Limeroad");
                arrayList_name.add("Shein");
                arrayList_name.add("Tata Cliq");
                arrayList_name.add("The Man Company");
                arrayList_name.add("Ustraa");
                arrayList_name.add("Voonik");
                arrayList_name.add("Zivame");

                arrayList_url = new ArrayList<>();
                arrayList_url.add("www.amazon.in");
                arrayList_url.add("www.flipkart.com");
                arrayList_url.add("www.myntra.com");
                arrayList_url.add("www.aliexpress.com");
                arrayList_url.add("www.snapdeal.com");
                arrayList_url.add("www.nykaa.com");
                arrayList_url.add("www.paytmmall.com");
                arrayList_url.add("www.shopclues.com");
                arrayList_url.add("www.abof.com");
                arrayList_url.add("www.ajio.com");
                arrayList_url.add("www.banggood.in");
                arrayList_url.add("www.beardo.in");
                arrayList_url.add("www.chumbak.com");
                arrayList_url.add("www.clovia.com");
                arrayList_url.add("www.clubfactory.com");
                arrayList_url.add("www.fabindia.com");
                arrayList_url.add("www.firstcry.com");
                arrayList_url.add("www.forever21.com");
                arrayList_url.add("www.healthkart.com");
                arrayList_url.add("www.homeshop18.com");
                arrayList_url.add("www.jockey.com");
                arrayList_url.add("www.koovs.com");
                arrayList_url.add("www.lenskart.com");
                arrayList_url.add("www.limeroad.com");
                arrayList_url.add("www.shein.com");
                arrayList_url.add("www.tatacliq.com");
                arrayList_url.add("www.themancompany.com");
                arrayList_url.add("www.ustraa.com");
                arrayList_url.add("www.voonik.com");
                arrayList_url.add("www.zivame.com");

                arrayList_logo = new ArrayList<>();
                arrayList_logo.add(R.drawable.amazon);
                arrayList_logo.add(R.drawable.flipkart);
                arrayList_logo.add(R.drawable.myntra);
                arrayList_logo.add(R.drawable.aliexpress);
                arrayList_logo.add(R.drawable.snapdeal);
                arrayList_logo.add(R.drawable.nykaa);
                arrayList_logo.add(R.drawable.paytmmall);
                arrayList_logo.add(R.drawable.shopclues);
                arrayList_logo.add(R.drawable.abof);
                arrayList_logo.add(R.drawable.ajio);
                arrayList_logo.add(R.drawable.banggood);
                arrayList_logo.add(R.drawable.beardo);
                arrayList_logo.add(R.drawable.chumbak);
                arrayList_logo.add(R.drawable.clovia);
                arrayList_logo.add(R.drawable.clubfactory);
                arrayList_logo.add(R.drawable.fabindia);
                arrayList_logo.add(R.drawable.firstcry);
                arrayList_logo.add(R.drawable.forever21);
                arrayList_logo.add(R.drawable.healthkart);
                arrayList_logo.add(R.drawable.homeshop18);
                arrayList_logo.add(R.drawable.jockey);
                arrayList_logo.add(R.drawable.koovs);
                arrayList_logo.add(R.drawable.lenskart);
                arrayList_logo.add(R.drawable.limeroad);
                arrayList_logo.add(R.drawable.shein);
                arrayList_logo.add(R.drawable.tatacliq);
                arrayList_logo.add(R.drawable.themancompany);
                arrayList_logo.add(R.drawable.ustraa);
                arrayList_logo.add(R.drawable.voonik);
                arrayList_logo.add(R.drawable.zivame);

                storeGridViewAdapter = new StoreGridViewAdapter(arrayList_logo, arrayList_name);
                gridView.setAdapter(storeGridViewAdapter);
                gridViewItemClickListener();
                break;

            case "Shopping Stores":
                arrayList_name = new ArrayList<>();
                arrayList_name.add("Amazon");
                arrayList_name.add("Big Basket");
                arrayList_name.add("Flipkart");

                arrayList_url = new ArrayList<>();
                arrayList_url.add("www.amazon.in");
                arrayList_url.add("www.bigbasket.com");
                arrayList_url.add("www.flipkart.com");

                arrayList_logo = new ArrayList<>();
                arrayList_logo.add(R.drawable.amazon);
                arrayList_logo.add(R.drawable.bigbasket);
                arrayList_logo.add(R.drawable.flipkart);

                storeGridViewAdapter = new StoreGridViewAdapter(arrayList_logo, arrayList_name);
                gridView.setAdapter(storeGridViewAdapter);
                gridViewItemClickListener();
                break;

            case "Men's Store":
                arrayList_name = new ArrayList<>();
                arrayList_name.add("Jockey");
                arrayList_name.add("Koovs");
                arrayList_name.add("Abof");
                arrayList_name.add("Jabong");
                arrayList_name.add("Myntra");
                arrayList_name.add("Asos");
                arrayList_name.add("Lifestyle");
                arrayList_name.add("Maxfashion");
                arrayList_name.add("Bewakoof");
                arrayList_name.add("nnnow");
                arrayList_name.add("Westside");
                arrayList_name.add("Shoppersstop");
                arrayList_name.add("Ajio");
                arrayList_name.add("Voonik");
                arrayList_name.add("Forever21");

                arrayList_url = new ArrayList<>();
                arrayList_url.add("https://www.jockey.in/men/products");
                arrayList_url.add("https://www.koovs.com/men");
                arrayList_url.add("https://www.abof.com/men");
                arrayList_url.add("www.jabong.com");
                arrayList_url.add("https://www.myntra.com/shop/men");
                arrayList_url.add("https://www.asos.com/men");
                arrayList_url.add("https://www.lifestylestores.com/in/en/b/men");
                arrayList_url.add("https://www.maxfashion.in/in/en/department/maxmen");
                arrayList_url.add("https://www.bewakoof.com/shop-men");
                arrayList_url.add("https://www.nnnow.com/men-fashion");
                arrayList_url.add("https://www.westside.com/collections/man");
                arrayList_url.add("https://www.shoppersstop.com/men/c-A10");
                arrayList_url.add("https://www.ajio.com/shop/men");
                arrayList_url.add("https://voonik.com/collections/tshirts");
                arrayList_url.add("https://www.forever21.in");



                arrayList_logo = new ArrayList<>();
                arrayList_logo.add(R.drawable.jockey);
                arrayList_logo.add(R.drawable.koovs);
                arrayList_logo.add(R.drawable.abof);
                arrayList_logo.add(R.drawable.jabong);
                arrayList_logo.add(R.drawable.myntra);
                arrayList_logo.add(R.drawable.asos);
                arrayList_logo.add(R.drawable.lifestyle);
                arrayList_logo.add(R.drawable.maxfashion);
                arrayList_logo.add(R.drawable.bewakoof);
                arrayList_logo.add(R.drawable.nnnow);
                arrayList_logo.add(R.drawable.westside);
                arrayList_logo.add(R.drawable.shoppersstop);
                arrayList_logo.add(R.drawable.ajio);
                arrayList_logo.add(R.drawable.voonik);
                arrayList_logo.add(R.drawable.forever21);

                storeGridViewAdapter = new StoreGridViewAdapter(arrayList_logo, arrayList_name);
                gridView.setAdapter(storeGridViewAdapter);
                gridViewItemClickListener();
                break;

            case "Women's Store":
                arrayList_name = new ArrayList<>();
                arrayList_name.add("Zivame");
                arrayList_name.add("Clovia");
                arrayList_name.add("Myntra");
                arrayList_name.add("Limeroad");
                arrayList_name.add("Koovs");
                arrayList_name.add("Shein");
                arrayList_name.add("Ajio");
                arrayList_name.add("Abof");
                arrayList_name.add("Asos");
                arrayList_name.add("Chumbak");
                arrayList_name.add("Fabindia");
                arrayList_name.add("Forever21");
                arrayList_name.add("Globaldesi");
                arrayList_name.add("Jabong");
                arrayList_name.add("Jockey");
                arrayList_name.add("Lifestyle");
                arrayList_name.add("Shoppersstop");
                arrayList_name.add("Soch");
                arrayList_name.add("Voonik");
                arrayList_name.add("Westside");
                arrayList_name.add("FA");

                arrayList_url = new ArrayList<>();
                arrayList_url.add("www.zivame.com");
                arrayList_url.add("www.clovia.com");
                arrayList_url.add("https://www.myntra.com/shop/women");
                arrayList_url.add("https://www.limeroad.com/women");
                arrayList_url.add("https://www.koovs.com/women");
                arrayList_url.add("www.shein.in");
                arrayList_url.add("https://www.ajio.com/shop/women");
                arrayList_url.add("https://www.abof.com/women");
                arrayList_url.add("https://www.asos.com/women");
                arrayList_url.add("www.chumbak.com");
                arrayList_url.add("https://www.fabindia.com/shop/women-products");
                arrayList_url.add("https://www.forever21.in");
                arrayList_url.add("https://www.globaldesi.in/");
                arrayList_url.add("www.jabong.com");
                arrayList_url.add("https://www.jockey.in/women/products");
                arrayList_url.add("https://www.lifestylestores.com/in/en/b/women");
                arrayList_url.add("www.shoppersstop.com");
                arrayList_url.add("https://www.sochstore.com/in/");
                arrayList_url.add("www.voonik.com");
                arrayList_url.add("https://www.westside.com/collections/woman");
                arrayList_url.add("www.faballey.com");

                arrayList_logo = new ArrayList<>();
                arrayList_logo.add(R.drawable.zivame);
                arrayList_logo.add(R.drawable.clovia);
                arrayList_logo.add(R.drawable.myntra);
                arrayList_logo.add(R.drawable.limeroad);
                arrayList_logo.add(R.drawable.koovs);
                arrayList_logo.add(R.drawable.shein);
                arrayList_logo.add(R.drawable.ajio);
                arrayList_logo.add(R.drawable.abof);
                arrayList_logo.add(R.drawable.asos);
                arrayList_logo.add(R.drawable.chumbak);
                arrayList_logo.add(R.drawable.fabindia);
                arrayList_logo.add(R.drawable.forever21);
                arrayList_logo.add(R.drawable.globaldesi);
                arrayList_logo.add(R.drawable.jabong);
                arrayList_logo.add(R.drawable.jockey);
                arrayList_logo.add(R.drawable.lifestyle);
                arrayList_logo.add(R.drawable.shoppersstop);
                arrayList_logo.add(R.drawable.soch);
                arrayList_logo.add(R.drawable.voonik);
                arrayList_logo.add(R.drawable.westside);
                arrayList_logo.add(R.drawable.faballey);

                storeGridViewAdapter = new StoreGridViewAdapter(arrayList_logo, arrayList_name);
                gridView.setAdapter(storeGridViewAdapter);
                gridViewItemClickListener();
                break;

            case "Movies & Events":
                arrayList_name = new ArrayList<>();
                arrayList_name.add("BookMyShow");
                arrayList_name.add("Amazon Pay");
                arrayList_name.add("Paytm Movie");
                arrayList_name.add("Ticket New");
                arrayList_name.add("Townscript");
                arrayList_name.add("PVR Cinemas");

                arrayList_url = new ArrayList<>();
                arrayList_url.add("in.bookmyshow.com");
                arrayList_url.add("https://www.amazon.in/gp/sva/dashboard?ref_=nav_cs_apay");
                arrayList_url.add("https://paytm.com/movies/delhi-ncr");
                arrayList_url.add("https://www.ticketnew.com/");
                arrayList_url.add("www.townscript.com");
                arrayList_url.add("www.pvrcinemas.com");

                arrayList_logo = new ArrayList<>();
                arrayList_logo.add(R.drawable.bookmyshow);
                arrayList_logo.add(R.drawable.amazonpay);
                arrayList_logo.add(R.drawable.paytmmovie);
                arrayList_logo.add(R.drawable.ticketnew);
                arrayList_logo.add(R.drawable.townscript);
                arrayList_logo.add(R.drawable.pvrcinemas);

                storeGridViewAdapter = new StoreGridViewAdapter(arrayList_logo, arrayList_name);
                gridView.setAdapter(storeGridViewAdapter);
                gridViewItemClickListener();
                break;

            case "Tour & Travel":
                arrayList_name = new ArrayList<>();
                arrayList_name.add("MakeMyTrip");
                arrayList_name.add("Goibibo");
                arrayList_name.add("Yatra");
                arrayList_name.add("Ixigo");
                arrayList_name.add("Easemytrip");
                arrayList_name.add("Cleartrip");
                arrayList_name.add("Travel Triangle");
                arrayList_name.add("Via");
                arrayList_name.add("Tripadvisor");
                arrayList_name.add("Travelguru");//
                arrayList_name.add("Thrillophilia");
                arrayList_name.add("Paytm Travel");
                arrayList_name.add("Expedia");//
                arrayList_name.add("Booking.com");
                arrayList_name.add("Hotels.com");


                arrayList_url = new ArrayList<>();
                arrayList_url.add("www.makemytrip.com");
                arrayList_url.add("www.goibibo.com");
                arrayList_url.add("www.yatra.com");
                arrayList_url.add("www.ixigo.com");
                arrayList_url.add("www.easemytrip.com");
                arrayList_url.add("www.cleartrip.com");
                arrayList_url.add("www.traveltriangle.com");
                arrayList_url.add("in.via.com");
                arrayList_url.add("www.tripadvisor.in");
                arrayList_url.add("www.travelguru.com");
                arrayList_url.add("www.thrillophilia.com");
                arrayList_url.add("https://paytm.com/offer/travel/");
                arrayList_url.add("www.expedia.co.in");
                arrayList_url.add("www.booking.com");
                arrayList_url.add("www.hotels.com");

                arrayList_logo = new ArrayList<>();
                arrayList_logo.add(R.drawable.makemytrip);
                arrayList_logo.add(R.drawable.goibibo);
                arrayList_logo.add(R.drawable.yatra);
                arrayList_logo.add(R.drawable.ixigo);
                arrayList_logo.add(R.drawable.easemytrip);
                arrayList_logo.add(R.drawable.cleartrip);
                arrayList_logo.add(R.drawable.traveltriangle);
                arrayList_logo.add(R.drawable.via);
                arrayList_logo.add(R.drawable.tripadvisor);
                arrayList_logo.add(R.drawable.travelguru);
                arrayList_logo.add(R.drawable.thrillophilia);
                arrayList_logo.add(R.drawable.paytmtravel);
                arrayList_logo.add(R.drawable.expedia);
                arrayList_logo.add(R.drawable.booking);
                arrayList_logo.add(R.drawable.hotels);

                storeGridViewAdapter = new StoreGridViewAdapter(arrayList_logo, arrayList_name);
                gridView.setAdapter(storeGridViewAdapter);
                gridViewItemClickListener();
                break;

            case "Hotel & Stay":
                arrayList_name = new ArrayList<>();
                arrayList_name.add("Agoda");
                arrayList_name.add("Airbnb");
                arrayList_name.add("Oyo");
                arrayList_name.add("Oyo Life");
                arrayList_name.add("Goomo");
                arrayList_name.add("Fabhotels");
                arrayList_name.add("Paytm Hotels");
                arrayList_name.add("Treebo");
                arrayList_name.add("Trivago");
                arrayList_name.add("Booking.com");
                arrayList_name.add("Hotel.com");
                arrayList_name.add("Ixigo");
                arrayList_name.add("Goibibo");
                arrayList_name.add("Yatra");
                arrayList_name.add("Makemytrip");
                arrayList_name.add("Tripadvisor");
                arrayList_name.add("Expedia");
                arrayList_name.add("Cleartrip");

                arrayList_url = new ArrayList<>();
                arrayList_url.add("www.agoda.com");
                arrayList_url.add("www.airbnb.co.in");
                arrayList_url.add("www.oyorooms.com");
                arrayList_url.add("www.oyolife.in");
                arrayList_url.add("www.goomo.com");
                arrayList_url.add("www.fabhotels.com");
                arrayList_url.add("https://paytm.com/hotels");
                arrayList_url.add("www.treebo.com");
                arrayList_url.add("www.trivago.in");
                arrayList_url.add("www.booking.com");
                arrayList_url.add("www.hotel.com");
                arrayList_url.add("https://www.ixigo.com/hotels");
                arrayList_url.add("https://www.goibibo.com/hotels/");
                arrayList_url.add("https://www.yatra.com/hotels");
                arrayList_url.add("https://www.makemytrip.com/hotels/");
                arrayList_url.add("https://www.tripadvisor.in/Hotels");
                arrayList_url.add("https://www.expedia.co.in/Hotels");
                arrayList_url.add("https://www.cleartrip.com/hotels");

                arrayList_logo = new ArrayList<>();
                arrayList_logo.add(R.drawable.agoda);
                arrayList_logo.add(R.drawable.airbnb);
                arrayList_logo.add(R.drawable.oyo);
                arrayList_logo.add(R.drawable.oyolife);
                arrayList_logo.add(R.drawable.goomo);
                arrayList_logo.add(R.drawable.fabhotels);
                arrayList_logo.add(R.drawable.paytm_hotels);
                arrayList_logo.add(R.drawable.treebo);
                arrayList_logo.add(R.drawable.trivago);
                arrayList_logo.add(R.drawable.booking);
                arrayList_logo.add(R.drawable.hotel);
                arrayList_logo.add(R.drawable.ixigo);
                arrayList_logo.add(R.drawable.goibibo);
                arrayList_logo.add(R.drawable.yatra);
                arrayList_logo.add(R.drawable.makemytrip);
                arrayList_logo.add(R.drawable.tripadvisor);
                arrayList_logo.add(R.drawable.expedia);
                arrayList_logo.add(R.drawable.cleartrip);

                storeGridViewAdapter = new StoreGridViewAdapter(arrayList_logo, arrayList_name);
                gridView.setAdapter(storeGridViewAdapter);
                gridViewItemClickListener();
                break;

            case "Recharges & Bills":
                arrayList_name = new ArrayList<>();
                arrayList_name.add("Jio");
                arrayList_name.add("Airtel");
                arrayList_name.add("Paytm");
                arrayList_name.add("Freecharge");
                arrayList_name.add("Mobikwik");
                arrayList_name.add("Amazon Pay");

                arrayList_url = new ArrayList<>();
                arrayList_url.add("https://www.jio.com/en-in/4g-plans");
                arrayList_url.add("https://www.airtel.in/prepaid-recharge/");
                arrayList_url.add("https://paytm.com/recharge");
                arrayList_url.add("https://www.freecharge.in/prepaid");
                arrayList_url.add("https://www.mobikwik.com/prepaid-recharge");
                arrayList_url.add("https://www.amazon.in/gp/sva/dashboard?ref_=nav_cs_apay");

                arrayList_logo = new ArrayList<>();
                arrayList_logo.add(R.drawable.jio);
                arrayList_logo.add(R.drawable.airtel);
                arrayList_logo.add(R.drawable.paytm);
                arrayList_logo.add(R.drawable.freecharge);
                arrayList_logo.add(R.drawable.mobikwik);
                arrayList_logo.add(R.drawable.amazonpay);

                storeGridViewAdapter = new StoreGridViewAdapter(arrayList_logo, arrayList_name);
                gridView.setAdapter(storeGridViewAdapter);
                gridViewItemClickListener();
                break;

            case "Online Food":
                arrayList_name = new ArrayList<>();
                arrayList_name.add("Zomato");
                arrayList_name.add("Swiggy");
                arrayList_name.add("Faasos");
                arrayList_name.add("Box8");
                arrayList_name.add("Freshmenu");
                arrayList_name.add("Cure.fit");

                arrayList_url = new ArrayList<>();
                arrayList_url.add("https://www.zomato.com/ncr/order-food-online");
                arrayList_url.add("https://www.swiggy.com/");
                arrayList_url.add("https://order.faasos.io/");
                arrayList_url.add("https://box8.in/");
                arrayList_url.add("https://www.freshmenu.com/");
                arrayList_url.add("https://www.cure.fit/");

                arrayList_logo = new ArrayList<>();
                arrayList_logo.add(R.drawable.zomato);
                arrayList_logo.add(R.drawable.swiggy);
                arrayList_logo.add(R.drawable.faasos);
                arrayList_logo.add(R.drawable.box8);
                arrayList_logo.add(R.drawable.freshmenu);
                arrayList_logo.add(R.drawable.cure_fit);

                storeGridViewAdapter = new StoreGridViewAdapter(arrayList_logo, arrayList_name);
                gridView.setAdapter(storeGridViewAdapter);
                gridViewItemClickListener();
                break;

            case "Meat & Dairy":
                arrayList_name = new ArrayList<>();
                arrayList_name.add("Big Basket");
                arrayList_name.add("Freshtohome");
                arrayList_name.add("Grofers");
                arrayList_name.add("Licious");
                arrayList_name.add("Tendercuts");
                arrayList_name.add("Zappfresh");

                arrayList_url = new ArrayList<>();
                arrayList_url.add("www.bigbasket.com");
                arrayList_url.add("www.freshtohome.com");
                arrayList_url.add("www.grofers.com");
                arrayList_url.add("www.licious.in");
                arrayList_url.add("www.tendercuts.in");
                arrayList_url.add("www.zappfresh.com");

                arrayList_logo = new ArrayList<>();
                arrayList_logo.add(R.drawable.bigbasket);
                arrayList_logo.add(R.drawable.freshtohome);
                arrayList_logo.add(R.drawable.grofers);
                arrayList_logo.add(R.drawable.licious);
                arrayList_logo.add(R.drawable.tendercuts);
                arrayList_logo.add(R.drawable.zappfresh);

                storeGridViewAdapter = new StoreGridViewAdapter(arrayList_logo, arrayList_name);
                gridView.setAdapter(storeGridViewAdapter);
                gridViewItemClickListener();
                break;

            case "Grocery":
                arrayList_name = new ArrayList<>();
                arrayList_name.add("Big Basket");
                arrayList_name.add("Grofers");
                arrayList_name.add("Amazon Pantry");
                arrayList_name.add("Flipkart Supermart");
                arrayList_name.add("Jio Mart");
                arrayList_name.add("Nature's Basket");
                arrayList_name.add("Spencer's");
                arrayList_name.add("StarQuik");
                arrayList_name.add("Paytm Mall");

                arrayList_url = new ArrayList<>();
                arrayList_url.add("www.bigbasket.com");
                arrayList_url.add("www.grofers.com");
                arrayList_url.add("www.amazon.in");
                arrayList_url.add("https://www.flipkart.com/grocery-supermart-store?marketplace=GROCERY");
                arrayList_url.add("https://www.jiomart.com/");
                arrayList_url.add("https://www.naturesbasket.co.in/");
                arrayList_url.add("https://www.spencers.in/");
                arrayList_url.add("https://www.starquik.com/");
                arrayList_url.add("https://paytmmall.com");

                arrayList_logo = new ArrayList<>();
                arrayList_logo.add(R.drawable.bigbasket);
                arrayList_logo.add(R.drawable.grofers);
                arrayList_logo.add(R.drawable.amazonpantry);
                arrayList_logo.add(R.drawable.flipkartsupermarket);
                arrayList_logo.add(R.drawable.jiomart);
                arrayList_logo.add(R.drawable.naturesbasket);
                arrayList_logo.add(R.drawable.spencers);
                arrayList_logo.add(R.drawable.starquik);
                arrayList_logo.add(R.drawable.paytmmall);

                storeGridViewAdapter = new StoreGridViewAdapter(arrayList_logo, arrayList_name);
                gridView.setAdapter(storeGridViewAdapter);
                gridViewItemClickListener();
                break;

            case "Pizza & Cafe":
                arrayList_name = new ArrayList<>();
                arrayList_name.add("Dominos");
                arrayList_name.add("Chai Point");
                arrayList_name.add("Chaayos");
                arrayList_name.add("Burger King");
                arrayList_name.add("KFC");
                arrayList_name.add("Dunkin Donuts");
                arrayList_name.add("Pizza Hut");
                arrayList_name.add("McDonald's");
                arrayList_name.add("Swiggy");

                arrayList_url = new ArrayList<>();
                arrayList_url.add("www.dominos.co.in");
                arrayList_url.add("https://chaipoint.com/");
                arrayList_url.add("https://www.chaayos.com/");
                arrayList_url.add("http://www.burgerkingindia.in/");
                arrayList_url.add("https://online.kfc.co.in/");
                arrayList_url.add("http://www.dunkinindia.com/");
                arrayList_url.add("https://www.pizzahut.co.in/");
                arrayList_url.add("https://www.mcdonaldsindia.com/");
                arrayList_url.add("https://www.swiggy.com/");

                arrayList_logo = new ArrayList<>();
                arrayList_logo.add(R.drawable.dominos);
                arrayList_logo.add(R.drawable.chaipoint);
                arrayList_logo.add(R.drawable.chaayos);
                arrayList_logo.add(R.drawable.burgerking);
                arrayList_logo.add(R.drawable.kfc);
                arrayList_logo.add(R.drawable.dunkindonuts);
                arrayList_logo.add(R.drawable.pizzahut);
                arrayList_logo.add(R.drawable.mcdonalds);
                arrayList_logo.add(R.drawable.swiggy);

                storeGridViewAdapter = new StoreGridViewAdapter(arrayList_logo, arrayList_name);
                gridView.setAdapter(storeGridViewAdapter);
                gridViewItemClickListener();
                break;

            case "Mom & Kids":
                arrayList_name = new ArrayList<>();
                arrayList_name.add("Hopscotch");
                arrayList_name.add("Baby Couture");
                arrayList_name.add("First Cry");
                arrayList_name.add("Maxfashion");
                arrayList_name.add("Ajio");
                arrayList_name.add("Myntra");

                arrayList_url = new ArrayList<>();
                arrayList_url.add("https://www.hopscotch.in/");
                arrayList_url.add("https://www.babycouture.in/");
                arrayList_url.add("https://www.firstcry.com/");
                arrayList_url.add("www.maxfashion.in");
                arrayList_url.add("https://www.ajio.com/shop/kids");
                arrayList_url.add("https://www.myntra.com/shop/kids");

                arrayList_logo = new ArrayList<>();
                arrayList_logo.add(R.drawable.hopscotch);
                arrayList_logo.add(R.drawable.babycouture);
                arrayList_logo.add(R.drawable.firstcry);
                arrayList_logo.add(R.drawable.maxfashion);
                arrayList_logo.add(R.drawable.ajio);
                arrayList_logo.add(R.drawable.myntra);

                storeGridViewAdapter = new StoreGridViewAdapter(arrayList_logo, arrayList_name);
                gridView.setAdapter(storeGridViewAdapter);
                gridViewItemClickListener();
                break;

            case "Health & Medicine":
                arrayList_name = new ArrayList<>();
                arrayList_name.add("1mg");
                arrayList_name.add("Health Kart");
                arrayList_name.add("HealthXP");
                arrayList_name.add("Lybrate");
                arrayList_name.add("Medplusmart");
                arrayList_name.add("Muscle Blaze");
                arrayList_name.add("My Protein");
                arrayList_name.add("Pharmeasy");
                arrayList_name.add("Zoylo");
                arrayList_name.add("Netmeds");
                arrayList_name.add("Nutrabay");
                arrayList_name.add("Medlife");

                arrayList_url = new ArrayList<>();
                arrayList_url.add("www.1mg.com");
                arrayList_url.add("www.healthkart.com");
                arrayList_url.add("www.healthxp.in");
                arrayList_url.add("www.lybrate.com");
                arrayList_url.add("www.medplusmart.com");
                arrayList_url.add("www.muscleblaze.com");
                arrayList_url.add("www.myprotein.co.in");
                arrayList_url.add("www.pharmeasy.in");
                arrayList_url.add("www.zoylo.com");
                arrayList_url.add("www.netmeds.com");
                arrayList_url.add("www.nutrabay.com");
                arrayList_url.add("www.medlife.com");


                arrayList_logo = new ArrayList<>();
                arrayList_logo.add(R.drawable._1mg);
                arrayList_logo.add(R.drawable.healthkart);
                arrayList_logo.add(R.drawable.healthxp);
                arrayList_logo.add(R.drawable.lybrate);
                arrayList_logo.add(R.drawable.medplusmart);
                arrayList_logo.add(R.drawable.muscleblaze);
                arrayList_logo.add(R.drawable.myprotein);
                arrayList_logo.add(R.drawable.pharmeasy);
                arrayList_logo.add(R.drawable.zoylo);
                arrayList_logo.add(R.drawable.netmeds);
                arrayList_logo.add(R.drawable.nutrabay);
                arrayList_logo.add(R.drawable.medlife);

                storeGridViewAdapter = new StoreGridViewAdapter(arrayList_logo, arrayList_name);
                gridView.setAdapter(storeGridViewAdapter);
                gridViewItemClickListener();
                break;

            case "Decor & Furniture":
                arrayList_name = new ArrayList<>();
                arrayList_name.add("Cityfurnish");
                arrayList_name.add("Furlenco");
                arrayList_name.add("GrabonRent");
                arrayList_name.add("Guarented");
                arrayList_name.add("Homedecor");
                arrayList_name.add("Hometown");
                arrayList_name.add("Insaraf");
                arrayList_name.add("Pepperfry");
                arrayList_name.add("Rentickle");
                arrayList_name.add("Rentomojo");
                arrayList_name.add("Woodenstreet");
                arrayList_name.add("Myntra");

                arrayList_url = new ArrayList<>();
                arrayList_url.add("www.cityfurnish.com");
                arrayList_url.add("www.furlenco.com");
                arrayList_url.add("www.grabonrent.com");
                arrayList_url.add("www.guarented.com");
                arrayList_url.add("www.homedecors.in");
                arrayList_url.add("www.hometown.in");
                arrayList_url.add("www.insaraf.co.in");
                arrayList_url.add("www.pepperfry.in");
                arrayList_url.add("www.rentickle.com");
                arrayList_url.add("www.rentomojo.com");
                arrayList_url.add("www.woodenstreet.com");
                arrayList_url.add("https://www.myntra.com/home-decor");

                arrayList_logo = new ArrayList<>();
                arrayList_logo.add(R.drawable.cityfurnish);
                arrayList_logo.add(R.drawable.furlenco);
                arrayList_logo.add(R.drawable.grabonrent);
                arrayList_logo.add(R.drawable.guarented);
                arrayList_logo.add(R.drawable.homedecor);
                arrayList_logo.add(R.drawable.hometown);
                arrayList_logo.add(R.drawable.insaraf);
                arrayList_logo.add(R.drawable.pepperfry);
                arrayList_logo.add(R.drawable.rentickle);
                arrayList_logo.add(R.drawable.rentomojo);
                arrayList_logo.add(R.drawable.woodenstreet);
                arrayList_logo.add(R.drawable.myntra);

                storeGridViewAdapter = new StoreGridViewAdapter(arrayList_logo, arrayList_name);
                gridView.setAdapter(storeGridViewAdapter);
                gridViewItemClickListener();
                break;

            case "Beauty & Groom":
                arrayList_name = new ArrayList<>();
                arrayList_name.add("Beardo");
                arrayList_name.add("Purplle");
                arrayList_name.add("Sugar Cosmetics");
                arrayList_name.add("The Body Shop");
                arrayList_name.add("The Man Cosmetics");
                arrayList_name.add("Ustraa");
                arrayList_name.add("Wow");
                arrayList_name.add("Nykaa");
                arrayList_name.add("Myntra");

                arrayList_url = new ArrayList<>();
                arrayList_url.add("www.beardo.in");
                arrayList_url.add("www.purplle.com");
                arrayList_url.add("www.sugarcosmetics.com");
                arrayList_url.add("www.thebodyshop.com");
                arrayList_url.add("www.themancompany.com");
                arrayList_url.add("www.ustraa.com");
                arrayList_url.add("www.buywow.com");
                arrayList_url.add("www.nykaa.com");
                arrayList_url.add("https://www.myntra.com/essentials");

                arrayList_logo = new ArrayList<>();
                arrayList_logo.add(R.drawable.beardo);
                arrayList_logo.add(R.drawable.purplle);
                arrayList_logo.add(R.drawable.sugarcosmetics);
                arrayList_logo.add(R.drawable.thebodyshop);
                arrayList_logo.add(R.drawable.themancompany);
                arrayList_logo.add(R.drawable.ustraa);
                arrayList_logo.add(R.drawable.wow);
                arrayList_logo.add(R.drawable.nykaa);
                arrayList_logo.add(R.drawable.myntra);

                storeGridViewAdapter = new StoreGridViewAdapter(arrayList_logo, arrayList_name);
                gridView.setAdapter(storeGridViewAdapter);
                gridViewItemClickListener();
                break;

            case "Flowers & Gifts":
                arrayList_name = new ArrayList<>();
                arrayList_name.add("Archies");
                arrayList_name.add("Bigsmall");
                arrayList_name.add("Flaberry");
                arrayList_name.add("Floweraura");
                arrayList_name.add("Ferns n Petals");
                arrayList_name.add("Giftalove");
                arrayList_name.add("Giftsmate");
                arrayList_name.add("igp");
                arrayList_name.add("Indiagift");
                arrayList_name.add("Myflowertree");
                arrayList_name.add("Oyehappy");
                arrayList_name.add("Phoolwala");
                arrayList_name.add("Printland");
                arrayList_name.add("Printvenue");
                arrayList_name.add("Winni");

                arrayList_url = new ArrayList<>();
                arrayList_url.add("https://www.archiesonline.com/");
                arrayList_url.add("https://www.bigsmall.in/");
                arrayList_url.add("https://www.flaberry.com/");
                arrayList_url.add("https://www.floweraura.com/");
                arrayList_url.add("https://www.fnp.com/");
                arrayList_url.add("https://www.giftalove.com/");
                arrayList_url.add("https://www.giftsmate.net/");
                arrayList_url.add("https://www.igp.com/");
                arrayList_url.add("https://www.indiagift.in/");
                arrayList_url.add("https://www.myflowertree.com/");
                arrayList_url.add("https://www.oyehappy.com/");
                arrayList_url.add("https://www.phoolwala.com/");
                arrayList_url.add("https://www.printland.in/");
                arrayList_url.add("https://www.printvenue.com/");
                arrayList_url.add("https://www.winni.in/");

                arrayList_logo = new ArrayList<>();
                arrayList_logo.add(R.drawable.archies);
                arrayList_logo.add(R.drawable.bigsmall);
                arrayList_logo.add(R.drawable.flaberry);
                arrayList_logo.add(R.drawable.floweraura);
                arrayList_logo.add(R.drawable.fernsnpetals);
                arrayList_logo.add(R.drawable.giftalove);
                arrayList_logo.add(R.drawable.giftsmate);
                arrayList_logo.add(R.drawable.igp);
                arrayList_logo.add(R.drawable.indiagift);
                arrayList_logo.add(R.drawable.myflowertree);
                arrayList_logo.add(R.drawable.oyehappy);
                arrayList_logo.add(R.drawable.phoolwala);
                arrayList_logo.add(R.drawable.printland);
                arrayList_logo.add(R.drawable.printvenue);
                arrayList_logo.add(R.drawable.winni);

                storeGridViewAdapter = new StoreGridViewAdapter(arrayList_logo, arrayList_name);
                gridView.setAdapter(storeGridViewAdapter);
                gridViewItemClickListener();
                break;

            case "Services & Repairs":
                arrayList_name = new ArrayList<>();
                arrayList_name.add("Urban Company");
                arrayList_name.add("Helpr");
                arrayList_name.add("Mr Right");
                arrayList_name.add("House Joy");
                arrayList_name.add("Quickr");

                arrayList_url = new ArrayList<>();
                arrayList_url.add("https://www.urbancompany.com/");
                arrayList_url.add("https://www.helpr.in/");
                arrayList_url.add("https://www.mrright.in/");
                arrayList_url.add("https://www.housejoy.in/");
                arrayList_url.add("https://www.quikr.com/services/services-bangalore-all");

                arrayList_logo = new ArrayList<>();
                arrayList_logo.add(R.drawable.urbancompany);
                arrayList_logo.add(R.drawable.helpr);
                arrayList_logo.add(R.drawable.mrright);
                arrayList_logo.add(R.drawable.housejoy);
                arrayList_logo.add(R.drawable.quickr);

                storeGridViewAdapter = new StoreGridViewAdapter(arrayList_logo, arrayList_name);
                gridView.setAdapter(storeGridViewAdapter);
                gridViewItemClickListener();
                break;

            case "Flights":
                arrayList_name = new ArrayList<>();
                arrayList_name.add("Air Asia");
                arrayList_name.add("Go Air");
                arrayList_name.add("Indigo");
                arrayList_name.add("Ixigo");
                arrayList_name.add("Paytm Flights");
                arrayList_name.add("Skyscanner");
                arrayList_name.add("Spicejet");
                arrayList_name.add("Expedia");
                arrayList_name.add("Cleartrip");
                arrayList_name.add("Goibibo");
                arrayList_name.add("Makemytrip");
                arrayList_name.add("Yatra");

                arrayList_url = new ArrayList<>();
                arrayList_url.add("https://www.airasia.com/en/gb");
                arrayList_url.add("https://www.goair.in/");
                arrayList_url.add("https://www.goindigo.in/");
                arrayList_url.add("https://www.ixigo.com/flights");
                arrayList_url.add("https://paytm.com/flights");
                arrayList_url.add("https://www.skyscanner.co.in/");
                arrayList_url.add("https://www.spicejet.com/default.aspx");
                arrayList_url.add("https://www.expedia.co.in/Flights");
                arrayList_url.add("https://om.cleartrip.com/flights");
                arrayList_url.add("https://www.goibibo.com/flights/");
                arrayList_url.add("https://www.makemytrip.com/flights/");
                arrayList_url.add("https://www.yatra.com/flights");

                arrayList_logo = new ArrayList<>();
                arrayList_logo.add(R.drawable.airasia);
                arrayList_logo.add(R.drawable.goair);
                arrayList_logo.add(R.drawable.indigo);
                arrayList_logo.add(R.drawable.ixigo_flight);
                arrayList_logo.add(R.drawable.paytmflights);
                arrayList_logo.add(R.drawable.skyscanner);
                arrayList_logo.add(R.drawable.spicejet);
                arrayList_logo.add(R.drawable.expedia);
                arrayList_logo.add(R.drawable.cleartrip);
                arrayList_logo.add(R.drawable.goibibo);
                arrayList_logo.add(R.drawable.makemytrip);
                arrayList_logo.add(R.drawable.yatra);


                storeGridViewAdapter = new StoreGridViewAdapter(arrayList_logo, arrayList_name);
                gridView.setAdapter(storeGridViewAdapter);
                gridViewItemClickListener();
                break;

            case "Cabs & Bikes":
                arrayList_name = new ArrayList<>();
                arrayList_name.add("Uber");
                arrayList_name.add("Olacabs");
                arrayList_name.add("Onn Bikes");
                arrayList_name.add("Revv");
                arrayList_name.add("Zoom Car");
                arrayList_name.add("Meru");

                arrayList_url = new ArrayList<>();
                arrayList_url.add("https://www.uber.com/in/en/");
                arrayList_url.add("https://www.olacabs.com/");
                arrayList_url.add("https://www.onnbikes.com/");
                arrayList_url.add("https://www.revv.co.in/");
                arrayList_url.add("https://www.zoomcar.com/");
                arrayList_url.add("https://www.meru.in/");

                arrayList_logo = new ArrayList<>();
                arrayList_logo.add(R.drawable.uber);
                arrayList_logo.add(R.drawable.ola);
                arrayList_logo.add(R.drawable.onn);
                arrayList_logo.add(R.drawable.revv);
                arrayList_logo.add(R.drawable.zoomcar);
                arrayList_logo.add(R.drawable.meru);


                storeGridViewAdapter = new StoreGridViewAdapter(arrayList_logo, arrayList_name);
                gridView.setAdapter(storeGridViewAdapter);
                gridViewItemClickListener();
                break;

            case "Bus":
                arrayList_name = new ArrayList<>();
                arrayList_name.add("Redbus");
                arrayList_name.add("Akbar Travels");
                arrayList_name.add("Paytm Bus");
                arrayList_name.add("Abhi Bus");
                arrayList_name.add("Ixigo");
                arrayList_name.add("Mybustickets");
                arrayList_name.add("Ticketgoose");
                arrayList_name.add("Goibibo");
                arrayList_name.add("Yatra");

                arrayList_url = new ArrayList<>();
                arrayList_url.add("www.redbus.in");
                arrayList_url.add("www.akbartravels.com");
                arrayList_url.add("https://paytm.com/bus-tickets");
                arrayList_url.add("www.abhibus.com");
                arrayList_url.add("https://www.ixigo.com/buses");
                arrayList_url.add("www.mybustickets.in");
                arrayList_url.add("www.ticketgoose.com");
                arrayList_url.add("https://www.goibibo.com/bus/#home");
                arrayList_url.add("https://www.yatra.com/bus-booking");

                arrayList_logo = new ArrayList<>();
                arrayList_logo.add(R.drawable.redbus);
                arrayList_logo.add(R.drawable.akbartravels);
                arrayList_logo.add(R.drawable.paytm_bus);
                arrayList_logo.add(R.drawable.abhibus);
                arrayList_logo.add(R.drawable.ixigo_bus);
                arrayList_logo.add(R.drawable.mybustickets);
                arrayList_logo.add(R.drawable.ticketgoose);
                arrayList_logo.add(R.drawable.goibibo);
                arrayList_logo.add(R.drawable.yatra);

                storeGridViewAdapter = new StoreGridViewAdapter(arrayList_logo, arrayList_name);
                gridView.setAdapter(storeGridViewAdapter);
                gridViewItemClickListener();
                break;

            case "Train":
                arrayList_name = new ArrayList<>();
                arrayList_name.add("Irctc");
                arrayList_name.add("Train Man");
                arrayList_name.add("Paytm Train");
                arrayList_name.add("Ixigo");
                arrayList_name.add("Railyatri");
                arrayList_name.add("Confirmtkt");

                arrayList_url = new ArrayList<>();
                arrayList_url.add("www.irctc.co.in");
                arrayList_url.add("www.trainman.in");
                arrayList_url.add("https://paytm.com/train-tickets");
                arrayList_url.add("https://www.ixigo.com/trains");
                arrayList_url.add("www.railyatri.in");
                arrayList_url.add("www.confirmtkt.com");

                arrayList_logo = new ArrayList<>();
                arrayList_logo.add(R.drawable.irctc);
                arrayList_logo.add(R.drawable.trainman);
                arrayList_logo.add(R.drawable.paytm_train);
                arrayList_logo.add(R.drawable.ixigo_train);
                arrayList_logo.add(R.drawable.railyatri);
                arrayList_logo.add(R.drawable.confirmtkt);

                storeGridViewAdapter = new StoreGridViewAdapter(arrayList_logo, arrayList_name);
                gridView.setAdapter(storeGridViewAdapter);
                gridViewItemClickListener();
                break;

            default:
                Toast.makeText(this, "No stores found!", Toast.LENGTH_LONG).show();
        }

    }

    private void gridViewItemClickListener() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(StoreActivity.this, WebViewActivity.class);
                String url = arrayList_url.get(position);
                intent.putExtra("url", CuelinksUtil.getAffiliatedUrl(url));
                //Toast.makeText(StoreActivity.this, ""+ CuelinksUtil.getAffiliatedUrl(url), Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
    }
}
