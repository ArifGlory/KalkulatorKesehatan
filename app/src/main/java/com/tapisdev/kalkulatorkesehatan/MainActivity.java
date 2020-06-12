package com.tapisdev.kalkulatorkesehatan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rlHeartbeat,rlBodyMass,rlKalori,rlWaterNeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rlHeartbeat = findViewById(R.id.rlHeartbeat);
        rlBodyMass = findViewById(R.id.rlBodyMass);
        rlKalori = findViewById(R.id.rlKalori);
        rlWaterNeed = findViewById(R.id.rlWaterNeed);

        rlHeartbeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DenyutJantungActivity.class);
                startActivity(intent);
            }
        });
        rlBodyMass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BMIActivity.class);
                startActivity(intent);
            }
        });
        rlKalori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,KaloriActivity.class);
                startActivity(intent);
            }
        });
        rlWaterNeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,KebutuhanAirActivity.class);
                startActivity(intent);
            }
        });
    }
}
