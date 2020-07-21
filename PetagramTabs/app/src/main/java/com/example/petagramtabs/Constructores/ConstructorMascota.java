package com.example.petagramtabs.Constructores;

import android.content.ContentValues;
import android.content.Context;

import com.example.petagramtabs.BaseDatos.BaseDatos;
import com.example.petagramtabs.BaseDatos.ConstantesBaseDatos;
import com.example.petagramtabs.Mascota;
import com.example.petagramtabs.R;

import java.util.ArrayList;

public class ConstructorMascota {
    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascota(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos() {
    /*
        ArrayList<Mascota> listMascotas = new ArrayList<>();
        listMascotas.add(new Mascota("Catty","5",R.drawable.img1));
        listMascotas.add(new Mascota("Lucas","7",R.drawable.img2));
        listMascotas.add(new Mascota("Susy","0",R.drawable.img1));
        listMascotas.add(new Mascota("Ron","4",R.drawable.img2));
        listMascotas.add(new Mascota("Luna","1",R.drawable.img1));
        listMascotas.add(new Mascota("Ronny","3",R.drawable.img2));
        listMascotas.add(new Mascota("Bonny","2",R.drawable.img1));
        listMascotas.add(new Mascota("Rose","4",R.drawable.img1));

        return listMascotas;
*/
        BaseDatos db = new BaseDatos(context);
        insertarOchoMascotas(db);
        return db.obtenerTodasLasMascotas();
    }

    public void insertarOchoMascotas(BaseDatos db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Catty");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.img1);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Lucas");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.img2);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Susy");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.img1);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Ron");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.img2);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Luna");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.img1);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Ronny");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.img2);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Bonny");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.img1);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Rose");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.img1);
        db.insertarMascota(contentValues);
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_IDMASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUM_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascotas(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);

    }

}
