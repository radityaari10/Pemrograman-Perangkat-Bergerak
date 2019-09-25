package com.rapandroid.myintentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HalamanActivity1 extends AppCompatActivity {
    Button btn_move_hlm2;
    EditText edTextNama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman1);
        btn_move_hlm2 = findViewById(R.id.btn_move_activity2);
        edTextNama = findViewById(R.id.edText_nama);


        btn_move_hlm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = edTextNama.getText().toString();
                Intent moveHalaman2 = new Intent(HalamanActivity1.this, HalamanActivity2.class);
                startActivity(moveHalaman2.putExtra("nama", nama));
                edTextNama.setText("");
            }
        });
    }
}
