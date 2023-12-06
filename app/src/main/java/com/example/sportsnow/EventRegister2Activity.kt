package com.example.sportsnow

import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class EventRegister2Activity : AppCompatActivity() {
    private lateinit var etSponsors : EditText
    private lateinit var rbSocial : RadioButton
    private lateinit var rbCharitable : RadioButton
    private lateinit var rbCompetition : RadioButton
    private lateinit var rbPrivate : RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_evento_2)

        etSponsors = findViewById(R.id.etSponsors)
        rbSocial = findViewById(R.id.rbSocial)
        rbCharitable = findViewById(R.id.rbCharitable)
        rbCompetition = findViewById(R.id.rbCompetition)
        rbPrivate = findViewById(R.id.rbPrivateEvent)
    }


}