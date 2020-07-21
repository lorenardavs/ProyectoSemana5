package com.example.petagramtabs.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagramtabs.MascotasPerfil;
import com.example.petagramtabs.R;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class AdapterMascotasPerfil extends RecyclerView.Adapter<AdapterMascotasPerfil.ViewHolderDatos>{

    ArrayList<MascotasPerfil> listMascota;

    public AdapterMascotasPerfil(ArrayList<MascotasPerfil> listMascota) {
        this.listMascota = listMascota;
    }

    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_perfil_mascota, null, false);
        return new ViewHolderDatos(view);
    }

     @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
            holder.favorito.setText(listMascota.get(position).getFavorito());
            holder.foto.setImageResource(listMascota.get(position).getFoto());

    }

    @Override
    public int getItemCount() {
        return listMascota.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView favorito ;
        CircularImageView foto;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            favorito = (TextView) itemView.findViewById(R.id.texto_favoritomascota);
            foto = (CircularImageView) itemView.findViewById(R.id.img_mascotas);


        }

    }
}
