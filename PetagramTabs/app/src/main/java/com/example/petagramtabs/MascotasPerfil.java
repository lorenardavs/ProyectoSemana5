package com.example.petagramtabs;

public class MascotasPerfil {

    private String favorito;
    private int foto;

    public MascotasPerfil(String favorito, int foto) {
        this.favorito = favorito;
        this.foto = foto;

    }

    public String getFavorito() {
        return favorito;
    }

    public void setFavorito(String favorito) {
        this.favorito = favorito;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }


}
