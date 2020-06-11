package com.tapisdev.kalkulatorkesehatan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DenyutJantungActivity extends AppCompatActivity {

    EditText etUmur;
    Button btnHitung;
    TextView tvSubtitle,tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denyut_jantung);

        etUmur = findViewById(R.id.etUmur);
        btnHitung = findViewById(R.id.btnHitung);
        tvSubtitle = findViewById(R.id.tvSubtitle);
        tvHasil = findViewById(R.id.tvHasil);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getUmur = etUmur.getText().toString();
                if (getUmur.equals("") || getUmur.length() == 0){
                    Toast.makeText(DenyutJantungActivity.this,"Umur harus diisi",Toast.LENGTH_SHORT).show();
                }else{
                    int maxHeatRate = 220 - Integer.parseInt(getUmur);
                    tvHasil.setText(""+maxHeatRate);

                    tvSubtitle.setVisibility(View.VISIBLE);
                    tvHasil.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
