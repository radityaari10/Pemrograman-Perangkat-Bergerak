package com.rapandroid.sepedasemua;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class DetailItemSepedaActivity extends AppCompatActivity {
    private int sepeda_id;
    ImageView imgDetail;
    TextView tvName, tvDesc;
    private ArrayList<Sepeda> listSepeda = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item_sepeda);

        sepeda_id = getIntent().getIntExtra("sepeda_id", 0);
        tvName = findViewById(R.id.jenis_sepeda_detail);
        tvDesc = findViewById(R.id.desc_detail);
        imgDetail = findViewById(R.id.img_detail);

        listSepeda.addAll(SepedaData.getListData());
        final Drawable panah = ContextCompat.getDrawable(this, R.drawable.ic_arrow_back_black_24dp);
        panah.setColorFilter(ContextCompat.getColor(this, R.color.black), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(panah);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitleLayout();
        setLayout();
    }

    public  void setLayout(){
        tvName.setText(listSepeda.get(sepeda_id).getName());
        tvDesc.setText(listSepeda.get(sepeda_id).getDescription());
        Glide.with(this)
                .load(listSepeda.get(sepeda_id).getPhoto())
                .apply(new RequestOptions().fitCenter())
                .into(imgDetail);
    }

    public  void setTitleLayout(){
        getSupportActionBar().setTitle(listSepeda.get(sepeda_id).getName());
    }

    public boolean onOptionsItemSelected(MenuItem mt){
        //if(mt.getItemId()==R.id.home){
            //Intent mainActivity = new Intent(this, MainActivity.class);
            //startActivity(mainActivity);
          //  return true;
        //}
        finish();
        return super.onOptionsItemSelected(mt);
    }
}
