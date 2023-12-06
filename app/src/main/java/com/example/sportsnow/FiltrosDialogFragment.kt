package com.example.sportsnow
import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
class FiltrosDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Aquí configurarás y devolverás tu diálogo
        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Título del Diálogo")
            .setMessage("Contenido del Diálogo")
            .setPositiveButton("Aceptar") { dialog, _ ->
                // Acción al hacer clic en Aceptar
                dialog.dismiss()
            }
            .setNegativeButton("Cancelar") { dialog, _ ->
                // Acción al hacer clic en Cancelar
                dialog.dismiss()
            }

        return builder.create()
    }
}