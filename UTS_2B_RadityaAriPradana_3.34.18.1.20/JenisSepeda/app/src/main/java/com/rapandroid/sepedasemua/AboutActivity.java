package com.rapandroid.sepedasemua;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportActionBar().setTitle("About");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable panah = ContextCompat.getDrawable(this, R.drawable.ic_arrow_back_black_24dp);
        panah.setColorFilter(ContextCompat.getColor(this, R.color.black), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(panah);
    }

    public boolean onOptionsItemSelected(MenuItem mt){
        //if(mt.getItemId()==R.id.home){
          //  Intent mainActivity = new Intent(this, MainActivity.class);
            //startActivity(mainActivity);
            //return true;
        //}
        finish();
        return super.onOptionsItemSelected(mt);
    }
}
