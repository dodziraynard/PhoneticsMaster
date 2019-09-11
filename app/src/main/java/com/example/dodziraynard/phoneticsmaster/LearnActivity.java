package com.example.dodziraynard.phoneticsmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import static maes.tech.intentanim.CustomIntent.customType;

public class LearnActivity extends AppCompatActivity {
    CardView learn_introduction, learn_monophthongs, learn_diphthongs, learn_consonants;
     ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        backBtn = findViewById(R.id.back_btn);
        learn_introduction = findViewById(R.id.learn_introduction);
        learn_monophthongs = findViewById(R.id.learn_monophthongs);
        learn_diphthongs = findViewById(R.id.learn_diphthongs);
        learn_consonants = findViewById(R.id.learn_consonants);

        backBtn.setOnClickListener(homeActivityListener);
        learn_introduction.setOnClickListener(introActivityListener);
        learn_monophthongs.setOnClickListener(learnMonoActivityListener);
        learn_diphthongs.setOnClickListener(learnDiphActivityListener);
        learn_consonants.setOnClickListener(learnConsActivityListener);
    }

    View.OnClickListener homeActivityListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent mainActivityIntent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(mainActivityIntent);
            customType(LearnActivity.this, "right-to-left");
        }
    };

    View.OnClickListener introActivityListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent introActivityIntent = new Intent(getApplicationContext(), LearnIntroduction.class);
            startActivity(introActivityIntent);
            customType(LearnActivity.this, "left-to-right");
        }
    };

    View.OnClickListener learnMonoActivityListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent learnMonoActivityIntent = new Intent(getApplicationContext(), LearnMonophthongs.class);
            startActivity(learnMonoActivityIntent);
            customType(LearnActivity.this, "left-to-right");
        }
    };

    View.OnClickListener learnDiphActivityListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent learnDiphActivityIntent = new Intent(getApplicationContext(), LearnDiphthongs.class);
            startActivity(learnDiphActivityIntent);
            customType(LearnActivity.this, "left-to-right");
        }
    };

    View.OnClickListener learnConsActivityListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent learnConsActivityIntent = new Intent(getApplicationContext(), LearnConsonants.class);
            startActivity(learnConsActivityIntent);
            customType(LearnActivity.this, "left-to-right");
        }
    };
}
