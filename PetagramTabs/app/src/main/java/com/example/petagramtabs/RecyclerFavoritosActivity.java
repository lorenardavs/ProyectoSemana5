package com.example.petagramtabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.petagramtabs.Adapters.AdapterMascotas;
import com.example.petagramtabs.Presentadores.IRecyclerFavoritosActivityPresenter;
import com.example.petagramtabs.Presentadores.RecyclerFavoritosActivityPresenter;
import com.example.petagramtabs.fragmentos.IRecyclerFavoritosActivity;

import java.util.ArrayList;

public class RecyclerFavoritosActivity extends AppCompatActivity implements IRecyclerFavoritosActivity {

    ArrayList<Mascota> listMascotas;
    RecyclerView recyclerMascotasfav;
    private IRecyclerFavoritosActivityPresenter presenter;

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

        listMascotas = new ArrayList<>();
        recyclerMascotasfav = (RecyclerView) findViewById(R.id.recyclerid2);
        presenter=new RecyclerFavoritosActivityPresenter(this,this);
    }
    /*
    private void llenarmascotasfav(){
        listMascotas.add(new Mascota("Catty",5,R.drawable.img1));
        listMascotas.add(new Mascota("Ron",4,R.drawable.img2));
        listMascotas.add(new Mascota("Ronny",3,R.drawable.img2));
        listMascotas.add(new Mascota("Bonny",2,R.drawable.img1));
        listMascotas.add(new Mascota("Luna",1,R.drawable.img2));
    }
*/

    @Override
    public void generarLinearLayout() {
        LinearLayoutManager mllm=new LinearLayoutManager(this);
        mllm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerMascotasfav.setLayoutManager(mllm);
            }

    @Override
    public AdapterMascotas crearAdaptador(ArrayList<Mascota> listMascotas) {
        AdapterMascotas adapterMascotas = new AdapterMascotas(listMascotas, this);
        return adapterMascotas;
    }

    @Override
    public void inicializarAdaptadorRV(AdapterMascotas adapterMascotas) {
        recyclerMascotasfav.setAdapter(adapterMascotas);
    }
}