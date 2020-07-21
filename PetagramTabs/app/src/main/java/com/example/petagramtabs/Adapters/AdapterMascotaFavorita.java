package com.example.petagramtabs.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagramtabs.MascotaFavorita;
import com.example.petagramtabs.R;


import java.util.ArrayList;

public class AdapterMascotaFavorita extends RecyclerView.Adapter<AdapterMascotaFavorita.ViewHolderMascota> {
    ArrayList<MascotaFavorita> listamascotasfav;


    public AdapterMascotaFavorita(ArrayList<MascotaFavorita> listamascotasfav) {
        this.listamascotasfav = listamascotasfav;
    }

    @Override
    public ViewHolderMascota onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_mascota_favorita, null, false);

    return  new ViewHolderMascota(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMascota holder, int position) {
        holder.nombre.setText(listamascotasfav.get(position).getNombre());
        holder.favorito.setText(listamascotasfav.get(position).getFavorito());
        holder.foto.setImageResource(listamascotasfav.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listamascotasfav.size();
    }

    public class ViewHolderMascota extends RecyclerView.ViewHolder {
        TextView nombre ;
        TextView favorito ;
        ImageView foto;


        public ViewHolderMascota(@NonNull View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.texto_nommascotas1);
            favorito = (TextView) itemView.findViewById(R.id.texto_favoritomascota1);
            foto = (ImageView) itemView.findViewById(R.id.img_mascotas1);
        }
    }
}
