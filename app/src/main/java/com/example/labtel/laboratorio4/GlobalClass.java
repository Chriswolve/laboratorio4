package com.example.labtel.laboratorio4;

/**
 * Created by Cristhian on 10/25/16.
 */
import android.app.Application;
import android.widget.ListView;


public class GlobalClass extends Application {

    // Variables

    public Agenda agenda = new Agenda();
    public ListView list_agenda;
    public ListView list_tareas;



    public GlobalClass(){

    }

}