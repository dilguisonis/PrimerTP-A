package ar.edu.ort.primertp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        Persona p = (Persona)extras.getSerializable("pers1");
        Persona pppp = (Persona)extras.getSerializable("pers2");

        TextView nombreyapVw = (TextView)findViewById(R.id.nombreyapellido);
        TextView sexoVw = (TextView)findViewById(R.id.sexo);

        try {
            nombreyapVw.setText(p.imprimir());
        } catch (Exception e) {
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        //String sexoStr = String.valueOf(p.getSexo());
        String sexoStr;
        if (p.getSexo() == Persona.FEMENINO)
            sexoStr = "Femenino";
        else
            sexoStr = "Masculino";
        sexoVw.setText(sexoStr);

    }
}
