package com.example.labtel.laboratorio4;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class tareasActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;
    private String ini="";
    private String fin="";
    boolean action = true;
    public Button inicio;
    public Button bfinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tareas);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        inicio = (Button)findViewById(R.id.txt_tinicio);

        bfinal= (Button)findViewById(R.id.txt_tfin);


    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        action = true;
        showDialog(999);

    }
    @SuppressWarnings("deprecation")
    public void setFin(View view) {
        action = false;
        showDialog(999);

    }
    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            if(action) {
                ini = arg1 + "/" + (arg2 + 1) + "/" + arg3;
                inicio.setText(ini);
            }
            else {
                fin = arg1 + "/" + (arg2 + 1) + "/" + arg3;
                bfinal.setText(fin);
            }


        }
    };
    public void crearTarea(View view)
    {

        EditText nombre = (EditText)findViewById(R.id.txt_tnombre);
        //EditText ini = (EditText)findViewById(R.id.txt_tinicio);
        //EditText fin = (EditText)findViewById(R.id.txt_tfin);
        EditText desc = (EditText)findViewById(R.id.txt_tdesc);

        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();


        globalVariable.agenda.addTask(nombre.getText().toString(),
                ini,fin,desc.getText().toString());

        final ArrayAdapter<String> adp=new ArrayAdapter<String>
                (getBaseContext(),R.layout.list,globalVariable.agenda.getAllTaskShort());

        globalVariable.list_tareas.setAdapter(adp);

        this.finish();
    }
}
