package com.example.dodziraynard.phoneticsmaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.example.dodziraynard.phoneticsmaster.Adapters.HomeIconAdapter;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.InterstitialAd;
//import com.google.android.gms.ads.MobileAds;
//import com.google.android.gms.ads.initialization.InitializationStatus;
//import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
//
import static maes.tech.intentanim.CustomIntent.customType;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView icon_recylerView;
    Button hamberger_btn;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer = findViewById(R.id.drawer_layout);
        hamberger_btn = findViewById(R.id.hamberger_btn);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        icon_recylerView = findViewById(R.id.icon_recylerView);
        icon_recylerView.setLayoutManager(new GridLayoutManager(this, 3));

        final String[] home_items = {"Monophthongs",
                                    "Diphthongs",
                                    "Consonants",
                                    "All Charts",
                                    "Phonetics",};
        final Integer[] items_bg = {R.mipmap.monophthong_ic,
                                    R.mipmap.diphthong_ic,
                                    R.mipmap.consonants_ic,
                                    R.mipmap.all_charts_ic,
                                    R.mipmap.learn_pho_ic,
                                    R.mipmap.about_ic};

        HomeIconAdapter homeIconAdapter = new HomeIconAdapter(this, home_items, items_bg);
        homeIconAdapter.setOnItemClickListener(new HomeIconAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                switch(home_items[position]){
                    case "Monophthongs":
                        Intent monophthongsIntent = new Intent(getApplicationContext(), Monophthongs.class);
                        startActivity(monophthongsIntent);
                        customType(MainActivity.this, "left-to-right");
                        break;
                    case "Diphthongs":
                        Intent diphthongsIntent = new Intent(getApplicationContext(), DiphthongsActivity.class);
                        startActivity(diphthongsIntent);
                        customType(MainActivity.this, "left-to-right");
                        break;
                    case "Consonants":
                        Intent consonantIntent = new Intent(getApplicationContext(), ConsonantsActivity.class);
                        startActivity(consonantIntent);
                        customType(MainActivity.this, "left-to-right");
                        break;
                    case "All Charts":
                        Intent allChartstIntent = new Intent(getApplicationContext(), AllChartsActivity.class);
                        startActivity(allChartstIntent);
                        customType(MainActivity.this, "left-to-right");
                        break;
                    case "Phonetics":
                        Intent learnIntent = new Intent(getApplicationContext(), LearnActivity.class);
                        startActivity(learnIntent);
                        customType(MainActivity.this, "left-to-right");
                        break;
                }
            }
        });
        icon_recylerView.setAdapter(homeIconAdapter);

        hamberger_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (drawer.isDrawerOpen(GravityCompat.START)) {
//                    drawer.closeDrawer(GravityCompat.START);
//                } else {
//                    drawer.openDrawer(GravityCompat.START);
//                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
