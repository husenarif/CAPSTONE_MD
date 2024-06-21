package com.exemple.capstone.activity.ui.retrofit



data class LoginRequest(
	val email: String,
	val password: String
)

data class LoginResponse(
	val token: String
)


