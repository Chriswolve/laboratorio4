package com.example.labtel.laboratorio4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by labtel on 22/10/2016.
 */
public class Agenda {

    private static ArrayList<Contact> agenda = new ArrayList<Contact>();
    private static ArrayList<Task> checklist = new ArrayList<Task>();


    public void addTask(String _titulo, String _fechaini, String _fechafin, String _descripcion){

        checklist.add(new Task(_titulo,_fechaini,_fechafin,_descripcion));
    }

    public void removeTask(int index){
        checklist.remove(index);
    }

    public List<String> getAllTasks()
    {
        List<String> li = new ArrayList<String>();
        for (Task task : checklist) {
            li.add(task.toString());

        }

        return li;
    }

    public List<String> getAllTaskShort()
    {
        List<String> li = new ArrayList<String>();
        int position = 1;
        for (Task task : checklist) {
            li.add("Tarea "+(position)+"\n"+task.toStringShort());
            position++;
        }

        return li;
    }




    public void addContacto( String nombre,String DNI, String correo,String numero)
    {
        agenda.add(new Contact(nombre,DNI,correo,numero));
    }


    public void removeContacto(int index){
        agenda.remove(index);
    }
    public List<String> getAllContacts()
    {
        List<String> li = new ArrayList<String>();
        for (Contact contact : agenda) {
            li.add(contact.toString());

        }

        return li;
    }
    public List<String> getAllContactsShort()
    {
        List<String> li = new ArrayList<String>();
        int position = 1;
        for (Contact contact : agenda) {
            li.add("Contacto "+(position)+"\n"+contact.toStringShort());
            position++;
        }

        return li;
    }

    public String find(String nombre)
    {
        String result = "No Encontrado";
        boolean primera = true;
        for (Contact contact : agenda) {
            String ncontacto = contact.getNombre().toLowerCase();
            if(ncontacto.contains(nombre)) {

                if (primera) {

                    result = contact.toString() + "\n";
                    primera = false;

                }
                else {
                    result += contact.toString();

                }
            }
        }

        return result;
    }
}
