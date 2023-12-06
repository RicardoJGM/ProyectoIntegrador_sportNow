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
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvEventos : RecyclerView = findViewById(R.id.rvEventos)
        val fabNuevoEvento : FloatingActionButton = findViewById(R.id.fabNuevoEvento)

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
}