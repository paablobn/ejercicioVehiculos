package com.example.ejerciciovehiculos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ejerciciovehiculos.modelos.CocheModel;

public class coche_activity extends AppCompatActivity {
    private TextView txtMarca;
    private TextView txtModelo;
    private TextView txtColor;
    private Button btnCancelar;
    private Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coche);

        inicializar();
        cancelar();
        crear();
    }

    private void crear() {
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String marca = txtMarca.getText().toString();
                String modelo = txtModelo.getText().toString();
                String color = txtColor.getText().toString();

                if (!marca.isEmpty() && !modelo.isEmpty() && !color.isEmpty()){
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("COCHE", new CocheModel(marca,modelo,color));
                    intent.putExtras(bundle);
                    setResult(RESULT_OK,intent);
                    startActivity(intent);
                }else {
                    Toast.makeText(coche_activity.this, "FALTAN DATOS", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void cancelar() {
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
                Toast.makeText(coche_activity.this, "Coche devuelto", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void inicializar() {
        txtMarca = findViewById(R.id.txtMarcaCoche);
        txtModelo = findViewById(R.id.txtModeloCoche);
        txtColor = findViewById(R.id.txtColorCoche);
        btnCancelar = findViewById(R.id.btnCancelarCoche);
        btnCrear = findViewById(R.id.btnCrearCoche);
    }
}