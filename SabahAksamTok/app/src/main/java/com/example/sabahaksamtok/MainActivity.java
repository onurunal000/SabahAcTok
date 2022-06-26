package com.example.sabahaksamtok;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etilacad,etsabahaksam,etactok,etsaat,ettarih;
    Button btnekle;
    DatabaseReference databaseReference;

    ListView listView_Canli;
    List<Hasta> hastaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference("Hasta");

        etilacad = findViewById(R.id.etIlacAdi);
        etsabahaksam = findViewById(R.id.etSabahAksam);
        etactok = findViewById(R.id.etAcTok);
        etsaat = findViewById(R.id.etSaat);
        ettarih = findViewById(R.id.etTarih);
        btnekle = findViewById(R.id.btnEkle);
        listView_Canli=findViewById(R.id.listView_Canli);

        hastaList = new ArrayList<>();

        btnekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                kullaniciEkle();
            }
        });
    }
    @Override
    protected void onStart() {

        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                hastaList.clear();

                for (DataSnapshot canliSnapshot : snapshot.getChildren()) {
                    Hasta insan = canliSnapshot.getValue(Hasta.class);

                    hastaList.add(insan);
                }
                CanliHastaList adapter = new CanliHastaList(MainActivity.this, hastaList);
                listView_Canli.setAdapter(adapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    private void kullaniciEkle(){
        String isim = etilacad.getText().toString();
        String sabahaksam = etsabahaksam.getText().toString();
        String actok = etactok.getText().toString();
        String saat = etsaat.getText().toString();
        String tarih =ettarih.getText().toString();

        String id = databaseReference.push().getKey();

        Hasta insan = new Hasta(id,isim,sabahaksam,actok,saat,tarih);
        databaseReference.child(id).setValue(insan);

    }
}