package com.example.sportsnow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

class MensajeAdapter : RecyclerView.Adapter<MensajeVH> {
    private lateinit var datos: ArrayList<Mensaje>

    constructor() {
        datos = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MensajeVH {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.mensaje_fila, parent, false)

        return MensajeVH(view)
    }

    override fun getItemCount(): Int {
        return datos.size
    }

    override fun onBindViewHolder(holder: MensajeVH, position: Int) {
        val mensaje = datos.get(position)

        val simpleDateFormat = SimpleDateFormat("d MMM, hh:mm a", Locale("ES"))
        simpleDateFormat.timeZone = TimeZone.getTimeZone("America/Mexico_City")
        val fechaHora = simpleDateFormat.format(Timestamp(mensaje.fechaHora))

        holder.tvFechaHora.setText(fechaHora)
        holder.tvNombre.text = mensaje.usuario

        if (mensaje.imagen.isEmpty()) {
            holder.tvMensaje.text = mensaje.cuerpo
        } else {
            Picasso.get().load(mensaje.imagen).into(holder.ivImagenMensaje)
            holder.ivImagenMensaje.visibility = View.VISIBLE
            holder.tvMensaje.visibility = View.GONE

        }


    }

    fun add(mensaje: Mensaje) {
        datos.add(mensaje)
        this.notifyDataSetChanged()
    }
}