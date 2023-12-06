package com.example.sportsnow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.os.Bundle
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

        fabNuevoEvento.setOnClickListener {
            val intent = Intent(this, EventRegisterActivity::class.java)
            startActivity(intent)
        }

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.opc_buscar -> {

            }
        }
        return super.onOptionsItemSelected(item)
    }
}