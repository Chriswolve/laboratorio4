package com.example.labtel.laboratorio4;

import java.util.ArrayList;

/**
 * Created by Cristhian on 10/24/16.
 */
public class Checklist {
    private static ArrayList<Task> checklist= new ArrayList<Task>();


    public void newTarea(String _titulo, String _fechaini, String _fechafin, String _descripcion){

        checklist.add(new Task(_titulo,_fechaini,_fechafin,_descripcion));
    }
}
