package com.example.sportsnow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {
    lateinit var etNombreUsuario : EditText
    lateinit var etApellidoP : EditText
    lateinit var etApellidoM : EditText
    lateinit var etEmail : EditText
    lateinit var etPassword : EditText
    lateinit var etConfirmPassword : EditText
    lateinit var etDate : EditText
    lateinit var btCancel : Button
    lateinit var btSave : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_usuario)

        etNombreUsuario         = findViewById(R.id.etNombreUsuarioRegistro)
        etApellidoP             = findViewById(R.id.etApellidoPaternoRegistro)
        etApellidoM             = findViewById(R.id.etApellidoMaternoRegistro)
        etEmail                 = findViewById(R.id.etEmailRegistro)
        etPassword              = findViewById(R.id.etPasswordRegistro)
        etConfirmPassword       = findViewById(R.id.etConfirmPasswordRegistro)
        etDate                  = findViewById(R.id.etDateRegistro)
        btCancel                = findViewById(R.id.btCancelRegister)
        btSave                  = findViewById(R.id.btSaveRegister)

        btCancel.setOnClickListener {
            finish()
            val intent = Intent(this, InicioActivity::class.java)
            startActivity(intent)
        }
        btSave.setOnClickListener {
            registrarUsuario()
            finish()
            val intent = Intent(this, InicioActivity::class.java)
            startActivity(intent)
        }
    }

    private fun registrarUsuario() {
        val nomUsuario          = etNombreUsuario.text
        val etApellidoP         = etApellidoP.text
        val etApellidoM         = etApellidoM.text
        val etEmail             = etEmail.text
        val etPassword          = etPassword.text
        val etConfirmPassword   = etConfirmPassword.text
        val etDate              = etDate.text

//        Log.i("RegisterActivity.registrarUsuario", nomUsuario.toString())
//        Log.i("RegisterActivity", etApellidoP.toString())
//        Log.i("RegisterActivity", etApellidoM.toString())
//        Log.i("RegisterActivity", etEmail.toString())
//        Log.i("RegisterActivity", etPassword.toString())
//        Log.i("RegisterActivity", etConfirmPassword.toString())
//        Log.i("RegisterActivity", etDate.toString())

    }
}