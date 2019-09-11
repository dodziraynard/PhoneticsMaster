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

public class DiphthongsActivity extends AppCompatActivity {
    ImageView backBtn;
    GridLayout diGridLayout;
    ArrayList<View> buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diphthongs);

        diGridLayout = findViewById(R.id.diGridLayout);
        backBtn = findViewById(R.id.back_btn);

        backBtn.setOnClickListener(onClickListener);

        buttons = Custom.findViewsByTag(diGridLayout, "di_sound");
        for (View button : buttons){
            button.setOnClickListener(playDiSoundListener);
        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent mainActivityIntent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(mainActivityIntent);
            customType(DiphthongsActivity.this, "right-to-left");
        }
    };

    View.OnClickListener playDiSoundListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Custom.playDiSound(getApplicationContext(), v);
        }
    };
}
