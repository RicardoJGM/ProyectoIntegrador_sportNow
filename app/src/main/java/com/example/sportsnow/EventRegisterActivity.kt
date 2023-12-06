package com.example.sportsnow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class EventRegisterActivity : AppCompatActivity() {
    private lateinit var etNewEventName : EditText
    private lateinit var etNewStartDate : EditText
    private lateinit var etNewEndDate : EditText
    private lateinit var etNewStartTime : EditText
    private lateinit var etNewEndTime : EditText
    private lateinit var spMunicipio : Spinner
    private lateinit var etNewAddress : EditText
    private lateinit var etEventDesc : EditText
    private lateinit var btCancelEventRegister : Button
    private lateinit var btNextEventRegister : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_evento)

        etNewEventName = findViewById(R.id.etNewEventName)
        etNewStartDate = findViewById(R.id.etNewStartDate)
        etNewEndDate = findViewById(R.id.etNewEndDate)
        etNewStartTime = findViewById(R.id.etNewStartTime)
        etNewEndTime = findViewById(R.id.etNewEndTime)
        spMunicipio = findViewById(R.id.spMunicipio)
        etNewAddress = findViewById(R.id.etNewAddress)
        etEventDesc = findViewById(R.id.etEventDesc)
        btNextEventRegister = findViewById(R.id.btNextEventRegister)
        btCancelEventRegister = findViewById(R.id.btCancelEventRegister)

        btNextEventRegister.setOnClickListener {
            val intent = Intent(this, EventRegister2Activity::class.java)
            startActivity(intent)
        }

        btCancelEventRegister.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }


}