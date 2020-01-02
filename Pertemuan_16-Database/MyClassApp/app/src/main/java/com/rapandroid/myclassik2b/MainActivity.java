package com.rapandroid.myclassik2b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLihat = findViewById(R.id.lihatbtn);
        Button btnInput = findViewById(R.id.inputbtn);
        Button btnInfo = findViewById(R.id.infobtn);

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inputDataIntent = new Intent(MainActivity.this, InputDataActivity.class);
                startActivity(inputDataIntent);
            }
        });
        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lihatDataIntent = new Intent(MainActivity.this, LihatDataActivity.class);
                startActivity(lihatDataIntent);
            }
        });
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent infoDataIntent = new Intent(MainActivity.this, InfromasiActivity.class);
                startActivity(infoDataIntent);
            }
        });
    }
}
