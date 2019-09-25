package com.rapandroid.myintentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnMoveActivity;
    Button btnMoveActivityWithData;
    Button btnDial;
    Button btnWeb;
    Button btnBelajar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMoveActivity =findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);
        btnMoveActivityWithData=findViewById(R.id.btn_move_data);
        btnMoveActivityWithData.setOnClickListener(this);
        btnDial=findViewById(R.id.btn_dial);
        btnDial.setOnClickListener(this);
        btnWeb = findViewById(R.id.btn_web);
        btnWeb.setOnClickListener(this);
        btnBelajar = findViewById(R.id.btn_belajar);
        btnBelajar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this, NewActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.btn_move_data:
                Intent moveData = new Intent(MainActivity.this, MoveActivityWithData.class);
                moveData.putExtra(MoveActivityWithData.EXTRA_NAME,"Raditya Ari Pradana");
                moveData.putExtra(MoveActivityWithData.EXTRA_AGE, 20);
                startActivity(moveData);
                break;
            case R.id.btn_dial:
                String phoneNumber = "085716999510";
                Intent dialPhone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+phoneNumber));
                startActivity(dialPhone);
                break;
            case R.id.btn_web:
                String linkWeb = "http://www.polines.ac.id";
                Intent webSite = new Intent(Intent.ACTION_VIEW, Uri.parse(linkWeb));
                startActivity(webSite);
                break;
            case R.id.btn_belajar:
                Intent moveHalaman = new Intent(MainActivity.this, HalamanActivity1.class);
                startActivity(moveHalaman);
                break;
        }
    }
}
