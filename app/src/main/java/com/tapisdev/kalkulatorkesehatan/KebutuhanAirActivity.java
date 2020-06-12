package com.tapisdev.kalkulatorkesehatan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class KebutuhanAirActivity extends AppCompatActivity {

    EditText etBerat;
    Button btnHitung;
    TextView tvSubtitle,tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kebutuhan_air);

        etBerat = findViewById(R.id.etBerat);
        btnHitung = findViewById(R.id.btnHitung);
        tvSubtitle = findViewById(R.id.tvSubtitle);
        tvHasil = findViewById(R.id.tvHasil);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getBerat = etBerat.getText().toString();
                if (getBerat.equals("") || getBerat.length() == 0){
                    Toast.makeText(KebutuhanAirActivity.this,"Berat harus diisi",Toast.LENGTH_SHORT).show();
                }else{

                    double intake = ( Double.parseDouble(getBerat) * 5 ) / 8;
                    tvHasil.setText(""+intake);

                    tvSubtitle.setVisibility(View.VISIBLE);
                    tvHasil.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
