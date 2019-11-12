package com.rapandroid.sepedasemua;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView rvSepeda;
    private ArrayList<Sepeda> list = new ArrayList<>();
    private Button btnCard;
    private Button btnList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Sepeda Semua");
        }
        btnCard = findViewById(R.id.btn_cardview);
        btnCard.setOnClickListener(this);
        btnList = findViewById(R.id.btn_listview);
        btnList.setOnClickListener(this);

        rvSepeda = findViewById(R.id.rv_sepeda);
        rvSepeda.setHasFixedSize(true);

        list.addAll(SepedaData.getListData());
        showRecyclerCard();
        setBtnCard();
    }

    private void setBtnList(){
        btnList.setBackgroundResource(R.drawable.btn_merah);
        btnList.setTextColor(getResources().getColor(R.color.colorPrimary));
        btnCard.setBackgroundResource(R.drawable.btn_white);
        btnCard.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
    }

    private void setBtnCard(){
        btnCard.setBackgroundResource(R.drawable.btn_merah);
        btnCard.setTextColor(getResources().getColor(R.color.colorPrimary));
        btnList.setBackgroundResource(R.drawable.btn_white);
        btnList.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
    }

    public void showRecyclerCard(){
        rvSepeda.setLayoutManager(new LinearLayoutManager(this));
        CardSepedaAdapter cardSepedaAdapter = new CardSepedaAdapter(this, list);

        rvSepeda.setAdapter(cardSepedaAdapter);
    }

    public void showRecyclerList(){
        rvSepeda.setLayoutManager(new LinearLayoutManager(this));
        ListSepedaAdapter listSepedaAdapter = new ListSepedaAdapter(this, list);

        rvSepeda.setAdapter(listSepedaAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu mn){
        getMenuInflater().inflate(R.menu.option_menu, mn);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem it){
        if(it.getItemId()==R.id.account){
            Intent aboutActivity = new Intent(this, AboutActivity.class);
            startActivity(aboutActivity);
            return true;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_listview:
                showRecyclerList();
                setBtnList();
                break;
            case R.id.btn_cardview:
                showRecyclerCard();
                setBtnCard();
                break;
        }
    }
}
