package com.example.petagramtabs.Constructores;

import android.content.Context;

import com.example.petagramtabs.MascotasPerfil;
import com.example.petagramtabs.R;

import java.util.ArrayList;

public class ConstructorPerfil {

    private Context context;

    public ConstructorPerfil(Context context) {
        this.context = context;
    }
    public ArrayList<MascotasPerfil> obtenerDatos() {
        ArrayList<MascotasPerfil> listMascota = new ArrayList<>();
        listMascota.add(new MascotasPerfil("5", R.drawable.img1));
        listMascota.add(new MascotasPerfil("0",R.drawable.img1));
        listMascota.add(new MascotasPerfil("3",R.drawable.img1));
        listMascota.add(new MascotasPerfil("10",R.drawable.img1));
        listMascota.add(new MascotasPerfil("2",R.drawable.img1));
        listMascota.add(new MascotasPerfil("3",R.drawable.img1));
        listMascota.add(new MascotasPerfil("1",R.drawable.img1));
        listMascota.add(new MascotasPerfil("7",R.drawable.img1));
        listMascota.add(new MascotasPerfil("4",R.drawable.img1));
        listMascota.add(new MascotasPerfil("8",R.drawable.img1));
        listMascota.add(new MascotasPerfil("6",R.drawable.img1));
        listMascota.add(new MascotasPerfil("1",R.drawable.img1));
        return  listMascota;
    }
}
