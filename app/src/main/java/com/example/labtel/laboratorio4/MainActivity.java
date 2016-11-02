package com.example.labtel.laboratorio4;



import android.app.FragmentManager;
import android.app.ListActivity;

import android.content.Intent;
import android.content.res.Resources;

import android.net.Uri;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import android.widget.TabHost;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> li;
    List<String> tareas;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();


        TabHost tabs = (TabHost) findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec = tabs.newTabSpec("mitab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Contactos",
                res.getDrawable(android.R.drawable.ic_btn_speak_now));
        tabs.addTab(spec);

        spec = tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Tareas",
                res.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);

        tabs.setCurrentTab(0);

        tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            public void onTabChanged(String tabId) {
                Log.i("AndroidTabsDemo", "Pulsada pestaña: " + tabId);
            }
        });


        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

        globalVariable.agenda.addContacto("Cristhian", "73612755", "cristhianr.gomez@gmail.com", "957407217");
        li = globalVariable.agenda.getAllContactsShort();


        globalVariable.list_agenda = (ListView) findViewById(R.id.list_contacts);


        final ArrayAdapter<String> adp = new ArrayAdapter<String>
                (getBaseContext(), R.layout.list, li);

        globalVariable.list_agenda.setAdapter(adp);


        globalVariable.list_agenda.setOnItemClickListener(new AdapterView.OnItemClickListener() {



            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position,
                                    long id) {


               final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                li = globalVariable.agenda.getAllContacts();
                FragmentManager fm = getFragmentManager();
                contactDialog dialogFragment = new contactDialog();
                dialogFragment.index = position;
                dialogFragment.message = "Contacto " + (position + 1) + "\n" + li.get(position);
                dialogFragment.context = getApplicationContext();


                dialogFragment.show(fm, "Sample Fragment");


            }
        });




        final ListView listTareas = (ListView) findViewById(R.id.list_tareas);

        globalVariable.agenda.addTask("Estudiar Matematica","2016-11-04","2016-11-05","Practica 1, Practica 2 del libro");

        tareas = globalVariable.agenda.getAllTaskShort();

        globalVariable.list_tareas = listTareas;

        final ArrayAdapter<String> adptareas = new ArrayAdapter<String>
                (getBaseContext(), R.layout.list, tareas);

        globalVariable.list_tareas.setAdapter(adptareas);


        globalVariable.list_tareas.setOnItemClickListener(new AdapterView.OnItemClickListener() {



            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position,
                                    long id) {


                final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
                tareas = globalVariable.agenda.getAllTasks();
                FragmentManager fm = getFragmentManager();
                taskDialog dialogFragment = new taskDialog();
                dialogFragment.index = position;
                dialogFragment.message = "Tarea " + (position + 1) + "\n" + tareas.get(position);
                dialogFragment.context = getApplicationContext();


                dialogFragment.show(fm, "Sample Fragment");


            }
        });




        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void buscarContacto(View view) {


        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        EditText nombre = (EditText) findViewById(R.id.txt_buscarc) ;
        String result = globalVariable.agenda.find(nombre.getText().toString());
        FragmentManager fm = getFragmentManager();
        FireMissilesDialogFragment dialogFragment = new FireMissilesDialogFragment();
        dialogFragment.title = "Datos del contacto";
        dialogFragment.message = result;
        dialogFragment.show(fm, "Sample Fragment");



    }

    public void addContacto(View view) {
        Intent intent = new Intent(this, contactActivity.class);
        startActivity(intent);
    }

    public void buscarTarea(View view) {
        Toast.makeText(getBaseContext(), "LLame",
                Toast.LENGTH_SHORT).show();
    }

    public void addTarea(View view) {
        Intent intent = new Intent(this, tareasActivity.class);
        startActivity(intent);
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.labtel.laboratorio4/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.labtel.laboratorio4/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}



