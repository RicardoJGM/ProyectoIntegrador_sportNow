package com.example.sportsnow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etEmailLogin : EditText = findViewById(R.id.etEmailLogin)
        val etPasswordLogin : EditText = findViewById(R.id.etPasswordLogin)
        val btIngresar : Button = findViewById(R.id.btIngresar)
        val btResPassword : Button = findViewById(R.id.btResPassword)


    }
}