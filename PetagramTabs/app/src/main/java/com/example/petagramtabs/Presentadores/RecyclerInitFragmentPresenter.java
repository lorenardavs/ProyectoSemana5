package com.example.petagramtabs.Presentadores;

import android.content.Context;

import com.example.petagramtabs.Constructores.ConstructorMascota;
import com.example.petagramtabs.Mascota;
import com.example.petagramtabs.fragmentos.IRecycleriniFragment;

import java.util.ArrayList;

public class RecyclerInitFragmentPresenter implements IRecyclerInitFragmentPresenter {

    private IRecycleriniFragment iRecycleriniFragment;
    private Context context;
    private ConstructorMascota constructorMascota;
    private ArrayList<Mascota> listMascotas;

    public RecyclerInitFragmentPresenter(IRecycleriniFragment iRecycleriniFragment1, Context context){
        this.iRecycleriniFragment = iRecycleriniFragment1;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascota = new ConstructorMascota(context);
        listMascotas = constructorMascota.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecycleriniFragment.inicializarAdaptadorRV(iRecycleriniFragment.crearAdaptador(listMascotas));
        iRecycleriniFragment.generarLinearLayout();
    }
}
