package com.example.ejerciciovehiculos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ejerciciovehiculos.modelos.CocheModel;

public class moto_activity extends AppCompatActivity {
    private TextView txtMarca;
    private TextView txtModelo;
    private TextView txtCC;
    private Button btnCancelar;
    private Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moto);
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
                String cc = txtCC.getText().toString();

                if (!marca.isEmpty() && !modelo.isEmpty() && !cc.isEmpty()){
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("COCHE", new CocheModel(marca,modelo,cc));
                    intent.putExtras(bundle);
                    setResult(RESULT_OK,intent);
                    startActivity(intent);
                }else {
                    Toast.makeText(moto_activity.this, "FALTAN DATOS", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(moto_activity.this, "Moto devuelta", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void inicializar() {
        txtMarca = findViewById(R.id.txtMarcaMoto);
        txtModelo = findViewById(R.id.txtModeloMoto);
        txtCC = findViewById(R.id.txtCCMoto);
        btnCancelar = findViewById(R.id.btnCancelarMoto);
        btnCrear = findViewById(R.id.btnCrearMoto);
    }
}