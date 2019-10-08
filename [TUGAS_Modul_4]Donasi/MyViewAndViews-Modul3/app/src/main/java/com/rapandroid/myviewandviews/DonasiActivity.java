package com.rapandroid.myviewandviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DonasiActivity extends AppCompatActivity {
    Button btnpembayaran;
    EditText edtnama, edtemail, edtjumlah, edtcat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donasi);

        btnpembayaran = findViewById(R.id.btnPembayaran);
        edtnama = findViewById(R.id.edtNama);
        edtemail = findViewById(R.id.edtEmail);
        edtjumlah =findViewById(R.id.edtJmlDonasi);
        edtcat = findViewById(R.id.edtCatatan);

        btnpembayaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtnama.getText().toString().length()==0){
                    edtnama.setError("Isi nama Anda atau dengan tanda '-'");
                }
                if(edtemail.getText().toString().length()==0){
                    edtemail.setError("Email diperlukan");
                }
                if(edtcat.getText().length()==0){
                    edtjumlah.setError("Jumlah donasi masih kosong");
                }
                else {
                    Toast.makeText(getApplicationContext(), "Terima kasih atas donasi Anda"
                            , Toast.LENGTH_LONG).show();
                    edtnama.setText("");
                    edtemail.setText("");
                    edtjumlah.setText("");
                    edtcat.setText("");
                }
            }
        });
    }
}
