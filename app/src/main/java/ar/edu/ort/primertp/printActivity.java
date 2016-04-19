package ar.edu.ort.primertp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class printActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        Persona p = (Persona) extras.getSerializable("pers1");
        Persona Per = (Persona) extras.getSerializable("persona");


        TextView nombreyapVw = (TextView) findViewById(R.id.nombreyapellido);
        TextView sexoVw = (TextView) findViewById(R.id.sexo);

        try {
            nombreyapVw.setText(Per.imprimir());
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }


        String sexoStr;

        if (p.getSexo() == p.FEMENINO)
            sexoStr = "Sexo: Femenino";
        else
            sexoStr = "Sexo: Masculino";
        sexoVw.setText(sexoStr);
    }
}

