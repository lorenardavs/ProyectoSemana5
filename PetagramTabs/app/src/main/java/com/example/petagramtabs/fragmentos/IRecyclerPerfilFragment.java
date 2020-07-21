package com.example.petagramtabs.fragmentos;

import com.example.petagramtabs.Adapters.AdapterMascotas;
import com.example.petagramtabs.Adapters.AdapterMascotasPerfil;
import com.example.petagramtabs.Mascota;
import com.example.petagramtabs.MascotasPerfil;

import java.util.ArrayList;

public interface IRecyclerPerfilFragment {
    public void generarLinearLayout();
    public AdapterMascotasPerfil crearAdaptador(ArrayList<MascotasPerfil> listMascota);
    public void inicializarAdaptadorRV(AdapterMascotasPerfil adapter);
}
