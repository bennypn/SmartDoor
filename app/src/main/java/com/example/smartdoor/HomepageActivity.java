package com.example.smartdoor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.QuickContactBadge;

public class HomepageActivity extends AppCompatActivity {
    private ImageButton btnHist,btnSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        btnHist = findViewById(R.id.history_btn);
        btnSet = findViewById(R.id.setting_btn);

        btnHist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomepageActivity.this, HistoryActivity.class);
                startActivity(i);
            }
        });

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomepageActivity.this,EnrollActivity.class);
                startActivity(i);
            }
        });
    }
}