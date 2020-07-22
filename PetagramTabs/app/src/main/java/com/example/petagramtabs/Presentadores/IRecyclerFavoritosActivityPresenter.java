package com.example.petagramtabs.Presentadores;

import com.example.petagramtabs.Mascota;

import java.util.ArrayList;

public interface IRecyclerFavoritosActivityPresenter {
    public ArrayList<Mascota> obtenerMascotas();
    public void mostrarMascotasRecyclerView();
}
