package com.example.storagetest.model.local.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Account")
data class Entities(
    @PrimaryKey(autoGenerate = true) val id: Int = 1,
    val userName: String,
    val domain: String,
    val creationDate: String
)
