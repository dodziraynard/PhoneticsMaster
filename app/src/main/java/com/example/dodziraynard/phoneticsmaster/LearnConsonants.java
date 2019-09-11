package com.example.dodziraynard.phoneticsmaster;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.dodziraynard.phoneticsmaster.Custom.Custom;
import java.util.ArrayList;
import static maes.tech.intentanim.CustomIntent.customType;

public class LearnConsonants extends AppCompatActivity {
    ImageView backBtn;
    LinearLayout conLinearLayout;
    ArrayList<View> buttons;
    ArrayList<View> sampleTexts;
    ArrayList<View> recButtons;
    ArrayList<View> plyRecButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_consonants);
        backBtn = findViewById(R.id.back_btn);
        backBtn.setOnClickListener(homeActivityListener);
        conLinearLayout = findViewById(R.id.conLinearLayout);
        buttons = Custom.findViewsByTag(conLinearLayout, "con_sound");
        sampleTexts     = Custom.findViewsByTag(conLinearLayout, "con_text_sample");
        recButtons      = Custom.findViewsByTag(conLinearLayout, "rec");
        plyRecButtons   = Custom.findViewsByTag(conLinearLayout, "play_rec");

        for (View button : buttons){
            button.setOnClickListener(playConSoundListener);
        }
        for (View text : sampleTexts){
            text.setOnClickListener(playSampleText);
        }

        for (View recButton : recButtons){
            recButton.setOnTouchListener(touchRecListener);
        }

        for (View plyRecButton : plyRecButtons){
            plyRecButton.setOnClickListener(plyListener);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        backBtn.setOnClickListener(homeActivityListener);

    }

    View.OnClickListener homeActivityListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent mainActivityIntent = new Intent(getApplicationContext(), LearnActivity.class);
            startActivity(mainActivityIntent);
            customType(LearnConsonants.this, "right-to-left");
        }
    };

    View.OnClickListener playConSoundListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Custom.playConSound(getApplicationContext(), v);
        }
    };


    View.OnClickListener playSampleText = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView textView = (TextView) v;
            Custom.playSampleText(getApplicationContext(), textView.getText().toString());
        }
    };

    View.OnTouchListener touchRecListener = new View.OnTouchListener() {
        @SuppressLint("ClickableViewAccessibility")
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    Button button = (Button) v;
                    Custom.record(LearnConsonants.this, getApplicationContext(), button.getText().toString());
                    Custom.makeVibration(LearnConsonants.this, getApplicationContext());
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    Custom.stopRecording(getApplicationContext(), Custom.mediaRecorder);
                    break;
            }
            return false;
        }
    };

    View.OnClickListener plyListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button button = (Button) view;
            Custom.playRecording(getApplicationContext(),  button.getText().toString());
        }
    };
}
