package com.example.storagetest.model.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Entities::class],
version = 1)
abstract class RoomDatabaseAccount: RoomDatabase() {

    abstract fun getDao(): Dao

    companion object{
        @Volatile
        private var INSTANCE: RoomDatabaseAccount? = null
        fun getDatabase(context: Context): RoomDatabaseAccount{
            val temp = INSTANCE
            if (temp != null) return temp

            synchronized(this){
                var instance = INSTANCE
                if (instance != null) return instance

                instance = Room.databaseBuilder(
                    context,
                    RoomDatabaseAccount::class.java,
                    "account")
                    //.allowMainThreadQueries() // ==> DON'T use this in Production. <==
                    .build()
                INSTANCE = instance

                return instance
            }
        }
    }
}
