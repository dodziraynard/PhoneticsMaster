package com.example.dodziraynard.phoneticsmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.example.dodziraynard.phoneticsmaster.Custom.Custom;

import java.util.ArrayList;

import static maes.tech.intentanim.CustomIntent.customType;

public class AllChartsActivity extends AppCompatActivity {
    ImageView backBtn;
    GridLayout allChartsGrid;
    ArrayList<View> monButtons;
    ArrayList<View> diButtons;
    ArrayList<View> conButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_charts);
        allChartsGrid = findViewById(R.id.allChartsGrid);
        backBtn = findViewById(R.id.back_btn);
        backBtn.setOnClickListener(homeActivityListener);

        monButtons = Custom.findViewsByTag(allChartsGrid, "mon_sound");
        diButtons = Custom.findViewsByTag(allChartsGrid, "di_sound");
        conButtons = Custom.findViewsByTag(allChartsGrid, "con_sound");
        for (View button : monButtons){
            button.setOnClickListener(playMonSoundListener);
        }

        for (View button : diButtons){
            button.setOnClickListener(playDiSoundListener);
        }

        for (View button : conButtons){
            button.setOnClickListener(playConSoundListener);
        }
    }

    View.OnClickListener homeActivityListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent mainActivityIntent = new Intent(getApplicationContext(), LearnActivity.class);
            startActivity(mainActivityIntent);
            customType(AllChartsActivity.this, "right-to-left");
        }
    };

    View.OnClickListener playMonSoundListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Custom.playMonoSound(getApplicationContext(), v);
        }
    };

    View.OnClickListener playConSoundListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Custom.playConSound(getApplicationContext(), v);
        }
    };

    View.OnClickListener playDiSoundListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Custom.playDiSound(getApplicationContext(), v);
        }
    };
}
