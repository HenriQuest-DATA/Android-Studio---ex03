package henrique.uniara.olamundo.atividade3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBotaoCalcularClickListener();
    }

    public void setSpinner(Spinner spinner) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("+");
        arrayList.add("-");
        arrayList.add("/");
        arrayList.add("*");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,                         android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tutorialsName = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected: " + tutorialsName,          Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });
    }

    public void addBotaoCalcularClickListener() {
        Button btnCalcular = (Button) findViewById(R.id.btnCalcular);
        Spinner operationSpinner = (Spinner) findViewById(R.id.opSpinner);

        setSpinner(operationSpinner);

        btnCalcular.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Log.i("meu app", "Meu botão foi clicado");

                EditText txtValor1 = (EditText) findViewById(R.id.number1);
                String Valor1 = getValueFromInput(txtValor1);

                EditText txtValor2 = (EditText) findViewById(R.id.number2);
                String Valor2 = getValueFromInput(txtValor2);

                float intValor1 = Float.parseFloat(Valor1);
                float intValor2 = Float.parseFloat(Valor2);

                String operator = operationSpinner.getSelectedItem().toString();
                float resultado = 0;

                switch (operator) {
                    case "+":
                        resultado = intValor1 + intValor2;
                        break;

                    case "-":
                        resultado = intValor1 - intValor2;
                        break;

                    case "/":
                        resultado = intValor1 / intValor2;
                        break;

                    case "*":
                        resultado = intValor1 * intValor2;
                        break;

                    default:
                        resultado = intValor1 + intValor2;
                        break;
                }

                Toast.makeText(getApplicationContext(), Float.toString(resultado), Toast.LENGTH_SHORT).show();
            }

        });
    }

    public String getValueFromInput(EditText CampoTexto) {

        return CampoTexto.getText().toString();
    }
}