package com.example.mygymbroapp.adapterVerRutinas

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mygymbroapp.BD.Ejercicio
import com.example.mygymbroapp.clasesMusculos.Rutina
import com.example.mygymbroapp.databinding.ItemVerRutinasBinding

class VerRutinasViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemVerRutinasBinding.bind(view)

    fun render(
        rutinaModel: Ejercicio,
        onClickListener: (Ejercicio) -> Unit
    ) {
        Glide.with(binding.ivEjercicioMusculo.context).load(rutinaModel.photo).into(binding.ivEjercicioMusculo)
        binding.tvNombreEjercicio.text = rutinaModel.musculo
        binding.tvSets.text = rutinaModel.sets.toString()
        binding.tvReps.text = rutinaModel.reps.toString()
        binding.tvPeso.text = rutinaModel.weight.toString()

        binding.btnEditar.setOnClickListener { onClickListener(rutinaModel) }
    }
}