package com.example.sportsnow

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var rvEventos : RecyclerView
    lateinit var adapter : EventoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvEventos = findViewById(R.id.rvEventos)
        val fabNuevoEvento : FloatingActionButton = findViewById(R.id.fabNuevoEvento)

        adapter = EventoAdapter(this)

        rvEventos.adapter = adapter

        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvEventos.layoutManager = linearLayoutManager

        /*
        if( usuario esta verificado){
            fabNuevoEvento.visibility = View.VISIBLE
        } else {
            fabNuevoEvento.visibility = View.GONE
        }
         */

        fabNuevoEvento.setOnClickListener {
            val intent = Intent(this, EventRegisterActivity::class.java)
            startActivity(intent)
        }


    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_main_menu, menu)
        // Obtén la referencia al MenuItem que deseas cambiar
        val signOutMenuItem = menu.findItem(R.id.opc_signout)

        // Obtén el texto actual del MenuItem
        val signOutMenuItemTitle = signOutMenuItem.title.toString()

        // Crea una SpannableString y aplícale un ForegroundColorSpan
        val spannable = SpannableString(signOutMenuItemTitle)
        spannable.setSpan(
            ForegroundColorSpan(Color.RED), // Cambia esto al color que desees
            0,
            signOutMenuItemTitle.length,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )

        // Establece la SpannableString como el título del MenuItem
        signOutMenuItem.title = spannable
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.opc_filtrar -> {
                val dialogFragment = FiltrosDialogFragment()
                dialogFragment.show(supportFragmentManager, "filtrar_eventos")
            }
            R.id.opc_usuario -> {
                val intent = Intent(this, UserDetailsActivity::class.java)
                startActivity(intent)
            }
            R.id.opc_signout -> {
                //cerrar sesion
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onStart() {
        super.onStart()
        listarEventos()
    }
    private fun listarEventos(){
        val requestQueue = Volley.newRequestQueue(this)
        val url : String = "http://192.168.1.161/sportnow/listarEventos.php"

        val request : JsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            Response.Listener { response ->
                llenarListaEventos(response)
            },
            Response.ErrorListener { error ->
                Toast.makeText(this, "Error: $error", Toast.LENGTH_SHORT).show()
                //Log.i("MainActivity.consultarVideojuego()", error.toString())
            })
        requestQueue.add( request )
    }

    private fun llenarListaEventos(response: JSONObject?) {
        if (response != null && response.getBoolean("exito")){
            val lista : JSONArray = response.getJSONArray("lista")
            val datos : ArrayList<Evento> = ArrayList()

            for (i in 0 until lista.length()){
                val evento = lista.getJSONObject(i)

                val listaEventos = Evento()

//                listaMunicipio.id_localLocation = municipio.getString("id_localLocation")
//                listaMunicipio.loc_localNumber = municipio.getString("loc_localNumber")
                listaEventos.nombre = evento.getString("event_id")
                listaEventos.municipio = evento.getString("id_localLocation")
                listaEventos.tipoEvento = evento.getString("id_eventsTP")
//                listaMunicipio.loc_localName = municipio.getString("id_status ")
//                listaMunicipio.status = municipio.getString("estado")

                datos.add( listaEventos )
            }
            adapter.llenar(datos)
        }
    }
}