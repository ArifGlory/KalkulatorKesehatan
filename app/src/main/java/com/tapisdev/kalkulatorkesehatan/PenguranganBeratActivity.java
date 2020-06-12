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

public class PenguranganBeratActivity extends AppCompatActivity {

    EditText etTinggi,etBerat,etUmur;
    Button btnHitung;
    TextView tvSubtitle,tvHasil;
    RadioButton rbPria,rbWanita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengurangan_berat);

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
                    Toast.makeText(PenguranganBeratActivity.this,"Tinggi harus diisi",Toast.LENGTH_SHORT).show();
                } else if (getBerat.equals("") || getBerat.length() == 0){
                    Toast.makeText(PenguranganBeratActivity.this,"Berat harus diisi",Toast.LENGTH_SHORT).show();
                } else if (getUmur.equals("") || getUmur.length() == 0){
                    Toast.makeText(PenguranganBeratActivity.this,"Umur harus diisi",Toast.LENGTH_SHORT).show();
                }
                else{
                    if (rbPria.isChecked()){
                        //bmr (Basal Metabolic Rate)
                        kaloriNeed = 66.5 + (13.8 * Double.parseDouble(getBerat)) + (5 * Double.parseDouble(getTinggi));
                        kaloriNeed = kaloriNeed - (6.8 * Double.parseDouble(getUmur));
                    }else if (rbWanita.isChecked()){
                        kaloriNeed = 665.1 + (9.6 * Double.parseDouble(getBerat)) + (1.9 * Double.parseDouble(getTinggi));
                        kaloriNeed = kaloriNeed - (4.7 * Double.parseDouble(getUmur));
                    }
                    //ini TDEE (Total Daily energy Expenditure)
                    double tdee = kaloriNeed * 1.375;
                    double cuttingKalori = 0.25 * tdee;
                    double defisitKalori = tdee - cuttingKalori;

                    tvHasil.setText(""+ new DecimalFormat("##.##").format(defisitKalori) + " Kcal");
                    tvSubtitle.setText("Defisit Kalori anda adalah");
                    tvSubtitle.setVisibility(View.VISIBLE);
                    tvHasil.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
