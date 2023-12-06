package com.example.sportsnow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class UserDetailsActivity : AppCompatActivity() {
    private lateinit var etUsername : EditText
    private lateinit var etNombre : EditText
    private lateinit var etApellidoP : EditText
    private lateinit var etApellidoM : EditText
    private lateinit var etEmail : EditText
    private lateinit var etDate : EditText
    private lateinit var ivFoto : ImageView
    private lateinit var btGuardar : Button
    private lateinit var btCancelar : Button
    private lateinit var btVerificarUsuario : Button
    private lateinit var fabEditar : FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles_usuario)

        etUsername = findViewById(R.id.etUsername)
        etNombre = findViewById(R.id.etNombreUsuarioDetalles)
        etApellidoP = findViewById(R.id.etApellidoPUsuarioDetalles)
        etApellidoM = findViewById(R.id.etApellidoMUsuarioDetalles)
        etEmail = findViewById(R.id.etEmailUsuarioDetalles)
        etDate = findViewById(R.id.etDateUsuarioDetalles)
        ivFoto = findViewById(R.id.ivFotoUsuarioDetalles)
        btGuardar = findViewById(R.id.btGuardarCambiosUsuario)
        btCancelar = findViewById(R.id.btCancelarCambiosUsuario)
        btVerificarUsuario = findViewById(R.id.btVerificarUsuario)
        fabEditar = findViewById(R.id.fabEditarUsuario)

        /*
            if(usuario ya esta verificado){
                btVerificarUsuario.visibility = View.GONE
            }
         */

        btCancelar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}