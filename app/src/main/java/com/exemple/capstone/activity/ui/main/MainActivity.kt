package com.exemple.capstone.activity.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.exemple.capstone.R
import com.exemple.capstone.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView



//class MainActivity : AppCompatActivity() {

//    private lateinit var binding: ActivityMainBinding
//    private lateinit var apiService: ApiService
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        apiService = ApiConfig.getApiService(ApiService::class.java)
//
//        // Example usage of login endpoint
//        val loginRequest = LoginRequest(email = "update@example.com", password = "yourpassword")
//        apiService.login(loginRequest).enqueue(object : Callback<LoginResponse> {
//            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
//                if (response.isSuccessful) {
//                    val loginResponse = response.body()
//                    // Handle successful login response
//                    Toast.makeText(this@MainActivity, "Login successful", Toast.LENGTH_SHORT).show()
//                } else {
//                    // Handle error response
//                    Toast.makeText(this@MainActivity, "Login failed", Toast.LENGTH_SHORT).show()
//                }
//            }
//
//            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//                // Handle failure
//                Toast.makeText(this@MainActivity, "Login error: ${t.message}", Toast.LENGTH_SHORT)
//                    .show()
//            }
//        })
//
//        // Example usage of getUserProfile endpoint
//        apiService.getUserProfile().enqueue(object : Callback<UserProfile> {
//            override fun onResponse(call: Call<UserProfile>, response: Response<UserProfile>) {
//                if (response.isSuccessful) {
//                    val userProfile = response.body()
//                    // Handle successful user profile response
//                    Toast.makeText(
//                        this@MainActivity,
//                        "User: ${userProfile?.name}",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                } else {
//                    // Handle error response
//                    Toast.makeText(this@MainActivity, "Failed to load profile", Toast.LENGTH_SHORT)
//                        .show()
//                }
//            }
//
//            override fun onFailure(call: Call<UserProfile>, t: Throwable) {
//                // Handle failure
//                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
//            }
//        })
//
//        val navView: BottomNavigationView = binding.navView
//        val navController = findNavController(R.id.nav_host_fragment_activity_main)
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home, R.id.navigation_search, R.id.navigation_scan, R.id.navigation_food, R.id.navigation_profil
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
//    }
//}
//
//


    class MainActivity : AppCompatActivity() {

        private lateinit var binding: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)


            val navView: BottomNavigationView = binding.navView
            val navController = findNavController(R.id.nav_host_fragment_activity_main)
            val appBarConfiguration = AppBarConfiguration(
                setOf(
                    R.id.navigation_home,
                    R.id.navigation_search,
                    R.id.navigation_scan,
                    R.id.navigation_food,
                    R.id.navigation_profil
                )
            )
            setupActionBarWithNavController(navController, appBarConfiguration)
            navView.setupWithNavController(navController)
        }
    }



