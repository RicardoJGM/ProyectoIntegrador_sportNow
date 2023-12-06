package com.example.sportsnow

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MensajeVH : RecyclerView.ViewHolder {
    lateinit var tvNombre: TextView
    lateinit var tvMensaje: TextView
    lateinit var tvFechaHora: TextView
    lateinit var ivImagen: ImageView
    lateinit var ivImagenMensaje: ImageView

    constructor(itemView: View) : super(itemView) {
        tvNombre = itemView.findViewById(R.id.tvNombre)
        tvMensaje = itemView.findViewById(R.id.tvMensaje)
        tvFechaHora = itemView.findViewById(R.id.tvFechaHora)
        ivImagen = itemView.findViewById(R.id.ivImagen)
        ivImagenMensaje = itemView.findViewById(R.id.ivImagenMensaje)

    }
}