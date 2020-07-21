package com.example.petagramtabs.Presentadores;

import android.content.Context;

import com.example.petagramtabs.Constructores.ConstructorMascota;
import com.example.petagramtabs.Constructores.ConstructorPerfil;
import com.example.petagramtabs.Mascota;
import com.example.petagramtabs.MascotasPerfil;
import com.example.petagramtabs.fragmentos.IRecyclerPerfilFragment;
import com.example.petagramtabs.fragmentos.IRecycleriniFragment;

import java.util.ArrayList;

public class RecyclerPerfilFragmentPresenter implements IRecyclerPerfilFragmentPresenter {
    private IRecyclerPerfilFragment iRecyclerPerfilFragment;
    private Context context;
    private ConstructorPerfil constructorPerfil;
    private ArrayList<MascotasPerfil> listMascota;

    public RecyclerPerfilFragmentPresenter(IRecyclerPerfilFragment iRecyclerPerfilFragment, Context context) {
        this.iRecyclerPerfilFragment = iRecyclerPerfilFragment;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorPerfil = new ConstructorPerfil(context);
        listMascota = constructorPerfil.obtenerDatos();
        mostrarMascotaRV();
    }

    @Override
    public void mostrarMascotaRV() {
        iRecyclerPerfilFragment.inicializarAdaptadorRV(iRecyclerPerfilFragment.crearAdaptador(listMascota));
        iRecyclerPerfilFragment.generarLinearLayout();
    }
}
