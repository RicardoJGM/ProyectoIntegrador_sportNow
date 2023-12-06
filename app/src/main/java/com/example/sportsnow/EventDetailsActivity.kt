package com.example.sportsnow

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import org.w3c.dom.Text

class EventDetailsActivity : AppCompatActivity() {
    private lateinit var context: Context

    private lateinit var tvNombreEventoDetalles : TextView
    private lateinit var tvLabelsEventoDetalles : TextView
    private lateinit var tvFechaInicioEventoDetalles : TextView
    private lateinit var tvFechaFinEventoDetalles : TextView
    private lateinit var tvDuracionEventoDetalles : TextView
    private lateinit var tvMunicipioEventoDetalles : TextView
    private lateinit var tvDireccionEventoDetalles : TextView
    private lateinit var tvOrganizadorEventoDetalles : TextView
    private lateinit var tvCupoEventoDetalles : TextView
    private lateinit var etDescEventoDetalles : EditText
    private lateinit var btParticiparEvento : Button
    private lateinit var btEliminarEvento : Button
    private lateinit var btEditarEvento : Button
    private lateinit var btCancelarParticipante : Button
    private lateinit var btVerForo : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_details)

        tvNombreEventoDetalles = findViewById(R.id.tvNombreEventoDetalles)
        tvLabelsEventoDetalles = findViewById(R.id.tvLabelsEventoDetalles)
        tvFechaInicioEventoDetalles = findViewById(R.id.tvFechaInicioEventoDetalles)
        tvFechaFinEventoDetalles = findViewById(R.id.tvFechaFinEventoDetalles)
        tvDuracionEventoDetalles = findViewById(R.id.tvDuracionEventoDetalles)
        tvMunicipioEventoDetalles = findViewById(R.id.tvMunicipioEventoDetalles)
        tvDireccionEventoDetalles = findViewById(R.id.tvDireccionEventoDetalles)
        tvOrganizadorEventoDetalles = findViewById(R.id.tvOrganizadorEventoDetalles)
        tvCupoEventoDetalles = findViewById(R.id.tvCupoEventoDetalles)
        etDescEventoDetalles = findViewById(R.id.etDescEventoDetalles)
        btParticiparEvento = findViewById(R.id.btParticiparEvento)
        btEditarEvento = findViewById(R.id.btEditarEvento)
        btEliminarEvento = findViewById(R.id.btEliminarEvento)
        btVerForo = findViewById(R.id.btVerForo)
        btCancelarParticipante = findViewById(R.id.btCancelarParticipante)


        //if( usuario ya esta participando ){
            btParticiparEvento.visibility = View.GONE
            btVerForo.visibility = View.VISIBLE
            btCancelarParticipante.visibility = View.VISIBLE
        //}

        configUI()

        btParticiparEvento.setOnClickListener {

        }

        btVerForo.setOnClickListener {
            val intent = Intent(this, ForoActivity::class.java)
            startActivity(intent)
        }

        btCancelarParticipante.setOnClickListener {

        }

        btEditarEvento.setOnClickListener {
            val intent = Intent(this.context,EventRegisterActivity::class.java)

            //intent.putExtra()


            this.context.startActivity(intent)
        }

        btEliminarEvento.setOnClickListener {

        }
    }

    private fun configUI() {
        if (intent != null) {

            val nombre: String? = intent.getStringExtra("nombre")
            val fechaHoraInicio: String? = intent.getStringExtra("fechaHoraInicio")
            val municipio: String? = intent.getStringExtra("municipio")
            val etiquetas: String? = intent.getStringExtra("etiquetas")

            val nombreEvento: TextView = findViewById(R.id.tvNombreEventoDetalles)
            nombreEvento.setText(nombre)

            val horaInicio: TextView = findViewById(R.id.tvFechaInicioEventoDetalles)
            horaInicio.setText(fechaHoraInicio)

            val ciudad: TextView = findViewById(R.id.tvMunicipioEventoDetalles)
            ciudad.setText(municipio)

            val categorias: TextView = findViewById(R.id.tvLabelsEventoDetalles)
            categorias.setText(etiquetas)

        }
    }
}