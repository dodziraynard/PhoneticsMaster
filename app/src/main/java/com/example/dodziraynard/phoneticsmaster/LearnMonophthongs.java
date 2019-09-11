package com.example.dodziraynard.phoneticsmaster;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dodziraynard.phoneticsmaster.Custom.Custom;
//import com.google.android.gms.ads.AdListener;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.InterstitialAd;
//import com.google.android.gms.ads.MobileAds;
//import com.google.android.gms.ads.initialization.InitializationStatus;
//import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static maes.tech.intentanim.CustomIntent.customType;

public class LearnMonophthongs extends AppCompatActivity {
    ImageView backBtn;
    ArrayList<View> buttons;
    ArrayList<View> sampleTexts;
    ArrayList<View> recButtons;
    ArrayList<View> plyRecButtons;
    LinearLayout monoLinearLayout;
    Button sheep_rec;

//    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_monophthongs);
        backBtn = findViewById(R.id.back_btn);
        monoLinearLayout = findViewById(R.id.mono_linear_layout);

        backBtn.setOnClickListener(homeActivityListener);

        buttons = Custom.findViewsByTag(monoLinearLayout, "mono_sound");
        sampleTexts = Custom.findViewsByTag(monoLinearLayout, "mono_sample_text");
        recButtons = Custom.findViewsByTag(monoLinearLayout, "rec");
        plyRecButtons = Custom.findViewsByTag(monoLinearLayout, "play");

        for (View button : buttons){
            button.setOnClickListener(playMonoSoundListener);
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

//        MobileAds.initialize(this, new OnInitializationCompleteListener() {
//            @Override
//            public void onInitializationComplete(InitializationStatus initializationStatus) {}
//        });

//        mInterstitialAd = new InterstitialAd(this);
//        mInterstitialAd.setAdUnitId(getString(R.string.test_ad_unit_id));
//        mInterstitialAd.loadAd(new AdRequest.Builder().build());
//
//        if (mInterstitialAd.isLoaded()) {
//            mInterstitialAd.show();
//        } else {
//            Log.d("TAG", "The interstitial wasn't loaded yet.");
//        }
//
//        mInterstitialAd.setAdListener(new AdListener() {
//            @Override
//            public void onAdClosed() {
//                // Load the next interstitial.
//                mInterstitialAd.loadAd(new AdRequest.Builder().build());
//            }
//        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    View.OnClickListener homeActivityListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent mainActivityIntent = new Intent(getApplicationContext(), LearnActivity.class);
            startActivity(mainActivityIntent);
            customType(LearnMonophthongs.this, "right-to-left");
        }
    };

    View.OnLongClickListener recordListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            Toast.makeText(LearnMonophthongs.this, "Recordin Starts", Toast.LENGTH_SHORT).show();
            return true;
        }
    };

    View.OnClickListener playMonoSoundListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Custom.playMonoSound(getApplicationContext(), v);
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
                    Custom.record(LearnMonophthongs.this, getApplicationContext(), button.getText().toString());
                    Custom.makeVibration(LearnMonophthongs.this, getApplicationContext());
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
        public void onClick(View v) {
            Button button = (Button) v;
            Custom.playRecording(getApplicationContext(),  button.getText().toString());
        }
    };
}
