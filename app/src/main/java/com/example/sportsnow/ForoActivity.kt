package com.example.sportsnow

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage

class ForoActivity : AppCompatActivity() {
    private lateinit var adapter : MensajeAdapter
    private lateinit var db : DatabaseReference
    private lateinit var storage : FirebaseStorage
    private lateinit var mAuth : FirebaseAuth
    private lateinit var userEmail : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foro)

        val rvMensajes : RecyclerView = findViewById(R.id.rvMensajes)
        adapter = MensajeAdapter()
        rvMensajes.adapter = adapter

        rvMensajes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        (rvMensajes.layoutManager as LinearLayoutManager).stackFromEnd = true

        adapter.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver(){
            override fun onChanged() {
                super.onChanged()
                rvMensajes.scrollToPosition(adapter.itemCount - 1)
            }
        })
        val ibEnviar : ImageButton = findViewById(R.id.ibMensajeEnviar)

        ibEnviar.setOnClickListener(){
            enviarMensaje()
        }

        val firebaseDataBase = FirebaseDatabase.getInstance("https://firechat-3ed29-default-rtdb.firebaseio.com/")

        db = firebaseDataBase.getReference("chat")

        db.addChildEventListener( object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val mensaje = snapshot.getValue( Mensaje::class.java )

                if(mensaje != null){
                    adapter.add( mensaje )
                }
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                TODO("Not yet implemented")
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
        storage = FirebaseStorage.getInstance()

        val seleccionar = registerForActivityResult(ActivityResultContracts.GetContent(), ActivityResultCallback {
            guardarImagen(it)
        })

        val ibImagenEnviar : ImageButton = findViewById(R.id.ibImagenEnviar)
        ibImagenEnviar.setOnClickListener{
            seleccionar.launch("image/*")
        }
    }

    private fun guardarImagen(it: Uri?) {

        val file = storage.getReference().child("images/" + it?.lastPathSegment )

        if(it != null) {
            file.putFile(it).addOnCompleteListener {
                //se ejecuta cuando la carga/upload del archivo ha terminado
                file.downloadUrl.addOnCompleteListener { uri ->
                    val url : String = uri.result.toString()

                    val mensaje = Mensaje()

                    mensaje.usuario = userEmail
                    mensaje.fechaHora = System.currentTimeMillis()
                    mensaje.imagen = url

                    db.push().setValue( mensaje )

                }
            }
        }
    }

    private fun enviarMensaje() {
        val etMensaje : EditText = findViewById(R.id.etMensaje)

        val mensaje : Mensaje = Mensaje()

        mensaje.cuerpo = etMensaje.text.toString().trim()

        if(!mensaje.cuerpo.equals("")){
            mensaje.usuario   = userEmail
            mensaje.fechaHora = System.currentTimeMillis()

            db.push().setValue( mensaje )

            etMensaje.setText("")
        }

    }
}