package com.example.kojima_transporte_app;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kojima_transporte_app.model.DataBase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class telaPrincipal extends AppCompatActivity {

    RecyclerView recyclerView;

    DataBase mydb;
    ArrayList<String> id, motorista, veiculo, data;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

        recyclerView = findViewById(R.id.RecyclerView);

        FloatingActionButton Adicionar = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        Adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(telaPrincipal.this, telaTransporte.class));
            }
        });

        mydb = new DataBase(telaPrincipal.this);
        id = new ArrayList<>();
        motorista = new ArrayList<>();
        veiculo = new ArrayList<>();
        data = new ArrayList<>();

        storeDatainArrays();

        customAdapter = new CustomAdapter(telaPrincipal.this,this, id, motorista, veiculo, data);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(telaPrincipal.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            recreate();
        }
    }

    void storeDatainArrays(){
        Cursor cursor = mydb.readAlldata();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "Sem dados", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                id.add(cursor.getString(0));
                motorista.add(cursor.getString(1));
                veiculo.add(cursor.getString(3));
                data.add(cursor.getString(4));
            }
        }
    }

}
