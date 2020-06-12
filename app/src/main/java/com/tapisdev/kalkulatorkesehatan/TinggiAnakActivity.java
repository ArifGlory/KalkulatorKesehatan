package com.tapisdev.kalkulatorkesehatan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class TinggiAnakActivity extends AppCompatActivity {

    EditText etTinggiAyah,etTinggiIbu;
    Button btnHitung;
    TextView tvSubtitle,tvHasil;
    RadioButton rbPria,rbWanita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinggi_anak);

        etTinggiAyah = findViewById(R.id.etTinggiAyah);
        etTinggiIbu = findViewById(R.id.etTinggiIbu);
        btnHitung = findViewById(R.id.btnHitung);
        tvSubtitle = findViewById(R.id.tvSubtitle);
        tvHasil = findViewById(R.id.tvHasil);
        rbPria = findViewById(R.id.rbPria);
        rbWanita = findViewById(R.id.rbWanita);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getTinggiAyah    = etTinggiAyah.getText().toString();
                String getTinggiIbu     = etTinggiIbu.getText().toString();
                double childHeight = 0.0;

                if (getTinggiAyah.equals("") || getTinggiAyah.length() == 0){
                    Toast.makeText(TinggiAnakActivity.this,"Tinggi Ayah harus diisi",Toast.LENGTH_SHORT).show();
                } else if (getTinggiIbu.equals("") || getTinggiIbu.length() == 0){
                    Toast.makeText(TinggiAnakActivity.this,"Tinggi Ibu harus diisi",Toast.LENGTH_SHORT).show();
                }
                else{
                    if (rbPria.isChecked()){
                        childHeight = ( Integer.parseInt(getTinggiAyah) + Integer.parseInt(getTinggiIbu) ) / 2 + 2.5;
                    }else if (rbWanita.isChecked()){
                        childHeight = ( Integer.parseInt(getTinggiAyah) + Integer.parseInt(getTinggiIbu) ) / 2 - 2.5;
                    }


                    tvHasil.setText(""+ new DecimalFormat("##.##").format(childHeight) + " cm");
                    tvSubtitle.setVisibility(View.VISIBLE);
                    tvHasil.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
