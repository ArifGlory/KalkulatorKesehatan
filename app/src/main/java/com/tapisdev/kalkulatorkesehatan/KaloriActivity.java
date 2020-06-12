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

public class KaloriActivity extends AppCompatActivity {

    EditText etTinggi,etBerat,etUmur;
    Button btnHitung;
    TextView tvSubtitle,tvHasil;
    RadioButton rbPria,rbWanita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalori);

        etTinggi = findViewById(R.id.etTinggi);
        etBerat = findViewById(R.id.etBerat);
        etUmur = findViewById(R.id.etUmur);
        btnHitung = findViewById(R.id.btnHitung);
        tvSubtitle = findViewById(R.id.tvSubtitle);
        tvHasil = findViewById(R.id.tvHasil);
        rbPria = findViewById(R.id.rbPria);
        rbWanita = findViewById(R.id.rbWanita);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getTinggi    = etTinggi.getText().toString();
                String getBerat     = etBerat.getText().toString();
                String getUmur     = etUmur.getText().toString();
                double kaloriNeed = 0.0;

                if (getTinggi.equals("") || getTinggi.length() == 0){
                    Toast.makeText(KaloriActivity.this,"Tinggi harus diisi",Toast.LENGTH_SHORT).show();
                } else if (getBerat.equals("") || getBerat.length() == 0){
                    Toast.makeText(KaloriActivity.this,"Berat harus diisi",Toast.LENGTH_SHORT).show();
                } else if (getUmur.equals("") || getUmur.length() == 0){
                    Toast.makeText(KaloriActivity.this,"Umur harus diisi",Toast.LENGTH_SHORT).show();
                }
                else{
                    if (rbPria.isChecked()){
                        kaloriNeed = 66.5 + (13.8 * Double.parseDouble(getBerat)) + (5 * Double.parseDouble(getTinggi));
                        kaloriNeed = kaloriNeed - (6.8 * Double.parseDouble(getUmur));
                    }else if (rbWanita.isChecked()){
                        kaloriNeed = 665.1 + (9.6 * Double.parseDouble(getBerat)) + (1.9 * Double.parseDouble(getTinggi));
                        kaloriNeed = kaloriNeed - (4.7 * Double.parseDouble(getUmur));
                    }
                    //bmr
                    //kaloriNeed = kaloriNeed * 1.375;

                    tvHasil.setText(""+ new DecimalFormat("##.##").format(kaloriNeed) + " Kcal");
                    tvSubtitle.setVisibility(View.VISIBLE);
                    tvHasil.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
