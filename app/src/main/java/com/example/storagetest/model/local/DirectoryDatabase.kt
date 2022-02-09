package com.example.storagetest.model.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DirectoryDatabase(
    private val context: Context,
    private val fileName: String,
    private val factory: SQLiteDatabase.CursorFactory? = null,
    private val version: Int //


    ): SQLiteOpenHelper(context, fileName, factory, version) {


    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(
        "CREATE TABLE PersonTable ("+
                "first_name VARCHAR(255),"+
                "last_name  VARCHAR(255),"+
                "email VARCHAR(255),"+
                "phone_number VARCHAR(255));"
        )

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }
}
/**
private static final String WORD_LIST_TABLE_CREATE =
"CREATE TABLE " + WORD_LIST_TABLE + " (" +
KEY_ID + " INTEGER PRIMARY KEY, " +
// will auto-increment if no value passed
KEY_WORD + " TEXT );";
*/