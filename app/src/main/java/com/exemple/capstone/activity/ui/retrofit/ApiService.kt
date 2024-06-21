package com.exemple.capstone.activity.ui.retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST("user/")
    fun register(@Body request: RegisterRequest): Call<RegisterResponse>

    @POST("login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @GET("user/profile")
    fun getUserProfile(): Call<UserProfile>

    @GET("recommend/place")
    fun getRestaurant(@Query("food") food: String): Call<RestaurantResponse>
}





//interface ApiService {
//
//    @POST("user/") //
//    fun register(@Body request: RegisterRequest): Call<RegisterResponse>
//
//
//    @POST("login")
//    fun login(@Body request: LoginRequest): Call<LoginResponse>
//
//    @GET("user/profile")
//    fun getUserProfile(): Call<UserProfile>
//
//    @GET("recommend/place")
//    fun getRestaurant(FOODIES: String): Call<RestaurantResponse>
//
//}

//interface ApiService {
//
//    @POST("auth/register")
//    fun register(@Body request: RegisterRequest): Call<RegisterResponse>
//
//    @POST("auth/login")
//    fun login(@Body request: LoginRequest): Call<LoginResponse>
//
//    // Other endpoints...
//}

//
//data class RegisterRequest(
//    val email: String,
//    val password: String,
//    val name: String
//)
//
//data class RegisterResponse(
//    val userId: String,
//    val email: String
//)
//
//data class LoginRequest(
//    val email: String,
//    val password: String
//)
//
//data class LoginResponse(
//    val token: String
//)
//
//interface ApiService {
//    @POST("auth/register")
//    fun register(@Body request: RegisterRequest): Call<RegisterResponse>
//
//    @POST("auth/login")
//    fun login(@Body request: LoginRequest): Call<LoginResponse>
//}

