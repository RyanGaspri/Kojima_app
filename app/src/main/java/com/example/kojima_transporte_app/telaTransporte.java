package com.example.kojima_transporte_app;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kojima_transporte_app.model.DataBase;

public class telaTransporte extends AppCompatActivity {

    private EditText dataEditText;
    private EditText motoristaEditText;
    private EditText veiculoEditText;
    private EditText placaEditText;
    private EditText kmSaidaEditText;
    private EditText kmFinalEditText;
    private EditText horaInicialEditText;
    private EditText dataHoraInicialEditText;
    private EditText horaFinalEditText;
    private EditText dataHoraFinalEditText;
    private EditText pernoitesEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_transporte);

        dataEditText = findViewById(R.id.DataOT);
        motoristaEditText = findViewById(R.id.MotoristaEdit);
        veiculoEditText = findViewById(R.id.veiculoEdit);
        placaEditText = findViewById(R.id.placaEdit);
        kmSaidaEditText = findViewById(R.id.KmSaidaEdit);
        kmFinalEditText = findViewById(R.id.KmFinalEdit);
        horaInicialEditText = findViewById(R.id.HoraInicialEdit);
        dataHoraInicialEditText = findViewById(R.id.DataHI);
        horaFinalEditText = findViewById(R.id.HoraFinalEdit);
        dataHoraFinalEditText = findViewById(R.id.DataHF);
        pernoitesEditText = findViewById(R.id.PernoitesEdit);

        ImageButton BotaoSalvar= findViewById(R.id.salvar_botão);
        BotaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBase DB = new DataBase(telaTransporte.this);
                DB.AdicionarOrdem(motoristaEditText.getText().toString().trim(),
                        veiculoEditText.getText().toString().trim(),
                        placaEditText.getText().toString().trim(),
                        dataEditText.getText().toString().trim(),
                        dataHoraFinalEditText.getText().toString().trim(),
                        dataHoraInicialEditText.getText().toString().trim(),
                        kmFinalEditText.getText().toString().trim(),
                        kmSaidaEditText.getText().toString().trim(),
                        pernoitesEditText.getText().toString().trim(),
                        horaFinalEditText.getText().toString().trim(),
                        horaInicialEditText.getText().toString().trim());
            }
        }
        );

        ImageButton botaoenviar = findViewById(R.id.enviar_botão);
        botaoenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

}
