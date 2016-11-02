package com.example.labtel.laboratorio4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Cristhian on 10/25/16.
 */
public class contactDialog extends DialogFragment {

    public String title ="Datos del Contacto";
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


                globalVariable.agenda.removeContacto(index);

                final ArrayAdapter<String> adp=new ArrayAdapter<String>
                        (context,R.layout.list,globalVariable.agenda.getAllContactsShort());
                globalVariable.list_agenda.setAdapter(adp);


                dismiss();
            }
        });

        builder.setNegativeButton("LLamar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "LLamando...",
                        Toast.LENGTH_LONG).show();
                dismiss();
            }
        });



        return builder.create();
    }
}