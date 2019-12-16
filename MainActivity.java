package com.example.luis.pruebasfragments;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

//Se implementa la interfaz BlankFragment.OnFragmentInteractionListener para pasar mensajes entre el Fragment y el MainActivity
public class MainActivity extends AppCompatActivity implements  BlankFragment.OnFragmentInteractionListener, BlankFragment2.OnFragmentInteractionListener{
Button btn_fragmento, btn_add_tarea;
EditText et_tarea;
BlankFragment b;//Lo hago global para poder acceder a él en el addTarea
//TextView tv_nombre;//Este TV será para mostrar el nombree cuiando el Fragment se lo pase
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_add_tarea=findViewById(R.id.btn_add);
        btn_fragmento=findViewById(R.id.btn_fragmento);
        et_tarea=findViewById(R.id.et_tarea);
        final ArrayList<String> tareas=new ArrayList();
        tareas.add("Barrer");
        tareas.add("Fregar");
        btn_add_tarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tarea=et_tarea.getText().toString();
                b.addTarea(tarea);
            }
        });
        btn_fragmento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Un objeto de tipo BlankFragment
                b=BlankFragment.newInstance(tareas);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.id_contenedor, b);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        /*
* // Create new fragment and transaction
Fragment newFragment = new ExampleFragment();
FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack
transaction.replace(R.id.fragment_container, newFragment);
transaction.addToBackStack(null);

// Commit the transaction
transaction.commit();*/
    }


       @Override
       public void pasarDato(String nombre) {
           //tv_nombre.setText(nombre);
       }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
