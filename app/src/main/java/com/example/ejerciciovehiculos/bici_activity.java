package com.example.ejerciciovehiculos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ejerciciovehiculos.modelos.BiciModel;
import com.example.ejerciciovehiculos.modelos.CocheModel;

public class bici_activity extends AppCompatActivity {
    private TextView txtMarcaBici;
    private TextView txtPulgadas;
    private Button btnCancelar;
    private Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bici);

        inicializar();

        cancelar();

        crear();
    }

    private void crear() {
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String marca = txtMarcaBici.getText().toString();
                String pulgadas = txtPulgadas.getText().toString();

                if (!marca.isEmpty() && !pulgadas.isEmpty()){
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("BICICLETA", new BiciModel(marca,pulgadas));
                    intent.putExtras(bundle);
                    setResult(RESULT_OK,intent);
                    startActivity(intent);
                }else {
                    Toast.makeText(bici_activity.this, "FALTAN DATOS", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(bici_activity.this, "Bicicleta devuelta", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void inicializar() {
        txtMarcaBici = findViewById(R.id.txtMarcaBici);
        txtPulgadas = findViewById(R.id.txtPulgadasBici);
        btnCancelar = findViewById(R.id.btnCancelarBici);
        btnCrear = findViewById(R.id.btnCrearBici);
    }
}