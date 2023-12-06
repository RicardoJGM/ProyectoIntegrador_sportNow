package com.example.sportsnow

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class EventRegisterActivity : AppCompatActivity() {
    private lateinit var etNewEventName : EditText
    private lateinit var etNewStartDate : EditText
    private lateinit var etNewEndDate : EditText
    private lateinit var etNewStartTime : EditText
    private lateinit var etNewEndTime : EditText

    private lateinit var spMunicipio : Spinner

    private lateinit var etNewEventAddress : EditText
    private lateinit var etNewEventDesc : EditText
    private lateinit var etNewEventSponsors : EditText
    private lateinit var etNewEventParticipants : EditText

    private lateinit var btNewEventCancel : Button
    private lateinit var btNewEventSave : Button

    private lateinit var rbSocialEvent : RadioButton
    private lateinit var rbCaridad : RadioButton
    private lateinit var rbCompetition : RadioButton
    private lateinit var rbPrivateEvent : RadioButton
    private lateinit var rbBaseball : RadioButton
    private lateinit var rbSoccer : RadioButton
    private lateinit var rbSwimming : RadioButton
    private lateinit var rbBasketball : RadioButton

    private lateinit var ibNewEventImage : ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_evento)

        etNewEventName = findViewById(R.id.etNewEventName)
        etNewStartDate = findViewById(R.id.etNewStartDate)
        etNewEndDate = findViewById(R.id.etNewEndDate)
        etNewStartTime = findViewById(R.id.etNewStartTime)
        etNewEndTime = findViewById(R.id.etNewEndTime)

        spMunicipio = findViewById(R.id.spMunicipio)

        etNewEventAddress = findViewById(R.id.etNewEventAddress)
        etNewEventDesc = findViewById(R.id.etNewEventDesc)
        etNewEventSponsors = findViewById(R.id.etNewEventSponsors)
        etNewEventParticipants = findViewById(R.id.etNewEventParticipants)

        rbSocialEvent = findViewById(R.id.rbSocialEvent)
        rbCaridad = findViewById(R.id.rbCaridad)
        rbCompetition = findViewById(R.id.rbCompetition)
        rbPrivateEvent = findViewById(R.id.rbPrivateEvent)
        rbSoccer = findViewById(R.id.rbSoccer)
        rbBaseball = findViewById(R.id.rbBaseball)
        rbSwimming = findViewById(R.id.rbSwimming)
        rbBasketball = findViewById(R.id.rbBasketball)

        ibNewEventImage = findViewById(R.id.ibNewEventImage)

        btNewEventSave = findViewById(R.id.btNewEventSave)
        btNewEventCancel = findViewById(R.id.btNewEventCancel)

        // Configurar el adaptador para el Spinner
        val municipiosArray = resources.getStringArray(R.array.municipios_array)
        val municipiosAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, municipiosArray)
        municipiosAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spMunicipio.adapter = municipiosAdapter

        llenarMunicipios();

        btNewEventSave.setOnClickListener {
           val intent = Intent(this, EventDetailsActivity::class.java)
            startActivity(intent)

            guardar();
        }

        btNewEventCancel.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun guardar() {
        val NewEventName = etNewEventName
        val NewStartDate = etNewEndDate
        val NewEndDate = etNewEndDate
        val NewStartTime = etNewStartTime
        val NewEndTime = etNewEndTime
        val NewEventAddress = etNewEventAddress
        val NewEventDesc = etNewEventDesc
        val NewEventSponsors = etNewEventSponsors
        val NewEventParticipants = etNewEventParticipants
        val municipioSeleccionado = spMunicipio.selectedItem.toString()
    }

    private fun llenarMunicipios(){
        val requestQueue = Volley.newRequestQueue(this)
        val url : String = "http://192.168.1.161/sportnow/llenarMunicipios.php"

        val request : JsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            Response.Listener { response ->
                procesarRespuesta(response)
            },
            Response.ErrorListener { error ->
                Toast.makeText(this, "Error: $error", Toast.LENGTH_SHORT).show()
                //Log.i("MainActivity.consultarVideojuego()", error.toString())
            })
        requestQueue.add( request )
    }

    private fun procesarRespuesta(response: JSONObject?) {
        if (response != null && response.getBoolean("exito")){
            val lista : JSONArray = response.getJSONArray("lista")
            val datos : ArrayList<String> = ArrayList()

            for (i in 0 until lista.length()){
                val municipio = lista.getJSONObject(i)

                val listaMunicipio = Municipio()

//                listaMunicipio.id_localLocation = municipio.getString("id_localLocation")
//                listaMunicipio.loc_localNumber = municipio.getString("loc_localNumber")
                listaMunicipio.loc_localName = municipio.getString("loc_localName")
//                listaMunicipio.loc_localName = municipio.getString("id_status ")
//                listaMunicipio.status = municipio.getString("estado")

                datos.add( listaMunicipio.loc_localName )
            }
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, datos)

            spMunicipio.adapter = adapter
        }
    }

}