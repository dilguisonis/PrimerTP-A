package ar.edu.ort.primertp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    int sexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnImprimir(View v) {

        ImageView vv ;
        android.widget.EditText nombre   = (EditText) findViewById(R.id.nombre);
        EditText apellido   = (EditText) findViewById(R.id.apellido);
        Intent intent = new Intent(this, printActivity.class);
        Persona p = new Persona(nombre.getText().toString(),apellido.getText().toString(),sexo);
        Persona p2 = new Persona("Juana","Perez",2);
        intent.putExtra("pers1",p);
        intent.putExtra("pers2",p2);
        startActivity(intent);
    }


    public void eligeSexo(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.masculino:
                if (checked)
                    //Toast.makeText(this,"Masculino", Toast.LENGTH_SHORT).show();
                    sexo = Persona.MASCULINO;
                break;
            case R.id.femenino:
                if (checked)
                    //Toast.makeText(this,"Femenino", Toast.LENGTH_SHORT).show();
                    sexo = Persona.FEMENINO;
                break;
        }
    }


    public void btnInvisible(View v) {
        EditText apellido   = (EditText) findViewById(R.id.apellido);
        apellido.setVisibility(View.INVISIBLE);
        EditText nombre   = (EditText) findViewById(R.id.nombre);
        nombre.setTextColor(Color.BLUE);
    }
    public void btnGone(View v) {
        EditText apellido   = (EditText) findViewById(R.id.apellido);
        apellido.setVisibility(View.GONE);
    }

}
