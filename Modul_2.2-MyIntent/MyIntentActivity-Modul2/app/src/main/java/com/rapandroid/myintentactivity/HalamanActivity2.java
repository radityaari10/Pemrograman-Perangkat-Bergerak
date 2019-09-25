package com.rapandroid.myintentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HalamanActivity2 extends AppCompatActivity {
    TextView txtNama;
    String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman2);
        txtNama = findViewById(R.id.txt_hasil);
        Bundle bundle = getIntent().getExtras();
        nama = bundle.getString("nama");
        txtNama.setText(nama);
    }
}
