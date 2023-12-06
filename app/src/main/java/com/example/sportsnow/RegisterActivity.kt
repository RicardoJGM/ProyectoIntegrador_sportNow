package com.example.sportsnow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import org.json.JSONObject

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    private lateinit var mAuth : FirebaseAuth

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

        mAuth = FirebaseAuth.getInstance()
        auth = Firebase.auth

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

        crearUsuario(etEmail.toString(), etPassword.toString())
    }
    private fun crearUsuario(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser

                    if (user != null) {
                        guardar(user.uid)
                    }

                    updateUI(user)
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
        val intent = Intent (this,MainActivity::class.java)
        startActivity(intent)
    }
    private fun guardar(UID : String) {
        val claveUsuario = "usuario1"
        val nombreUsuario = etNombreUsuario.text.toString()
        val apellidoP  = etApellidoP.text.toString()
        val apellidoM  = etApellidoM.text.toString()

        val apellidos = apellidoP + apellidoM

        val idFirebase = UID
        val email      = etEmail.text.toString()
        val password   = etPassword.text.toString()
        val date       = etDate.text.toString()

        val estado       = 1

        val url = "http://192.168.1.161/sportnow/guardar.php"

        enviarDatos(claveUsuario ,nombreUsuario, apellidos, email, date, password, idFirebase, estado, url)
    }
    private fun enviarDatos(
        clave: String,
        nombre: String,
        apellidos: String,
        email: String,
        date: String,
        password: String,
        idFirebase: String,
        estado: Int,
        url: String
    ) {
        val requestQueue = Volley.newRequestQueue(this)

        val mapa = mutableMapOf<String, Any?>()

        mapa.put("clave", clave)
        mapa.put("nombre",nombre)
        mapa.put("apellidos",apellidos)
        mapa.put("email",email)
        mapa.put("date",date)
        mapa.put("password",password)
        mapa.put("idFirebase",idFirebase)
        mapa.put("estado",estado)

        val parametros : JSONObject = JSONObject( mapa )

        val request : JsonObjectRequest = JsonObjectRequest(
            Request.Method.POST,
            url,
            parametros,
            Response.Listener { response ->
                if(response.getBoolean("exito")){
                    Log.e("RegisterActivity", "error")
                    finish()
                }else {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            },
            Response.ErrorListener { error ->
                Log.e("RegisterActivity", "error",error).toString()
            }

        )

        requestQueue.add( request )
    }

}