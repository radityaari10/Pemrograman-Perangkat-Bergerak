package com.rapandroid.signupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button BtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        BtnRegister = findViewById(R.id.BtnGabung);
        BtnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.BtnGabung:
                Intent register = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(register);
                break;
        }

    }
}
