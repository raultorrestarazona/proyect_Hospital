package com.example.proyecthospital.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlOpenHelper extends SQLiteOpenHelper {

    public SqlOpenHelper(Context contexto){
        super(contexto,"ProyectDAM.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table tb_usuario("+
                    "cod integer primary key autoincrement,"+
                    "usuario varchar(30),"+
                    "pass varchar(30),"+
                    "nombre varchar(30),"+
                    "ape varchar(30),"+
                    "tlf int(9),"+
                    "corr varchar(30),"+
                    "dni int(8))");

        db.execSQL("insert into tb_usuario values(null,'raul','raul','Jose','Meza Ortiz',999999999,'jmezaor@gmail.com',98745612)");
        db.execSQL("insert into tb_usuario values(null,'marcos','marcos','Marcos','Ortiz Vega',999999998,'mortizveg@gmail.com',12346789)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
