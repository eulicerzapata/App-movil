package com.example.app_movil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

public class AdministradorSQLite extends SQLiteOpenHelper {

    // Nombre y versión de la base de datos
    private static final String DB_NAME = "Clientes";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "Clientes";
    // Dentro de la clase AdministradorSQLite
    public AdministradorSQLite(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE " + TABLE_NAME + "("
            + "Id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "Nombre TEXT NOT NULL,"
            + "Email TEXT NOT NULL,"
            + "Telefono TEXT NOT NULL, "
            + "Identificacion TEXT NOT NULL,"
            + "contraseña TEXT NOT NULL"
            + ")"
            );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    onCreate(db);
    }
}
