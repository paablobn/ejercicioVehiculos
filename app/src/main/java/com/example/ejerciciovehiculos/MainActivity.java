package com.example.ejerciciovehiculos;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ejerciciovehiculos.modelos.BiciModel;
import com.example.ejerciciovehiculos.modelos.CocheModel;
import com.example.ejerciciovehiculos.modelos.MotoModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnBici;
    private Button btnMoto;
    private Button btnCoche;
    private TextView txtBici;
    private TextView txtCoche;
    private TextView txtMoto;

    private ArrayList<CocheModel> listaCoches;
    private ArrayList<MotoModel> listaMotos;
    private ArrayList<BiciModel> listaBicis;

    private ActivityResultLauncher<Intent> launcherCrearCoches;
    private ActivityResultLauncher<Intent> launcherCrearMotos;
    private ActivityResultLauncher<Intent> launcherCrearBicis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializar();
        launchers();

        anyadirbici();
        anyadircoche();
        anyadirmoto();
    }

    private void launchers() {
        launcherCrearCoches = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            if (result.getData() != null && result.getData().getExtras() != null) {
                                CocheModel coche = (CocheModel) result.getData().getExtras().getSerializable("COCHE");
                                if (coche != null) {
                                    listaCoches.add(coche);
                                    txtCoche.setText("Coches: " + listaCoches.size());
                                }else {
                                    Toast.makeText(MainActivity.this, "No ha llegado ningun coche", Toast.LENGTH_SHORT).show();
                                }
                            }else {
                                Toast.makeText(MainActivity.this, "No tengo datos", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "VENTANA CANCELADA", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
        launcherCrearBicis = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            if (result.getData() != null && result.getData().getExtras() != null) {
                                BiciModel bici = (BiciModel) result.getData().getExtras().getSerializable("BICICLETA");
                                if (bici != null) {
                                    listaBicis.add(bici);
                                    txtBici.setText("Bicicletas: " + listaBicis.size());
                                }else {
                                    Toast.makeText(MainActivity.this, "No ha llegado ninguna bicicleta", Toast.LENGTH_SHORT).show();
                                }
                            }else {
                                Toast.makeText(MainActivity.this, "No tengo datos", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "VENTANA CANCELADA", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
        launcherCrearMotos = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            if (result.getData() != null && result.getData().getExtras() != null) {
                                MotoModel moto = (MotoModel) result.getData().getExtras().getSerializable("MOTO");
                                if (moto != null) {
                                    listaMotos.add(moto);
                                    txtMoto.setText("Motos: " + listaMotos.size());
                                }else {
                                    Toast.makeText(MainActivity.this, "No ha llegado ninguna moto", Toast.LENGTH_SHORT).show();
                                }
                            }else {
                                Toast.makeText(MainActivity.this, "No tengo datos", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "VENTANA CANCELADA", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    private void anyadirmoto() {
        btnMoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherCrearMotos.launch(new Intent(MainActivity.this,moto_activity.class));
            }
        });
    }

    private void anyadircoche() {
        btnCoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherCrearCoches.launch(new Intent(MainActivity.this,coche_activity.class));
            }
        });
    }

    private void anyadirbici() {
        btnBici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherCrearBicis.launch(new Intent(MainActivity.this,bici_activity.class));
            }
        });
    }

    private void inicializar() {
        btnBici = findViewById(R.id.btnBicicletaMain);
        btnCoche = findViewById(R.id.btnCocheMain);
        btnMoto = findViewById(R.id.btnMotoMain);
        txtBici = findViewById(R.id.txtBiciMain);
        txtCoche = findViewById(R.id.txtCocheMain);
        txtMoto = findViewById(R.id.txtMotoMain);
        listaCoches = new ArrayList<>();
        listaMotos = new ArrayList<>();
        listaBicis = new ArrayList<>();
    }
}