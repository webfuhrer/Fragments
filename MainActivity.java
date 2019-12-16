package com.example.luis.pruebasfragments;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
   //Se implementa la interfaz BlankFragment.OnFragmentInteractionListener para pasar mensajes entre el Fragment y el MainActivity
public class MainActivity extends AppCompatActivity implements  BlankFragment.OnFragmentInteractionListener{
Button btn_fragmento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_fragmento=findViewById(R.id.btn_fragmento);
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
    public void onFragmentInteraction(Uri uri) {

    }
}
