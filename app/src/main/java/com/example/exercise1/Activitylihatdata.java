package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activitylihatdata extends AppCompatActivity {
    TextView tvnama, tvnomor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        tvnama = findViewById(R.id.tvNamaKontak);
        tvnomor = findViewById(R.id.tvNomorTelepon);

        Bundle bundle = getIntent().getExtras();

        String nama = bundle.getString("a");

        switch (nama)
        {
            case "Inayah":
                tvnama.setText("Inayah");
                tvnomor.setText("08122222222");
                break;
            case "Ilham":
                tvnama.setText("Ilham");
                tvnomor.setText("08122442222");
                break;
            case "Eris":
                tvnama.setText("Eris");
                tvnomor.setText("08111222222");
                break;
            case "Fikri":
                tvnama.setText("Fikri");
                tvnomor.setText("08122222444");
                break;
            case "Maul":
                tvnama.setText("Maul");
                tvnomor.setText("08122777222");
                break;
            case "Intan":
                tvnama.setText("Intan");
                tvnomor.setText("08122226666");
                break;
            case "Vina":
                tvnama.setText("Vina");
                tvnomor.setText("08122556666");
                break;
            case "Gita":
                tvnama.setText("Gita");
                tvnomor.setText("08199226666");
                break;
            case "Lutfi":
                tvnama.setText("Lutfi");
                tvnomor.setText("08128886666");
                break;
            case "Vian":
                tvnama.setText("Vian");
                tvnomor.setText("08144426666");
                break;





        }

    }
}