package com.example.storagetest.model.local

data class PersonTable(
    val firstname: String,
    val lastname: String,
    val email: String,
    val phonenumber: String,
)

object PersonSchema{
    const val FIRSTNAME = "first_name"
    const val LASTNAME = "last_name"
    const val EMAIL = "email"
    const val PHONE_NUMBER = "phone_number"

}