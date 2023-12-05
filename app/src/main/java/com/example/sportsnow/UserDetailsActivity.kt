package com.example.sportsnow

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class UserDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles_usuario)

        val etUsername : EditText = findViewById(R.id.etUsername)
        val etNombre : EditText = findViewById(R.id.etNombreUsuarioDetalles)
        val etApellidoP : EditText = findViewById(R.id.etApellidoPUsuarioDetalles)
        val etApellidoM : EditText = findViewById(R.id.etApellidoMUsuarioDetalles)
        val etEmail : EditText = findViewById(R.id.etEmailUsuarioDetalles)
        val etDate : EditText = findViewById(R.id.etDateUsuarioDetalles)
        val ivFoto : ImageView = findViewById(R.id.ivFotoUsuarioDetalles)
        val btGuardar : Button = findViewById(R.id.btGuardarCambiosUsuario)
        val btCancelar : Button = findViewById(R.id.btCancelarCambiosUsuario)
        val fabEditar : Button = findViewById(R.id.fabEditarUsuario)
    }
}