package com.example.chaby.tarea2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class ConfirmarDatos extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    private TextView txtNombre;
    private TextView txtFechaNacimiento;
    private TextView txtTelefono;
    private TextView txtEmail;
    private TextView txtDescripcion;
    private Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);


        Bundle parametros = getIntent().getExtras();
// getString (variable global)
        String nombre = parametros.getString(getResources().getString(R.string.pnombre));
        String fecha = parametros.getString(getResources().getString(R.string.pfecha));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String email = parametros.getString(getResources().getString(R.string.pemail));
        String descripcion = parametros.getString(getResources().getString(R.string.pdescripcion));

        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtFechaNacimiento = (TextView) findViewById(R.id.txtFechaNacimiento);
        txtTelefono = (TextView) findViewById(R.id.txtTelefono);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);

        txtNombre.setText(nombre);
        txtFechaNacimiento.setText(fecha);
        txtTelefono.setText(telefono);
        txtEmail.setText(email);
        txtDescripcion.setText(descripcion);



        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("ConfirmarDatos Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
    //Finaliza Actividad
    public void finalizar(View view) {
        finish();





   }



    public void confirmar (View v) {


        Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);
        intent.putExtra(getResources().getString(R.string.pnombre), txtNombre.getText().toString());
        intent.putExtra(getResources().getString(R.string.pfecha), txtFechaNacimiento.getText().toString());
        intent.putExtra(getResources().getString(R.string.ptelefono), txtTelefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.pemail), txtEmail.getText().toString());
        intent.putExtra(getResources().getString(R.string.pdescripcion), txtDescripcion.getText().toString());
        startActivity(intent);
        finish();


    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == android.view.KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }


}
