package com.example.storagetest.model.local

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class DirectoryDatabaseManager(private val context: Context) {

    private val directoryDB: DirectoryDatabase by lazy {
        DirectoryDatabase(
            context,
            "directory",
            version = 1,
        )
    }
        private val readDB: SQLiteDatabase by lazy {
            directoryDB.readableDatabase
        }
        private val writeDB: SQLiteDatabase by lazy {
            directoryDB.writableDatabase
        }

    fun getData(): List<PersonTable>{
        // execute the Android-way. Using Cursor
        val tableName = "PersonTable"
        val columns = arrayOf(
            PersonSchema.FIRSTNAME,
            PersonSchema.LASTNAME,
            PersonSchema.EMAIL,
            PersonSchema.PHONE_NUMBER
        )

        val where = "${PersonSchema.EMAIL} LIKE ?"
        val search = arrayOf("% input %")
        val cursor =
        readDB.query(
            tableName,
            columns,
            null,
            null,
            null,
            null,
            null
        )
        val listOfPerson = mutableListOf<PersonTable>()
        while (cursor.moveToFirst()){
            val firstName = cursor.getString(
                cursor.getColumnIndexOrThrow(PersonSchema.FIRSTNAME))
            val lastName = cursor.getString(
                cursor.getColumnIndexOrThrow(PersonSchema.LASTNAME))
            val email = cursor.getString(
                cursor.getColumnIndexOrThrow(PersonSchema.EMAIL))
            val phoneNumber = cursor.getString(
                cursor.getColumnIndexOrThrow(PersonSchema.PHONE_NUMBER))
            listOfPerson.add(
                PersonTable(
                    firstName,
                    lastName,
                    email,
                    phoneNumber
                )
            )
        }
            cursor.close()
                return listOfPerson
    }

    fun insertData(person: PersonTable): Boolean{
        val contextValue = ContentValues()
        contextValue.put(PersonSchema.FIRSTNAME, person.firstname)
        contextValue.put(PersonSchema.LASTNAME, person.lastname)
        contextValue.put(PersonSchema.EMAIL, person.email)
        contextValue.put(PersonSchema.PHONE_NUMBER, person.phonenumber)

        val result = writeDB.insertOrThrow("PersonTable", null, contextValue)

//        writeDB.insertWithOnConflict("PersonTable", null, contextValue, SQLiteDatabase.CONFLICT_FAIL)

        return result > 0
    }
}