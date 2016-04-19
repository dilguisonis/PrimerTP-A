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
    int tipo;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnImprimir(View v) {

        ImageView vv ;
        android.widget.EditText nombre   = (EditText) findViewById(R.id.nombre);
        EditText apellido   = (EditText) findViewById(R.id.apellido);
        EditText materia   = (EditText) findViewById(R.id.materia);
        EditText curso   = (EditText) findViewById(R.id.curso);
        Intent intent = new Intent(this, printActivity.class);
        Persona p = new Persona(nombre.getText().toString(),apellido.getText().toString(),sexo);
        if (tipo==1) {
            Persona Per = new Profesor(nombre.getText().toString(), apellido.getText().toString(), sexo, materia.getText().toString());
            intent.putExtra("persona",Per);
        }
        else if (tipo == 2) {
            Persona Per = new Alumno(nombre.getText().toString(), apellido.getText().toString(), sexo, curso.getText().toString());
            intent.putExtra("persona",Per);
        }

        intent.putExtra("pers1",p);
        //intent.putExtra("pers2", p2);
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

    public void eligeProfesion (View view) {
        EditText materia = (EditText) findViewById(R.id.materia);
        EditText curso = (EditText) findViewById(R.id.curso);
        RadioButton alumno  = (RadioButton) findViewById(R.id.alumno);
        RadioButton profesor  = (RadioButton) findViewById(R.id.profesor);
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.profesor:
                if (checked)
                    //Toast.makeText(this,"Profesor", Toast.LENGTH_SHORT).show();
                    materia.setVisibility(View.VISIBLE);
                    curso.setVisibility(View.GONE);
                    tipo = 1;
                break;
            case R.id.alumno:
                if (checked)
                    //Toast.makeText(this,"Alumno", Toast.LENGTH_SHORT).show();
                    curso.setVisibility(View.VISIBLE);
                    materia.setVisibility(View.GONE);
                     tipo = 2;
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
