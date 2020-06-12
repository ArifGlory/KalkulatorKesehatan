package com.tapisdev.kalkulatorkesehatan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class BMIActivity extends AppCompatActivity {

    EditText etTinggi,etBerat;
    Button btnHitung;
    TextView tvSubtitle,tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i);

        etTinggi = findViewById(R.id.etTinggi);
        etBerat = findViewById(R.id.etBerat);
        btnHitung = findViewById(R.id.btnHitung);
        tvSubtitle = findViewById(R.id.tvSubtitle);
        tvHasil = findViewById(R.id.tvHasil);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getTinggi    = etTinggi.getText().toString();
                String getBerat     = etBerat.getText().toString();

                if (getTinggi.equals("") || getTinggi.length() == 0){
                    Toast.makeText(BMIActivity.this,"Tinggi harus diisi",Toast.LENGTH_SHORT).show();
                } else if (getBerat.equals("") || getBerat.length() == 0){
                    Toast.makeText(BMIActivity.this,"Berat harus diisi",Toast.LENGTH_SHORT).show();
                }
                else{
                    double tinggiInMeter   = Double.parseDouble(getTinggi) / 100;
                    tinggiInMeter       = tinggiInMeter * tinggiInMeter; //kuadratkan

                    double imt = Double.parseDouble(getBerat) / tinggiInMeter;
                    tvHasil.setText(""+ new DecimalFormat("##.##").format(imt) );

                    tvSubtitle.setVisibility(View.VISIBLE);
                    tvHasil.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
