package com.example.labtel.laboratorio4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

public class contactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }

    public void crearContacto(View view)
    {

        EditText nombre = (EditText)findViewById(R.id.txt_cnombre);
        EditText dni = (EditText)findViewById(R.id.txt_cdni);
        EditText email = (EditText)findViewById(R.id.txt_cemail);
        EditText numero = (EditText)findViewById(R.id.txt_cnum);

        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();


        globalVariable.agenda.addContacto(nombre.getText().toString(),
                dni.getText().toString(),email.getText().toString(),numero.getText().toString());

        final ArrayAdapter<String> adp=new ArrayAdapter<String>
                (getBaseContext(),R.layout.list,globalVariable.agenda.getAllContactsShort());

        globalVariable.list_agenda.setAdapter(adp);

        this.finish();
    }
}
