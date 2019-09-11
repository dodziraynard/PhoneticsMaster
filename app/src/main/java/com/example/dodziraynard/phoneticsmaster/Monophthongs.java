package com.example.dodziraynard.phoneticsmaster;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.dodziraynard.phoneticsmaster.Custom.Custom;

import java.util.ArrayList;

import static maes.tech.intentanim.CustomIntent.customType;

public class Monophthongs extends AppCompatActivity {
    ImageView backBtn;
    GridLayout monGridLayout;
    ArrayList<View> buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monophthongs);
        monGridLayout = findViewById(R.id.monGridLayout);
        backBtn = findViewById(R.id.back_btn);

        backBtn.setOnClickListener(homeActivityListener);

        buttons = Custom.findViewsByTag(monGridLayout, "mon_sound");
        for (View button : buttons){
            button.setOnClickListener(playMonSoundListener);
        }
    }

    View.OnClickListener homeActivityListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent mainActivityIntent = new Intent(getApplicationContext(), LearnActivity.class);
            startActivity(mainActivityIntent);
            customType(Monophthongs.this, "right-to-left");
        }
    };

    View.OnClickListener playMonSoundListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Custom.playMonoSound(getApplicationContext(), v);
        }
    };
}
