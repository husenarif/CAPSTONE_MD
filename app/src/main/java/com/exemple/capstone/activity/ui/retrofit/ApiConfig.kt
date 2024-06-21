package com.exemple.capstone.activity.ui.retrofit

import androidx.media3.common.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.Request


object ApiConfig {

    private const val BASE_URL = "https://spoonful-api-grhskaztba-et.a.run.app"

    fun getApiService(): ApiService {
        // Tambahkan interceptor untuk logging dan header authorization
        val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val authInterceptor = Interceptor { chain ->
            val original = chain.request()
            val requestBuilder: Request.Builder = original.newBuilder()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI5NjlkODc5Yi03MGMxLTQ1M2QtOTcwZC0yOTk2NzM0MjA0NjEiLCJlbWFpbCI6InVwZGF0ZUBleGFtcGxlLmNvbSIsImlhdCI6MTcxODI4OTQxMCwiZXhwIjoxNzE4Mjg5NDQwfQ.PM3fpbBuOLEkPYeRoTCJBnP6L6bLFVs8A4aFCcMucic")

            val request: Request = requestBuilder.build()
            chain.proceed(request)
        }

        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(authInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        return retrofit.create(ApiService::class.java)
    }
}


//class ApiConfig {
//    companion object {
//        fun getApiService(): ApiService {
//            val loggingInterceptor = if (BuildConfig.DEBUG) {
//                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
//            } else {
//                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
//            }
//            val authInterceptor = Interceptor { chain ->
//                val req = chain.request()
//                val requestHeaders = req.newBuilder()
//                    .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI5NjlkODc5Yi03MGMxLTQ1M2QtOTcwZC0yOTk2NzM0MjA0NjEiLCJlbWFpbCI6InVwZGF0ZUBleGFtcGxlLmNvbSIsImlhdCI6MTcxODI4OTQxMCwiZXhwIjoxNzE4Mjg5NDQwfQ.PM3fpbBuOLEkPYeRoTCJBnP6L6bLFVs8A4aFCcMucic")
//                    .build()
//                chain.proceed(requestHeaders)
//            }
//            val client = OkHttpClient.Builder()
//                .addInterceptor(loggingInterceptor)
//                .addInterceptor(authInterceptor)
//                .build()
//            val retrofit = Retrofit.Builder()
//                .baseUrl("https://spoonful-api-grhskaztba-et.a.run.app")
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(client)
//                .build()
//            return retrofit.create(ApiService::class.java)
//        }
//    }
//}

//
//object ApiConfig {
//
//    private const val BASE_URL = "https://spoonful-api-grhskaztba-et.a.run.app/"
//
//
//    // Create an interceptor to add the JWT token to the request headers
//    private val authInterceptor = Interceptor { chain ->
//        val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI5NjlkODc5Yi03MGMxLTQ1M2QtOTcwZC0yOTk2NzM0MjA0NjEiLCJlbWFpbCI6InVwZGF0ZUBleGFtcGxlLmNvbSIsImlhdCI6MTcxODI4OTQxMCwiZXhwIjoxNzE4Mjg5NDQwfQ.PM3fpbBuOLEkPYeRoTCJBnP6L6bLFVs8A4aFCcMucic"
//        val newRequest: Request = chain.request().newBuilder()
//            .addHeader("Authorization", "Bearer $token")
//            .build()
//        chain.proceed(newRequest)
//    }
//
//    // Create an OkHttpClient to add the interceptor
//    private val client = OkHttpClient.Builder()
//        .addInterceptor(authInterceptor)
//        .addInterceptor(HttpLoggingInterceptor().apply {
//            level = HttpLoggingInterceptor.Level.BODY
//        })
//        .connectTimeout(30, TimeUnit.SECONDS)
//        .readTimeout(30, TimeUnit.SECONDS)
//        .build()
//
//    // Create a Retrofit instance
//    private val retrofit = Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .client(client)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    // Provide the ApiService instance
//    fun <T> create(service: Class<T>): T {
//        return retrofit.create(service)
//    }
//}