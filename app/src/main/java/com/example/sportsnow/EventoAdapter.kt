package com.example.sportsnow

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class EventoAdapter : RecyclerView.Adapter<EventoVH> {
    private lateinit var datos : ArrayList<Evento>
    private lateinit var contexto : Context

    constructor(context: Context) {
        datos = ArrayList()
        contexto = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventoVH {
        val view = LayoutInflater.from( contexto ).inflate(R.layout.fila_evento, parent, false)
        return EventoVH(view)
    }

    override fun getItemCount(): Int {
        return datos.size
    }

    override fun onBindViewHolder(holder: EventoVH, position: Int) {
        val evento : Evento = datos.get(position)

        holder.tvEvento.text = evento.nombre
        holder.tvFecha.text = evento.fechaInicio
        holder.tvMunicipio.text = evento.municipio
        holder.tvOrgainzador.text = evento.organizador
        holder.tvEtiquetas.text = evento.tipoEvento
        holder.tvEtiquetas.text = evento.tipoEvento

        holder.itemView.setOnClickListener {
            val intent = Intent(this.contexto, EventDetailsActivity :: class.java)

            intent.putExtra("nombre", evento.nombre)
            intent.putExtra("fechaHoraInicio", evento.fechaInicio)
            intent.putExtra("municipio", evento.municipio)
            intent.putExtra("etiquetas", "")
            intent.putExtra("organizador", evento.organizador)

            this.contexto.startActivity(intent)
        }
    }

    fun llenar(datos: ArrayList<Evento>) {
        this.datos = datos
        this.notifyDataSetChanged()
    }
}