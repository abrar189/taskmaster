package com.example.taskmaster;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;

import com.amplifyframework.analytics.AnalyticsEvent;
import com.amplifyframework.core.Amplify;

public class SettingsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recordEvents();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        findViewById(R.id.saveUser).setOnClickListener(view -> {
            TextView text = findViewById(R.id.userName);
            String name =text.getText().toString();


            RadioButton b1=findViewById(R.id.radioButton);
            RadioButton b2=findViewById(R.id.radioButton2);
            RadioButton b3=findViewById(R.id.radioButton3);

            String id = null;
            if(b1.isChecked()){
                id="1";
            }
            else if(b2.isChecked()){
                id="2";
            }
            else if(b3.isChecked()){
                id="3";
            }

            editor.putString("Team",id);
            editor.putString("EnteredText",name);
            editor.apply();


        });

    }

    public void recordEvents() {
        AnalyticsEvent event = AnalyticsEvent.builder()
                .name("Launch Setting Activity")
                .addProperty("Channel", "SMS")
                .addProperty("Successful", true)
                .addProperty("ProcessDuration", 792)
                .addProperty("UserAge", 120.3)
                .build();

        Amplify.Analytics.recordEvent(event);
    }
}