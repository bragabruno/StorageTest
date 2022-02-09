package com.example.storagetest.model.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface Dao {

    @Query("SELECT * FROM ACCOUNT")
    fun getData(): List<Entities>

    @Insert(entity = Entities::class)
    fun insertData(data: Entities)
}