package com.example.capstone.activity.ui.main


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.exemple.capstone.activity.ui.main.MainActivity
import com.exemple.capstone.activity.ui.main.RegisterActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.exemple.capstone.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

//
//class LoginActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityLoginBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityLoginBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        btn_login.setOnClickListener {
//            val email = binding.email.text.toString().trim()
//            val password = binding.password.text.toString().trim()
//
//            if (email.isNotEmpty() && password.isNotEmpty()) {
//                loginUser(email, password)
//            } else {
//                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        binding.tvSignup.setOnClickListener {
//            startActivity(Intent(this, RegisterActivity::class.java))
//        }
//    }
//
//    private fun loginUser(email: String, password: String) {
//        val client = ApiConfig.getApiService().login(LoginRequest(email, password))
//        client.enqueue(object : Callback<LoginResponse> {
//            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
//                if (response.isSuccessful) {
//                    val token = response.body()?.token
//                    if (token != null) {
//                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
//                        intent.putExtra("TOKEN", token)
//                        startActivity(intent)
//                        finish()
//                    }
//                } else {
//                    Toast.makeText(this@LoginActivity, "Login failed", Toast.LENGTH_SHORT).show()
//                }
//            }
//
//            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//                Toast.makeText(this@LoginActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
//            }
//        })
//    }
//}
//
//private fun Int.setOnClickListener(function: () -> Unit) {
//
//}
//
//class LoginActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_login)
//
//        val loginView = findViewById<View>(R.id.login)
//
//        loginView?.let { v ->
//            ViewCompat.setOnApplyWindowInsetsListener(v) { view, insets ->
//                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//                view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//                WindowInsetsCompat.CONSUMED
//            }
//        }
//
//        val emailEditText = findViewById<TextInputEditText>(R.id.email)
//        val passwordEditText = findViewById<TextInputEditText>(R.id.password)
//        val emailInputLayout = findViewById<TextInputLayout>(R.id.email_input_layout)
//        val passwordInputLayout = findViewById<TextInputLayout>(R.id.password_input_layout)
//        val loginButton = findViewById<Button>(R.id.btn_login)
//        val createAccountButton = findViewById<TextView>(R.id.tv_signup) // Create Account button
//
//        loginButton.setOnClickListener {
//            val email = emailEditText.text.toString().trim()
//            val password = passwordEditText.text.toString().trim()
//
//            Log.d("LoginActivity", "Login button clicked")
//            Log.d("LoginActivity", "Email: $email")
//            Log.d("LoginActivity", "Password: $password")
//
//            if (validateLogin(email, password, emailInputLayout, passwordInputLayout)) {
//                Log.d("LoginActivity", "Validation passed")
//                goToMainActivity()
//            } else {
//                Log.d("LoginActivity", "Validation failed")
//            }
//        }
//
//        createAccountButton.setOnClickListener {
//            goToRegisterActivity()
//        }
//    }
//
//    private fun validateLogin(email: String, password: String, emailInputLayout: TextInputLayout, passwordInputLayout: TextInputLayout): Boolean {
//        var isValid = true
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
//    private fun goToMainActivity() {
//        Intent(this, MainActivity::class.java).also {
//            startActivity(it)
//            finish()
//        }
//    }
//
//    private fun goToRegisterActivity() {
//        Intent(this, RegisterActivity::class.java).also {
//            startActivity(it)
//        }
//    }
//}




class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val loginView = findViewById<View>(R.id.login)

        loginView?.let { v ->
            ViewCompat.setOnApplyWindowInsetsListener(v) { view, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                WindowInsetsCompat.CONSUMED
            }
        }

        val emailEditText = findViewById<TextInputEditText>(R.id.email)
        val passwordEditText = findViewById<TextInputEditText>(R.id.password)
        val emailInputLayout = findViewById<TextInputLayout>(R.id.email_input_layout)
        val passwordInputLayout = findViewById<TextInputLayout>(R.id.password_input_layout)
        val loginButton = findViewById<Button>(R.id.btn_login)
        val createAccountTextView = findViewById<TextView>(R.id.tv_signup)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            Log.d("LoginActivity", "Login button clicked")
            Log.d("LoginActivity", "Email: $email")
            Log.d("LoginActivity", "Password: $password")

            if (validateLogin(email, password, emailInputLayout, passwordInputLayout)) {
                Log.d("LoginActivity", "Validation passed")
                goToMainActivity()
            } else {
                Log.d("LoginActivity", "Validation failed")
            }
        }

        createAccountTextView.setOnClickListener {
            goToRegisterActivity()
        }
    }

    private fun validateLogin(email: String, password: String, emailInputLayout: TextInputLayout, passwordInputLayout: TextInputLayout): Boolean {
        var isValid = true

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

    private fun goToMainActivity() {
        Intent(this, MainActivity::class.java).also {
            startActivity(it)
            finish()
        }
    }

    private fun goToRegisterActivity() {
        Intent(this, RegisterActivity::class.java).also {
            startActivity(it)
        }
    }
}