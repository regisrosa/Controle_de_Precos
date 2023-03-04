package com.example.controle_de_precos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MeuDatabase extends SQLiteOpenHelper {
    public MeuDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table Compras (id integer primary key autoincrement, produto varchar(30)" +
                ", estabelecimento varchar(30), preco varchar(10), data varchar(10))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void inserirCompra(String produto, String estabelecimento, double preco, String data){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("produto", produto);
        contentValues.put("estabelecimento", estabelecimento);
        contentValues.put("preco", preco);
        contentValues.put("data", data);

        sqLiteDatabase.insert("Compras", null, contentValues);
    }

    public int removerCompra(int id){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete("Compras", "id = ?", new String[]{String.valueOf(id)});
    }

    public int updateCompra(int id, String produto, String estabelecimento, double preco, String data){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("produto", produto);
        contentValues.put("estabelecimento", estabelecimento);
        contentValues.put("preco", preco);
        contentValues.put("data", data);
        return sqLiteDatabase.update("Compras", contentValues, "id = ?", new String[]{String.valueOf(id)});
    }
}
