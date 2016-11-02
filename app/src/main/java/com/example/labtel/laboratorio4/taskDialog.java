package com.example.labtel.laboratorio4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

/**
 * Created by Cristhian on 11/2/16.
 */
public class taskDialog  extends DialogFragment {

    public String title ="Detalle de la tarea";
    public String message ="";
    public Context context ;
    public int index=0;



    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);
        builder.setMessage(message);

        builder.setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final GlobalClass globalVariable = (GlobalClass) context;


                globalVariable.agenda.removeTask(index);

                final ArrayAdapter<String> adp=new ArrayAdapter<String>
                        (context,R.layout.list,globalVariable.agenda.getAllTaskShort());
                globalVariable.list_tareas.setAdapter(adp);


                dismiss();
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dismiss();
            }
        });



        return builder.create();
    }
}