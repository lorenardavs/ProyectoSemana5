package com.example.petagramtabs.Presentadores;

import android.content.Context;

import com.example.petagramtabs.Constructores.ConstructorMascota;
import com.example.petagramtabs.Mascota;
import com.example.petagramtabs.fragmentos.IRecyclerFavoritosActivity;

import java.util.ArrayList;

public class RecyclerFavoritosActivityPresenter implements IRecyclerFavoritosActivityPresenter {

    private IRecyclerFavoritosActivity iRecyclerFavoritosActivity;
    private Context context;
    private ConstructorMascota constructorMascota;
    private ArrayList<Mascota> listMascotas;

    public RecyclerFavoritosActivityPresenter(IRecyclerFavoritosActivity iRecyclerFavoritosActivity, Context context) {
        this.iRecyclerFavoritosActivity = iRecyclerFavoritosActivity;
        this.context = context;
        obtenerMascotas();
    }

    @Override
    public ArrayList<Mascota> obtenerMascotas() {
        constructorMascota = new ConstructorMascota(context);
        listMascotas = constructorMascota.obtenerDatos();
        mostrarMascotasRecyclerView();
        return null;
    }

    @Override
    public void mostrarMascotasRecyclerView() {
        iRecyclerFavoritosActivity.inicializarAdaptadorRV(iRecyclerFavoritosActivity.crearAdaptador(listMascotas));
        iRecyclerFavoritosActivity.generarLinearLayout();
    }
}
