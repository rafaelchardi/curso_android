package com.curso.androidm.myapplication;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by androidm on 20/05/2015.
 */
public class terremotosDao implements Dao {


    private SQLiteDatabase db;

    public terremotosDao(SQLiteDatabase sqLiteDatabase) {
        this.db = sqLiteDatabase;
    }



    public void insertar(Terremoto terremoto){
// <item>CREATE TABLE [terremoto] ([id] VARCHAR(100)  NULL,[titulo] VARCHAR(100)  NULL,[fecha] DATE  NULL,[latitud] FLOAT  NULL,[logitud] FLOAT  NULL,[magnitud] FLOAT  NULL)</item>
        db.insert("terremoto","titulo",terremoToConteValue(terremoto));


    }

    private ContentValues terremoToConteValue(Terremoto terremoto) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",terremoto.getId());

        return  contentValues;
    }

    ;


}
