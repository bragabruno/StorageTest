package com.example.storagetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.storagetest.model.local.DirectoryDatabaseManager
import com.example.storagetest.model.local.PersonTable
import com.example.storagetest.model.local.room.Entities
import com.example.storagetest.model.local.room.RoomDatabaseAccount

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DirectoryDatabaseManager(applicationContext).run{

            insertData(
            PersonTable(
                "Bruno",
                "Braga",
                "some@rmail.com",
                "5555555",

            )
        )
            insertData(
            PersonTable(
                "Bruno",
                "Braga",
                "some@rmail.com",
                "5555555",

            )
        )
            insertData(
            PersonTable(
                "Bruno",
                "Braga",
                "some@rmail.com",
                "5555555",

            )
        )
            val response = getData()
            Log.d(TAG, "onCreate: $response")
        }

        // new Thread(new Runnable(){})
    Thread(Runnable {
        RoomDatabaseAccount.getDatabase(applicationContext).getDao().insertData(
            Entities(
                userName = "BrunoRB",
                domain = "gitHub",
                creationDate = "02/09/2022"
            )
        )
    }).start()

//    Thread(Runnable {
//
//        val response =
//        RoomDatabaseAccount.getDatabase(applicationContext).getDao().getData()
//
//        Log.d(TAG, "onCreate: $response")
//    }).start()
    }
}