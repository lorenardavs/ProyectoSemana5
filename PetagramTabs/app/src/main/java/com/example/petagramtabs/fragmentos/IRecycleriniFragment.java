package com.example.petagramtabs.fragmentos;

import com.example.petagramtabs.Adapters.AdapterMascotas;
import com.example.petagramtabs.Mascota;

import java.util.ArrayList;

public interface IRecycleriniFragment {
    public void generarLinearLayout();
    public AdapterMascotas crearAdaptador(ArrayList<Mascota> listMascotas);
    public void inicializarAdaptadorRV(AdapterMascotas adapter);

}
