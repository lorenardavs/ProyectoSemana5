package com.example.petagramtabs.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.petagramtabs.Adapters.AdapterMascotas;
import com.example.petagramtabs.MascotasPerfil;
import com.example.petagramtabs.Presentadores.IRecyclerInitFragmentPresenter;
import com.example.petagramtabs.Presentadores.IRecyclerPerfilFragmentPresenter;
import com.example.petagramtabs.Presentadores.RecyclerInitFragmentPresenter;
import com.example.petagramtabs.Presentadores.RecyclerPerfilFragmentPresenter;
import com.example.petagramtabs.R;
import com.example.petagramtabs.Adapters.AdapterMascotasPerfil;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecyclerPerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecyclerPerfilFragment extends Fragment implements IRecyclerPerfilFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<MascotasPerfil> listMascota;
    RecyclerView recyclerMascotas;
    private IRecyclerPerfilFragmentPresenter presenter;

    public RecyclerPerfilFragment() {}

    public static RecyclerPerfilFragment newInstance(String param1, String param2) {
        RecyclerPerfilFragment fragment = new RecyclerPerfilFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v  = inflater.inflate(R.layout.fragment_recycler_perfil, container, false);
        listMascota = new ArrayList<>();
        recyclerMascotas = (RecyclerView)  v.findViewById(R.id.recyclerid2);
        presenter = new RecyclerPerfilFragmentPresenter(this,getContext());
        return v;
    }

    @Override
    public void generarLinearLayout() {
        recyclerMascotas.setLayoutManager(new GridLayoutManager(getContext(), 3));
    }

    @Override
    public AdapterMascotasPerfil crearAdaptador(ArrayList<MascotasPerfil> listMascota) {
        AdapterMascotasPerfil adapter = new AdapterMascotasPerfil(listMascota);
        return adapter;
    }

    @Override
    public void inicializarAdaptadorRV(AdapterMascotasPerfil adapter) {
        recyclerMascotas.setAdapter(adapter);
    }
}