package com.example.sportsnow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_usuario)

        val etNombreUsuario : EditText =  findViewById(R.id.etNombreUsuarioRegistro)
        val etApellidoP : EditText = findViewById(R.id.etApellidoPaternoRegistro)
        val etApellidoM : EditText = findViewById(R.id.etApellidoMaternoRegistro)
        val etEmail : EditText = findViewById(R.id.etEmailRegistro)
        val etPassword : EditText = findViewById(R.id.etPasswordRegistro)
        val etConfirmPassword : EditText = findViewById(R.id.etConfirmPasswordRegistro)
        val etDate : EditText = findViewById(R.id.etDateRegistro)
        val btCancel : Button = findViewById(R.id.btCancelRegister)
        val btSave : Button = findViewById(R.id.btSaveRegister)

        btCancel.setOnClickListener {
            finish()
            val intent = Intent(this, InicioActivity::class.java)
            startActivity(intent)
        }
        btSave.setOnClickListener {
            val intent = Intent(this, InicioActivity::class.java)
            startActivity(intent)
        }

    }
}