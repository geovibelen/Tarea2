package com.example.chaby.tarea2;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    private TextInputEditText etNombre;
    private TextInputEditText etFecha;
    private TextInputEditText etTelefono;
    private TextInputEditText etEmail;
    private TextInputEditText etDescripcion;
    private Button btnSiguiente;
    private  DatePickerDialog datePickerDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);

        etNombre = (TextInputEditText) findViewById(R.id.etNombre);
        etFecha = (TextInputEditText) findViewById(R.id.etFecha);
        etTelefono = (TextInputEditText) findViewById(R.id.etTelefono);
        etEmail = (TextInputEditText) findViewById(R.id.etEmail);
        etDescripcion = (TextInputEditText) findViewById(R.id.etDescripcion);

        etFecha.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    final Calendar c = Calendar.getInstance();
                    int mYear = c.get(Calendar.YEAR); // current year
                    int mMonth = c.get(Calendar.MONTH); // current month
                    int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                    // date picker dialog
                    datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            // set day of month , month and year value in the edit text
                            etFecha.setText(dayOfMonth + "/"
                                    + (monthOfYear + 1) + "/" + year);

                        }
                    }, mYear, mMonth, mDay);
                    datePickerDialog.show();
                }
            }
        });

        try {
            Bundle parametros = getIntent().getExtras();
// getString (variable global)
            String nombre = parametros.getString(getResources().getString(R.string.pnombre));
            String fecha = parametros.getString(getResources().getString(R.string.pfecha));
            String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
            String email = parametros.getString(getResources().getString(R.string.pemail));
            String descripcion = parametros.getString(getResources().getString(R.string.pdescripcion));

            etNombre.setText(nombre);
            etFecha.setText(fecha);
            etTelefono.setText(telefono);
            etEmail.setText(email);
            etDescripcion.setText(descripcion);
        } catch (java.lang.NullPointerException e) {

        }

    }

    public void ejecutar (View v) {
        Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);
        intent.putExtra(getResources().getString(R.string.pnombre), etNombre.getText().toString());
        intent.putExtra(getResources().getString(R.string.pfecha), etFecha.getText().toString());
        intent.putExtra(getResources().getString(R.string.ptelefono), etTelefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.pemail), etEmail.getText().toString());
        intent.putExtra(getResources().getString(R.string.pdescripcion), etDescripcion.getText().toString());
       startActivity(intent);
        finish();
        }








}
