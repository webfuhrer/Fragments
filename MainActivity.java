package com.example.luis.pruebasfragments;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//Se implementa la interfaz BlankFragment.OnFragmentInteractionListener para pasar mensajes entre el Fragment y el MainActivity
public class MainActivity extends AppCompatActivity implements  BlankFragment.OnFragmentInteractionListener, BlankFragment2.OnFragmentInteractionListener{
Button btn_fragmento, btn_fragment2;
TextView tv_nombre;//Este TV será para mostrar el nombree cuiando el Fragment se lo pase
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_nombre=findViewById(R.id.tv_nombre);
        btn_fragmento=findViewById(R.id.btn_fragmento);
        btn_fragment2=findViewById(R.id.btn_fragment2);
        btn_fragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BlankFragment2 b=new BlankFragment2();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.id_contenedor, b);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        btn_fragmento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Un objeto de tipo BlankFragment
                BlankFragment b=new BlankFragment();
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
           tv_nombre.setText(nombre);
       }

    @Override
    public void onFragmentInteraction(Uri uri) {
        
    }
}
