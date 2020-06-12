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
    TextView tvSubtitle,tvHasil,tvSubtitle2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i);

        etTinggi = findViewById(R.id.etTinggi);
        etBerat = findViewById(R.id.etBerat);
        btnHitung = findViewById(R.id.btnHitung);
        tvSubtitle = findViewById(R.id.tvSubtitle);
        tvHasil = findViewById(R.id.tvHasil);
        tvSubtitle2 = findViewById(R.id.tvSubtitle2);

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
                    String kategori = cekKategoriIMT(imt);

                    tvHasil.setText(""+ new DecimalFormat("##.##").format(imt) );
                    tvSubtitle2.setText("Kategori : "+kategori);

                    tvSubtitle.setVisibility(View.VISIBLE);
                    tvHasil.setVisibility(View.VISIBLE);
                    tvSubtitle2.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public String cekKategoriIMT(double imt){
        String kategori = "";
        if (imt < 16){
            kategori =  "sangat di bawah berat badan ideal";
        } else if (imt > 16 && imt < 18.25){
            kategori =  "di bawah berat badan ideal";
        }else if (imt > 18.6 && imt < 25){
            kategori =  "berat badan ideal";
        }else if (imt > 25.1 && imt < 30){
            kategori =  "berat kegemukan";
        }else if (imt > 30.1 && imt < 35){
            kategori =  "Obesitas";
        }else if (imt > 35.1 && imt < 40){
            kategori =  "Obesitas kelas dua";
        }else if (imt > 40){
            kategori =  "Morbid Obesitas";
        }


        return  kategori;
    }
}
