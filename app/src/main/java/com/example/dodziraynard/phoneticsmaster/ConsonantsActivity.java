package com.example.dodziraynard.phoneticsmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dodziraynard.phoneticsmaster.Custom.Custom;

import java.util.ArrayList;

import static maes.tech.intentanim.CustomIntent.customType;

public class ConsonantsActivity extends AppCompatActivity {
    ImageView backBtn;
    GridLayout conGridLayout;
    ArrayList<View> buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consonants);
        conGridLayout = findViewById(R.id.conGridLayout);
        backBtn = findViewById(R.id.back_btn);

        backBtn.setOnClickListener(homeActivityListener);

        buttons = Custom.findViewsByTag(conGridLayout, "con_sound");
        for (View button : buttons){
            button.setOnClickListener(playConSoundListener);
        }
    }

    View.OnClickListener homeActivityListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent mainActivityIntent = new Intent(getApplicationContext(), LearnActivity.class);
            startActivity(mainActivityIntent);
            customType(ConsonantsActivity.this, "right-to-left");
        }
    };

    View.OnClickListener playConSoundListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Custom.playConSound(getApplicationContext(), v);
        }
    };
}
