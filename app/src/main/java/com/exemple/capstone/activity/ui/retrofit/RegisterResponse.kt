package com.exemple.capstone.activity.ui.retrofit

data class RegisterRequest(
    val email: String,
    val password: String,
    val name: String,
    val weight : Int,
    val age : Int,
    val eatEachDay : Int,
    val foodPreference : String,
    val goal : String
)

data class RegisterResponse(
    val userId: String,
    val email: String
)
