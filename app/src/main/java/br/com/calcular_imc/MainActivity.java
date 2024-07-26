package br.com.calcular_imc;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textResultado;
    private EditText editPeso;
    private EditText editAltura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });

        textResultado = findViewById(R.id.textResultado);
        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);

    }

    public void calcularImc(View view){

            double peso = Double.parseDouble(editPeso.getText().toString()) ;
            double altura = Double.parseDouble(editAltura.getText().toString());
            double resultado = peso / (altura*altura);

        if (resultado >= 18.6 && resultado <= 24.9) {
            textResultado.setText( "Normal");
        } else if (resultado <= 18.5) {
            textResultado.setText( "Abaixo do normal");
        } else if (resultado >= 25.0 && resultado <= 29.9) {
            textResultado.setText( "Sobrepeso");
        } else if (resultado >= 30.0 && resultado <= 34.9) {
            textResultado.setText( "Obesidade grau I");
        } else if (resultado >= 35.0 && resultado <= 39.9) {
            textResultado.setText( "Obesidade grau II");
        } else if (resultado >= 40.0) {
            textResultado.setText( "Obesidade grau III");
        }

    }


}