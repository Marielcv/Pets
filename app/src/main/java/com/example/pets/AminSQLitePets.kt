package com.example.pets

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AdminSQLitePets
    (context: Context?,
     name:String?,
     factory:SQLiteDatabase.CursorFactory?,
     version:Int):SQLiteOpenHelper(context,name,factory,version) {
    override fun onCreate(baseDeDatos: SQLiteDatabase?) {
        baseDeDatos?.execSQL("create table Pets" +
                "(codigo int primary key, Especie text,sexo, Habitada)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

}