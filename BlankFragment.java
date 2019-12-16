package com.example.luis.pruebasfragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {
    //Lo pongo global para poder avisarle de que han cambiado los datos.
    private ArrayAdapter<String> adapter;



    private EditText et_nombre;
    private Spinner spn_tareas;
    private ArrayList<String> lista_tareas;
    private Button btn_fragment;
    //Oyente para pasar mensajes al Main
    private OnFragmentInteractionListener mListener;

    public BlankFragment() {
        // Required empty public constructor
    }


    public static BlankFragment newInstance(ArrayList<String> lista_tareas) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putStringArrayList("valores", lista_tareas);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            lista_tareas = getArguments().getStringArrayList("valores");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Como quiero acceder a objetos View del FGragment, no retorno directamente la vista.

        View vista=inflater.inflate(R.layout.fragment_blank, container, false);
        //Ojo porque aunque en R.id aparecen todos los objetos View, sólo puedo
        //acceder a los que están en la vista mostrada

        spn_tareas=vista.findViewById(R.id.spn_tareas);
       adapter = new ArrayAdapter<String>(
                getContext(), android.R.layout.simple_spinner_item, lista_tareas);
        spn_tareas.setAdapter(adapter);

        return vista;
    }

    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public void addTarea(String tarea)
    {
        lista_tareas.add(tarea);
        adapter.notifyDataSetChanged();
    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void pasarDato(String nombre);
    }
}
