package com.example.sportsnow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth




class ResetPasswordActivity : AppCompatActivity(){
    lateinit var etCorreoExistente : EditText
    lateinit var btReset : Button
    lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restablecer_contrasenia)

        auth = FirebaseAuth.getInstance();

        etCorreoExistente   = findViewById(R.id.etCorreoExistente)
        btReset             = findViewById(R.id.btReset)

        btReset.setOnClickListener{
            reestablecer(etCorreoExistente.text.toString().trim())
        }
    }

    private fun reestablecer(email: String) {
        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Se ha enviado un correo electrónico de restablecimiento de contraseña", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, InicioActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                     val error = task.exception
                     Toast.makeText(this, "Error: $error", Toast.LENGTH_SHORT).show()
                }
            }
    }


}