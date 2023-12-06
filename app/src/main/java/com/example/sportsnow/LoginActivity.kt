package com.example.sportsnow

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth

class LoginActivity : AppCompatActivity() {
    lateinit var mAuth : FirebaseAuth
    lateinit var auth : FirebaseAuth
    lateinit var etEmailLogin       : EditText
    lateinit var etPasswordLogin    : EditText
    lateinit var btIngresar         : Button
    lateinit var btResPassword      : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etEmailLogin        = findViewById(R.id.etEmailLogin)
        etPasswordLogin     = findViewById(R.id.etPasswordLogin)
        btIngresar          = findViewById(R.id.btIngresar)
        btResPassword       = findViewById(R.id.btResPassword)

        mAuth   = FirebaseAuth.getInstance()
        auth    = Firebase.auth

        btIngresar.setOnClickListener{
            if(etEmailLogin.text.isNotEmpty()) {
                if(etPasswordLogin.text.isNotEmpty() && etPasswordLogin.text.length >= 6) {
                    val email: String = etEmailLogin.text.toString()
                    val password: String = etPasswordLogin.text.toString()

                    iniciarSesion(email, password)
                } else {
                    showAlert("Error", "La contraseña debe ser mayor a 8 caracteres.", this)
                }
            }
        }

        btResPassword.setOnClickListener{
            val intent = Intent(this, ResetPasswordActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun iniciarSesion(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user)
                    if (user != null) {
                        Log.i("LoginActivity", user.uid)
                    }
                } else {
                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                    updateUI(null)
                }
            }
    }
    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            // El usuario está autenticado, inicia MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Opcional: finaliza la actividad actual si ya no la necesitas
        } else {
            // El usuario no está autenticado, realiza alguna acción según tus necesidades
            showAlert("Error de Autenticación", "Usuario o contraseña incorrectos. Por favor, inténtalo de nuevo.",this)
        }
    }
    fun showAlert(title: String, message: String, context: Context) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("Aceptar", null)
        val dialog = builder.create()
        dialog.show()
    }
}