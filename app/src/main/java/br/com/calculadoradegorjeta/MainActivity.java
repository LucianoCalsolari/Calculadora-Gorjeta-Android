package br.com.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText inputValor;
    private TextView textPorcentagem;
    private TextView textGorjeta;
    private TextView textTotal;
    private SeekBar seekBarGorjeta;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputValor = findViewById(R.id.edit);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        textGorjeta = findViewById(R.id.output_gorjeta);
        textTotal = findViewById(R.id.output_total);
        seekBarGorjeta = findViewById(R.id.seekBar_porcentagem);


        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                porcentagem = progress;
                textPorcentagem.setText(porcentagem + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular(){
        String valorRecuperado = inputValor.getText().toString();
        if (valorRecuperado == null || valorRecuperado.equals ("") ){

            Toast.makeText(
                   getApplicationContext(),
                   "Digite um valor primeiro! ",
                   Toast.LENGTH_SHORT
            ).show();
        }else{
            double valorDigitado = Double.parseDouble(valorRecuperado);
            double gorjeta = valorDigitado * (porcentagem/100);
            double total = gorjeta + valorDigitado;

            textGorjeta.setText("R$ " + Math.round(gorjeta));
            textTotal.setText("R$ " + total);
        }

    }

}