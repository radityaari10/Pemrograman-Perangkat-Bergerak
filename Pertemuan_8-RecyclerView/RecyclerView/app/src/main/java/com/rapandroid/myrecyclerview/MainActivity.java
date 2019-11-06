package com.rapandroid.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHmj;
    private ArrayList<Hmj> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHmj = findViewById(R.id.rv_hmj);
        rvHmj.setHasFixedSize(true);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("HM & UKM Polines");
        }

        list.addAll(getListHmj());
        showRecycleList();
    }

    public ArrayList<Hmj> getListHmj(){
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_description);
        String[] dataPhoto = getResources().getStringArray(R.array.photo);

        ArrayList<Hmj> listHmj = new ArrayList<>();
        for(int i=0; i < dataName.length ; i++){
            Hmj hmj = new Hmj();
            hmj.setName(dataName[i]);
            hmj.setDescription(dataDescription[i]);
            hmj.setPhoto(dataPhoto[i]);

            listHmj.add(hmj);
        }
        return listHmj;
    }

    private void showRecycleList(){
        rvHmj.setLayoutManager(new LinearLayoutManager(this));
        ListHmjAdapter listHmjAdapter = new ListHmjAdapter(list);
        rvHmj.setAdapter(listHmjAdapter);

        listHmjAdapter.setOnItemClickCallback(new ListHmjAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hmj data){
                showSelectedHmj(data);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu mn){
        getMenuInflater().inflate(R.menu.about_menu, mn);
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

    private void showSelectedHmj(Hmj hmj) {
        Toast.makeText(this, "Kamu memilih " + hmj.getName() + ", detail segera menyusul", Toast.LENGTH_SHORT).show();
    }
}
