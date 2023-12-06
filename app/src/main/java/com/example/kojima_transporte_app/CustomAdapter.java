package com.example.kojima_transporte_app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kojima_transporte_app.model.AtualizarDados;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    Context context;
    Activity activity;
    ArrayList id, motorista, veiculo, data;

    CustomAdapter(Activity activity,Context context,
                  ArrayList id,
                  ArrayList motorista,
                  ArrayList veiculo,
                  ArrayList data){
        this.activity = activity;
        this.context = context;
        this.id = id;
        this.veiculo = veiculo;
        this.motorista = motorista;
        this.data = data;
    }
    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.id.setText(String.valueOf(id.get(position)));
        holder.motorista.setText(String.valueOf(motorista.get(position)));
        holder.veiculo.setText(String.valueOf(veiculo.get(position)));
        holder.data.setText(String.valueOf(data.get(position)));
        holder.cardOrdem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AtualizarDados.class);
                intent.putExtra("id", String.valueOf(id.get(position)));
                intent.putExtra("motorista", String.valueOf(motorista.get(position)));
                intent.putExtra("veiculo", String.valueOf(veiculo.get(position)));
                intent.putExtra("data", String.valueOf(data.get(position)));
                activity.startActivityForResult(intent,1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id, motorista, veiculo, data;
        CardView cardOrdem;
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            id = itemView.findViewById(R.id.txt_id);
            motorista = itemView.findViewById(R.id.txt_Motorista);
            veiculo = itemView.findViewById(R.id.txt_veiculo);
            data = itemView.findViewById(R.id.txt_data);
            cardOrdem = itemView.findViewById(R.id.cardOrdem);
        }
    }
}
