package com.exemple.capstone.activity.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.capstone.activity.ui.main.LoginActivity
import com.exemple.capstone.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        val registerView = findViewById<View>(R.id.register)

        registerView?.let { v ->
            ViewCompat.setOnApplyWindowInsetsListener(v) { view, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                view.setPadding(
                    systemBars.left,
                    systemBars.top,
                    systemBars.right,
                    systemBars.bottom
                )
                WindowInsetsCompat.CONSUMED
            }
        }

        val nameEditText = findViewById<TextInputEditText>(R.id.name)
        val emailEditText = findViewById<TextInputEditText>(R.id.email)
        val passwordEditText = findViewById<TextInputEditText>(R.id.password)
        val nameInputLayout = findViewById<TextInputLayout>(R.id.name_input_layout)
        val emailInputLayout = findViewById<TextInputLayout>(R.id.email_input_layout)
        val passwordInputLayout = findViewById<TextInputLayout>(R.id.password_input_layout)
        val registerButton = findViewById<Button>(R.id.button4)
        val loginTextView = findViewById<TextView>(R.id.login_text_view)

        // Setup Spinners
        val weightSpinner = findViewById<Spinner>(R.id.spin_weight)
        val ageSpinner = findViewById<Spinner>(R.id.spin_age)
        val dailyMealsSpinner = findViewById<Spinner>(R.id.spin_daily_meals)
        val goalsSpinner = findViewById<Spinner>(R.id.spin_goals)
        val foodPreferenceSpinner = findViewById<Spinner>(R.id.spin_food_preference)

        setupSpinner(weightSpinner, R.array.weight_array)
        setupSpinner(ageSpinner, R.array.age_array)
        setupSpinner(dailyMealsSpinner, R.array.daily_meals_array)
        setupSpinner(goalsSpinner, R.array.goals_array)
        setupSpinner(foodPreferenceSpinner, R.array.food_preference_array)

        registerButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (validateRegister(
                    name,
                    email,
                    password,
                    nameInputLayout,
                    emailInputLayout,
                    passwordInputLayout
                )
            ) {
                // Simpan data pengguna ke database atau preferensi, lalu kembali ke login
                Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show()
                goToLoginActivity()
            }
        }

        loginTextView.setOnClickListener {
            goToLoginActivity()
        }
    }

    private fun setupSpinner(spinner: Spinner, arrayResId: Int) {
        ArrayAdapter.createFromResource(
            this,
            arrayResId,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    private fun validateRegister(
        name: String,
        email: String,
        password: String,
        nameInputLayout: TextInputLayout,
        emailInputLayout: TextInputLayout,
        passwordInputLayout: TextInputLayout
    ): Boolean {
        var isValid = true

        if (name.isEmpty()) {
            nameInputLayout.error = "Name is required"
            isValid = false
        } else {
            nameInputLayout.error = null
        }

        if (email.isEmpty()) {
            emailInputLayout.error = "Email is required"
            isValid = false
        } else if (!isValidEmail(email)) {
            emailInputLayout.error = "Invalid email format"
            isValid = false
        } else {
            emailInputLayout.error = null
        }

        if (password.isEmpty()) {
            passwordInputLayout.error = "Password is required"
            isValid = false
        } else {
            passwordInputLayout.error = null
        }

        return isValid
    }

    private fun isValidEmail(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(Regex(emailPattern))
    }

    private fun goToLoginActivity() {
        Intent(this, LoginActivity::class.java).also {
            startActivity(it)
            finish()
        }
    }
}




//
//class RegisterActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityRegisterBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityRegisterBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.button4.setOnClickListener {
//            val name = binding.name.text.toString().trim()
//            val email = binding.email.text.toString().trim()
//            val password = binding.password.text.toString().trim()
//
//            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
//                registerUser(name, email, password)
//            } else {
//                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        binding.loginTextView.setOnClickListener {
//            startActivity(Intent(this, LoginActivity::class.java))
//        }
//    }
//
//    private fun registerUser(name: String, email: String, password: String) {
//        val client = ApiConfig.getApiService().register(RegisterRequest(email, password, name))
//        client.enqueue(object : Callback<RegisterResponse> {
//            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
//                if (response.isSuccessful) {
//                    Toast.makeText(this@RegisterActivity, "Registration successful", Toast.LENGTH_SHORT).show()
//                    startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
//                    finish()
//                } else {
//                    Toast.makeText(this@RegisterActivity, "Registration failed", Toast.LENGTH_SHORT).show()
//                }
//            }
//
//            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
//                Toast.makeText(this@RegisterActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
//            }
//        })
//    }
//}



//
//class RegisterActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_register)
//
//        val registerView = findViewById<View>(R.id.register)
//
//        registerView?.let { v ->
//            ViewCompat.setOnApplyWindowInsetsListener(v) { view, insets ->
//                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//                view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//                WindowInsetsCompat.CONSUMED
//            }
//        }
//
//        val nameEditText = findViewById<TextInputEditText>(R.id.name)
//        val emailEditText = findViewById<TextInputEditText>(R.id.email)
//        val passwordEditText = findViewById<TextInputEditText>(R.id.password)
//        val nameInputLayout = findViewById<TextInputLayout>(R.id.name_input_layout)
//        val emailInputLayout = findViewById<TextInputLayout>(R.id.email_input_layout)
//        val passwordInputLayout = findViewById<TextInputLayout>(R.id.password_input_layout)
//        val registerButton = findViewById<Button>(R.id.button4)
//        val loginTextView = findViewById<TextView>(R.id.login_text_view)
//
//        // Setup Spinners
//        val weightSpinner = findViewById<Spinner>(R.id.spin_weight)
//        val ageSpinner = findViewById<Spinner>(R.id.spin_age)
//        val dailyMealsSpinner = findViewById<Spinner>(R.id.spin_daily_meals)
//        val goalsSpinner = findViewById<Spinner>(R.id.spin_goals)
//        val foodPreferenceSpinner = findViewById<Spinner>(R.id.spin_food_preference)
//
//        setupSpinner(weightSpinner, R.array.weight_array)
//        setupSpinner(ageSpinner, R.array.age_array)
//        setupSpinner(dailyMealsSpinner, R.array.daily_meals_array)
//        setupSpinner(goalsSpinner, R.array.goals_array)
//        setupSpinner(foodPreferenceSpinner, R.array.food_preference_array)
//
//        registerButton.setOnClickListener {
//            val name = nameEditText.text.toString().trim()
//            val email = emailEditText.text.toString().trim()
//            val password = passwordEditText.text.toString().trim()
//
//            if (validateRegister(name, email, password, nameInputLayout, emailInputLayout, passwordInputLayout)) {
//
//                // Simpan data pengguna ke database atau preferensi, lalu kembali ke login
//                Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show()
//                goToLoginActivity()
//            }
//        }
//
//        loginTextView.setOnClickListener {
//            goToLoginActivity()
//        }
//    }
//
//    private fun setupSpinner(spinner: Spinner, arrayResId: Int) {
//        ArrayAdapter.createFromResource(
//            this,
//            arrayResId,
//            android.R.layout.simple_spinner_item
//        ).also { adapter ->
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            spinner.adapter = adapter
//        }
//    }
//
//    private fun validateRegister(name: String, email: String, password: String, nameInputLayout: TextInputLayout, emailInputLayout: TextInputLayout, passwordInputLayout: TextInputLayout): Boolean {
//        var isValid = true
//
//        if (name.isEmpty()) {
//            nameInputLayout.error = "Name is required"
//            isValid = false
//        } else {
//            nameInputLayout.error = null
//        }
//
//        if (email.isEmpty()) {
//            emailInputLayout.error = "Email is required"
//            isValid = false
//        } else if (!isValidEmail(email)) {
//            emailInputLayout.error = "Invalid email format"
//            isValid = false
//        } else {
//            emailInputLayout.error = null
//        }
//
//        if (password.isEmpty()) {
//            passwordInputLayout.error = "Password is required"
//            isValid = false
//        } else {
//            passwordInputLayout.error = null
//        }
//
//        return isValid
//    }
//
//    private fun isValidEmail(email: String): Boolean {
//        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
//        return email.matches(Regex(emailPattern))
//    }
//
//    private fun goToLoginActivity() {
//        Intent(this, LoginActivity::class.java).also {
//            startActivity(it)
//            finish()
//        }
//    }
//}


//import android.content.Intent
//import android.os.Bundle
//import android.view.View
//import android.widget.*
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//import com.example.capstone.activity.ui.main.LoginActivity
//import com.exemple.capstone.R
//import com.exemple.capstone.activity.ui.retrofit.ApiConfig
//import com.exemple.capstone.activity.ui.retrofit.RegisterRequest
//import com.exemple.capstone.activity.ui.retrofit.RegisterResponse
//import com.google.android.material.textfield.TextInputEditText
//import com.google.android.material.textfield.TextInputLayout
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//
//class RegisterActivity : AppCompatActivity() {
//
//    private lateinit var nameEditText: TextInputEditText
//    private lateinit var emailEditText: TextInputEditText
//    private lateinit var passwordEditText: TextInputEditText
//    private lateinit var nameInputLayout: TextInputLayout
//    private lateinit var emailInputLayout: TextInputLayout
//    private lateinit var passwordInputLayout: TextInputLayout
//    private lateinit var registerButton: Button
//    private lateinit var loginTextView: TextView
//    private lateinit var weightSpinner: Spinner
//    private lateinit var ageSpinner: Spinner
//    private lateinit var dailyMealsSpinner: Spinner
//    private lateinit var goalsSpinner: Spinner
//    private lateinit var foodPreferenceSpinner: Spinner
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge() // Jika Anda memiliki fungsi ini
//        setContentView(R.layout.activity_register)
//
//        val registerView = findViewById<View>(R.id.register)
//
//        binding.button4.setOnClickListener {
//            val name = binding.name.text.toString().trim()
//            val email = binding.email.text.toString().trim()
//            val password = binding.password.text.toString().trim()
//
//            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
//                registerUser(name, email, password)
//            } else {
//                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
//            }
//        }
//        registerView?.let { v ->
//            ViewCompat.setOnApplyWindowInsetsListener(v) { view, insets ->
//                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//                view.setPadding(
//                    systemBars.left,
//                    systemBars.top,
//                    systemBars.right,
//                    systemBars.bottom
//                )
//                WindowInsetsCompat.CONSUMED
//            }
//        }
//
//        nameEditText = findViewById(R.id.name)
//        emailEditText = findViewById(R.id.email)
//        passwordEditText = findViewById(R.id.password)
//        nameInputLayout = findViewById(R.id.name_input_layout)
//        emailInputLayout = findViewById(R.id.email_input_layout)
//        passwordInputLayout = findViewById(R.id.password_input_layout)
//        registerButton = findViewById(R.id.button4)
//        loginTextView = findViewById(R.id.login_text_view)
//
//        weightSpinner = findViewById(R.id.spin_weight)
//        ageSpinner = findViewById(R.id.spin_age)
//        dailyMealsSpinner = findViewById(R.id.spin_daily_meals)
//        goalsSpinner = findViewById(R.id.spin_goals)
//        foodPreferenceSpinner = findViewById(R.id.spin_food_preference)
//
//        setupSpinner(weightSpinner, R.array.weight_array)
//        setupSpinner(ageSpinner, R.array.age_array)
//        setupSpinner(dailyMealsSpinner, R.array.daily_meals_array)
//        setupSpinner(goalsSpinner, R.array.goals_array)
//        setupSpinner(foodPreferenceSpinner, R.array.food_preference_array)
//
//        registerButton.setOnClickListener {
//            val name = nameEditText.text.toString().trim()
//            val email = emailEditText.text.toString().trim()
//            val password = passwordEditText.text.toString().trim()
//
//            if (validateRegister(
//                    name,
//                    email,
//                    password,
//                    nameInputLayout,
//                    emailInputLayout,
//                    passwordInputLayout
//                )
//            ) {
//                val weight = weightSpinner.selectedItem.toString().toIntOrNull() ?: 0
//                val age = ageSpinner.selectedItem.toString().toIntOrNull() ?: 0
//                val eatEachDay = dailyMealsSpinner.selectedItem.toString().toIntOrNull() ?: 0
//                val foodPreference = foodPreferenceSpinner.selectedItem.toString()
//                val goal = goalsSpinner.selectedItem.toString()
//
//                registerUser(email, password, name, weight, age, eatEachDay, foodPreference, goal,
//                    onSuccess = { response ->
//                        Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
//                        goToLoginActivity()
//                    },
//                    onError = { error ->
//                        Toast.makeText(
//                            this,
//                            "Registration failed: ${error.message}",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                )
//            }
//        }
//
//        loginTextView.setOnClickListener {
//            goToLoginActivity()
//        }
//    }
//
//    private fun setupSpinner(spinner: Spinner, arrayResId: Int) {
//        ArrayAdapter.createFromResource(
//            this,
//            arrayResId,
//            android.R.layout.simple_spinner_item
//        ).also { adapter ->
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            spinner.adapter = adapter
//        }
//    }
//
//    private fun validateRegister(
//        name: String,
//        email: String,
//        password: String,
//        nameInputLayout: TextInputLayout,
//        emailInputLayout: TextInputLayout,
//        passwordInputLayout: TextInputLayout
//    ): Boolean {
//        var isValid = true
//
//        if (name.isEmpty()) {
//            nameInputLayout.error = "Name is required"
//            isValid = false
//        } else {
//            nameInputLayout.error = null
//        }
//
//        if (email.isEmpty()) {
//            emailInputLayout.error = "Email is required"
//            isValid = false
//        } else if (!isValidEmail(email)) {
//            emailInputLayout.error = "Invalid email format"
//            isValid = false
//        } else {
//            emailInputLayout.error = null
//        }
//
//        if (password.isEmpty()) {
//            passwordInputLayout.error = "Password is required"
//            isValid = false
//        } else {
//            passwordInputLayout.error = null
//        }
//
//        return isValid
//    }
//
//    private fun isValidEmail(email: String): Boolean {
//        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
//        return email.matches(Regex(emailPattern))
//    }
//
//    private fun goToLoginActivity() {
//        Intent(this, LoginActivity::class.java).also {
//            startActivity(it)
//            finish()
//        }
//    }
//
//    // Fungsi register (import dari tempat Anda mendefinisikannya)
//    private fun registerUser(
//        email: String,
//        password: String,
//        name: String,
//        weight: Int,
//        age: Int,
//        eatEachDay: Int,
//        foodPreference: String,
//        goal: String,
//        onSuccess: (RegisterResponse) -> Unit,
//        onError: (Throwable) -> Unit
//    ) {
//        val request =
//            RegisterRequest(email, password, name, weight, age, eatEachDay, foodPreference, goal)
//
//    }
//}
