package com.rapandroid.myviewandviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btndonasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Donasi Pesawat R80");
        }

        btndonasi = findViewById(R.id.btnDonasi);
        btndonasi.setOnClickListener(this);
    }

    @Override
    public void onClick(View vi) {
        switch (vi.getId()){
            case R.id.btnDonasi:
                Intent movAtyDonasi =new Intent(MainActivity.this, DonasiActivity.class);
                startActivity(movAtyDonasi);
                break;
        }
    }
}
