package com.example.dodziraynard.phoneticsmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import static maes.tech.intentanim.CustomIntent.customType;

public class LearnIntroduction extends AppCompatActivity {
     ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_introduction);
        backBtn = findViewById(R.id.back_btn);

        backBtn.setOnClickListener(homeActivityListener);
    }

    View.OnClickListener homeActivityListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent mainActivityIntent = new Intent(getApplicationContext(), LearnActivity.class);
            startActivity(mainActivityIntent);
            customType(LearnIntroduction.this, "right-to-left");
        }
    };
}
