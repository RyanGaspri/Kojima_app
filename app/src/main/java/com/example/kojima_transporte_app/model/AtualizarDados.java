package com.example.kojima_transporte_app.model;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kojima_transporte_app.R;
public class AtualizarDados extends AppCompatActivity {

    EditText data, motorista, veiculo, placa, kmsaida, kmfinal, hfinal,
    hinicial, data_inicial, data_final, pernoites;

    String id, data_, motorista_, veiculo_, placa_, km_saida, km_final, h_final, h_inicial,
            Data_inicial, Data_final, pernoites_;

    Button botao_atualizar;
    Button BotaoExluir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_dados);

        data = findViewById(R.id.DataOT2);
        motorista = findViewById(R.id.MotoristaEdit2);
        veiculo = findViewById(R.id.veiculoEdit2);
        placa = findViewById(R.id.placaEdit2);
        kmsaida = findViewById(R.id.KmSaidaEdit2);
        kmfinal = findViewById(R.id.KmFinalEdit2);
        hfinal = findViewById(R.id.HoraFinalEdit2);
        hinicial = findViewById(R.id.HoraInicialEdit2);
        data_inicial = findViewById(R.id.DataHI2);
        data_final = findViewById(R.id.DataHF2);
        pernoites = findViewById(R.id.PernoitesEdit2);

        botao_atualizar = findViewById(R.id.botaoatualizar);
        BotaoExluir = findViewById(R.id.botaoexcluir);

        getAndSetIntentData();

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(motorista_);
        }
        botao_atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBase DB = new DataBase(AtualizarDados.this);
                data_ = data.getText().toString().trim();
                motorista_ = motorista.getText().toString().trim();
                veiculo_ = veiculo.getText().toString().trim();
                placa_ = placa.getText().toString().trim();
                km_saida = kmsaida.getText().toString().trim();
                km_final = kmfinal.getText().toString().trim();
                Data_inicial = data_inicial.getText().toString().trim();
                Data_final = data_final.getText().toString().trim();
                h_final = hfinal.getText().toString().trim();
                h_inicial = hinicial.getText().toString().trim();
                pernoites_ = pernoites.getText().toString().trim();

                DB.atualizarDados(id, data_, motorista_, veiculo_ ,placa_, km_saida, km_final, Data_inicial, Data_final,
                        h_final, h_inicial, pernoites_);
            }
        });

        BotaoExluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }
        });
    }

    void getAndSetIntentData(){
        if (getIntent().hasExtra("id") &&
                getIntent().hasExtra("data")&&
                getIntent().hasExtra("motorista")&&
                getIntent().hasExtra("veiculo") &&
                getIntent().hasExtra("placa")&&
                getIntent().hasExtra("kmsaida")&&
                getIntent().hasExtra("kmfinal") &&
                getIntent().hasExtra("datainicial")&&
                getIntent().hasExtra("datafinal")&&
                getIntent().hasExtra("horainicial") &&
                getIntent().hasExtra("horafinal") &&
                getIntent().hasExtra("pernoites")){

            //pegando os dados da tela
            id = getIntent().getStringExtra("id");
            data_ = getIntent().getStringExtra("data");
            motorista_ = getIntent().getStringExtra("motorista");
            veiculo_ = getIntent().getStringExtra("veiculo");
            placa_ = getIntent().getStringExtra("placa");
            Data_inicial = getIntent().getStringExtra("datainicial");
            Data_final = getIntent().getStringExtra("datafinal");
            km_final = getIntent().getStringExtra("kmfinal");
            km_saida = getIntent().getStringExtra("kmsaida");
            h_final = getIntent().getStringExtra("horafinal");
            h_inicial = getIntent().getStringExtra("horainicial");
            pernoites_ = getIntent().getStringExtra("pernoites");

            data.setText(data_);
            motorista.setText(motorista_);
            veiculo.setText(veiculo_);
            placa.setText(placa_);
            data_inicial.setText(Data_inicial);
            data_final.setText(Data_final);
            kmfinal.setText(km_final);
            kmsaida.setText(km_saida);
            hfinal.setText(h_final);
            hinicial.setText(h_inicial);
            pernoites.setText(pernoites_);

        }else {
            Toast.makeText(this, "Não Há dados", Toast.LENGTH_SHORT).show();
        }
    }
    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("deletar a ordem de transporte N " + id + " ?");
        builder.setMessage("Tem certeza que deseja deletar " + id + " ?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DataBase db = new DataBase(AtualizarDados.this);
                db.DeletarDados(id);
            }
        });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }
}