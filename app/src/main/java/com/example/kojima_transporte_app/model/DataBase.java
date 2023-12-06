package com.example.kojima_transporte_app.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {
    private  Context context;
    private static final String DATABASE_NAME = "OrdemTransporte.db";
    private static final int DATABASE_VERSION = 3;
    private static final String TABLE_NAME = "OrdemDeTransporte";
    private static final String DATA = "DATA";
    private static final String _ID = "_ID";
    private static final String MOTORISTA = "Motorista";
    private static final String VEICULO = "Veiculo";
    private static final String PLACA = "Placa";
    private static final String KM_SAIDA = "KmSaida";
    private static final String KM_FINAL = "KmFinal";
    private static final String HORA_INICIAL = "HoraInicial";
    private static final String HORA_FINAL = "HoraFinal";
    private static final String DATA_INICIAL = "DataInicial";
    private static final String DATA_FINAL = "DataFinal";
    private static final String PERNOITES = "Pernoites";


    public DataBase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MOTORISTA + "  TEXT, " +
                VEICULO + " TEXT, " +
                DATA + " TEXT, " +
                PLACA + " INTEGER, " +
                KM_SAIDA + " INTEGER, " +
                KM_FINAL + " INTEGER, " +
                HORA_FINAL + " INTEGER, " +
                HORA_INICIAL + " INTEGER, " +
                DATA_FINAL + " INTEGER, " +
                DATA_INICIAL + " INTEGER, " +
                PERNOITES + " INTEGER);";
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void AdicionarOrdem(String motorista, String placa, String veiculo, String data, String datainicial,
                               String datafinal, String kmfinal, String kmsaida, String horafinal,
                               String horainicial, String pernoites){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(MOTORISTA, motorista);
        cv.put(VEICULO, veiculo);
        cv.put(PLACA, placa);
        cv.put(DATA, data);
        cv.put(DATA_FINAL, datafinal);
        cv.put(DATA_INICIAL, datainicial);
        cv.put(KM_FINAL, kmfinal);
        cv.put(KM_SAIDA, kmsaida);
        cv.put(HORA_FINAL, horafinal);
        cv.put(HORA_INICIAL, horainicial);
        cv.put(PERNOITES, pernoites);
        long result = db.insert(TABLE_NAME,null, cv);
        if (result == -1){
            Toast.makeText(context, "Falha", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Adicionado com sucesso", Toast.LENGTH_SHORT).show();
        }

    }

    public Cursor readAlldata() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

   public void atualizarDados(String row_id, String motorista, String placa, String veiculo, String data, String datainicial,
                              String datafinal, String kmfinal, String kmsaida, String horafinal,
                              String horainicial, String pernoites){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(MOTORISTA, motorista);
        cv.put(VEICULO, veiculo);
        cv.put(PLACA, placa);
        cv.put(DATA, data);
        cv.put(DATA_FINAL, datafinal);
        cv.put(DATA_INICIAL, datainicial);
        cv.put(KM_FINAL, kmfinal);
        cv.put(KM_SAIDA, kmsaida);
        cv.put(HORA_FINAL, horafinal);
        cv.put(HORA_INICIAL, horainicial);
        cv.put(PERNOITES, pernoites);

        long result = db.update(TABLE_NAME,cv,"_ID=?", new String[]{row_id});
        if (result == -1){
            Toast.makeText(context, "Ordem de transporte não atualizada", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Ordem de transporte atualizada", Toast.LENGTH_SHORT).show();
        }
    }

    void DeletarDados(String row_id){
        SQLiteDatabase Db = this.getWritableDatabase();
        long result = Db.delete(TABLE_NAME,"_ID=?", new String[]{row_id});
        if (result == -1){
            Toast.makeText(context, "Falha ao deletar", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Ordem de transporte deletada", Toast.LENGTH_SHORT).show();
        }
    }

}
