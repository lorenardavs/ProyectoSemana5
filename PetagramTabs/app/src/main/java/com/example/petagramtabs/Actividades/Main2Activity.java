package com.example.petagramtabs.Actividades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.petagramtabs.Adapters.AdapterMascotaFavorita;
import com.example.petagramtabs.MascotaFavorita;
import com.example.petagramtabs.R;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ArrayList<MascotaFavorita> listamascotasfav;
    RecyclerView recyclerMascotasfav;

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotafavorita);

        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        listamascotasfav = new ArrayList<>();
        recyclerMascotasfav = (RecyclerView) findViewById(R.id.recyclerid2);
        recyclerMascotasfav.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        llenarmascotasfav();

        AdapterMascotaFavorita adapterMascotaFavorita = new AdapterMascotaFavorita(listamascotasfav);
        recyclerMascotasfav.setAdapter(adapterMascotaFavorita);

    }
    private void llenarmascotasfav(){
        listamascotasfav.add(new MascotaFavorita("Catty","5",R.drawable.img1));
        listamascotasfav.add(new MascotaFavorita("Ron","4",R.drawable.img2));
        listamascotasfav.add(new MascotaFavorita("Ronny","3",R.drawable.img2));
        listamascotasfav.add(new MascotaFavorita("Bonny","2",R.drawable.img1));
        listamascotasfav.add(new MascotaFavorita("Luna","1",R.drawable.img2));
    }
}