package com.example.sportsnow

import android.view.View
import android.widget.TextView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView

class EventoVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    lateinit var tvEvento : TextView
    lateinit var tvEtiquetas : TextView
    lateinit var tvMunicipio : TextView
    lateinit var tvOrgainzador : TextView
    lateinit var tvFecha : TextView

    init {
        tvEvento = itemView.findViewById(R.id.tvEvento)
        tvEtiquetas = itemView.findViewById(R.id.tvEtiquetas)
        tvMunicipio = itemView.findViewById(R.id.tvMunicipio)
        tvOrgainzador = itemView.findViewById(R.id.tvOrganizador)
        tvFecha = itemView.findViewById(R.id.tvFecha)
    }
}
