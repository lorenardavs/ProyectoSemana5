package com.example.petagramtabs.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.petagramtabs.Mascota;
import com.example.petagramtabs.Presentadores.IRecyclerInitFragmentPresenter;
import com.example.petagramtabs.Presentadores.RecyclerInitFragmentPresenter;
import com.example.petagramtabs.R;
import com.example.petagramtabs.Adapters.AdapterMascotas;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecycleriniFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecycleriniFragment extends Fragment implements IRecycleriniFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<Mascota> listMascotas;
    RecyclerView recyclerMascotas;
    public AdapterMascotas adapter;
    private IRecyclerInitFragmentPresenter presenter;

    public RecycleriniFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecycleriniFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecycleriniFragment newInstance(String param1, String param2) {
        RecycleriniFragment fragment = new RecycleriniFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista  = inflater.inflate(R.layout.fragment_recycler_principal, container, false);
        recyclerMascotas = (RecyclerView)  vista.findViewById(R.id.recyclerid);
        listMascotas = new ArrayList<>();
        presenter = new RecyclerInitFragmentPresenter(this,getContext());
        return vista;
    }
    /*
    private void llenarpersonajes() {
            listMascotas.add(new Mascota("Catty","5",R.drawable.img1));
            listMascotas.add(new Mascota("Lucas","7",R.drawable.img2));
            listMascotas.add(new Mascota("Susy","0",R.drawable.img1));
            listMascotas.add(new Mascota("Ron","4",R.drawable.img2));
            listMascotas.add(new Mascota("Luna","1",R.drawable.img1));
            listMascotas.add(new Mascota("Ronny","3",R.drawable.img2));
            listMascotas.add(new Mascota("Bonny","2",R.drawable.img1));
            listMascotas.add(new Mascota("Rose","4",R.drawable.img1));
    }
*/
    @Override
    public void generarLinearLayout() {
        recyclerMascotas.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public AdapterMascotas crearAdaptador(ArrayList<Mascota> listMascotas) {
        adapter = new AdapterMascotas(listMascotas, getActivity());
        return adapter;
    }

    @Override
    public void inicializarAdaptadorRV(AdapterMascotas adapter) {
        recyclerMascotas.setAdapter(adapter);

    }

    public interface OnFragmentInteractionListener {
    }


}
