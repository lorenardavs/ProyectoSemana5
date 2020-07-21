package com.example.petagramtabs.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.petagramtabs.Constructores.ConstructorMascota;
import com.example.petagramtabs.Mascota;
import com.example.petagramtabs.R;

import java.util.ArrayList;

public class AdapterMascotas extends RecyclerView.Adapter<AdapterMascotas.ViewHolderDatos>{

    ArrayList<Mascota> listMascotas;
    Activity activity;

    public AdapterMascotas(ArrayList<Mascota> listMascotas, Activity activity) {
        this.listMascotas = listMascotas;
        this.activity = activity;
    }

    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_principal, null, false);
        return new ViewHolderDatos(view);
    }

     @Override
    public void onBindViewHolder(@NonNull final ViewHolderDatos holder, int position) {
        final Mascota mascota = listMascotas.get(position);
        holder.nombre.setText(mascota.getNombre());
        holder.favorito.setText(String.valueOf(mascota.getFavorito()));
        holder.foto.setImageResource(mascota.getFoto());

        holder.btnlike.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Toast.makeText(    view.getContext(), "Diste Like a " + holder.nombre.getText() , Toast.LENGTH_SHORT).show();

                 ConstructorMascota constructorMascota = new ConstructorMascota(activity);
                 constructorMascota.darLikeMascota(mascota);
                 holder.favorito.setText(String.valueOf(constructorMascota.obtenerLikesMascotas(mascota)));

             }
         });
    }

    @Override
    public int getItemCount() {
        return listMascotas.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView nombre ;
        TextView favorito ;
        ImageView foto;
        ImageButton btnlike;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.texto_nommascotas);
            favorito = (TextView) itemView.findViewById(R.id.texto_favoritomascota);
            foto = (ImageView) itemView.findViewById(R.id.img_mascotas);
            btnlike = (ImageButton) itemView.findViewById(R.id.btn_hueso);
        }

    }
}
