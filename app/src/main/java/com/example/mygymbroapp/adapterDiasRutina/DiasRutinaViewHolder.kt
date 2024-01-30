package com.example.mygymbroapp.adapterDiasRutina

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mygymbroapp.clasesMusculos.DiasRutina
import com.example.mygymbroapp.databinding.ItemDiasRutinaBinding
/*
class DiasRutinaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemDiasRutinaBinding.bind(view)

    fun render(diasRutinaModel: DiasRutina, onClickListener: (DiasRutina) -> Unit){
        Glide.with(binding.ivDiaGrupoMuscular.context).load(diasRutinaModel.photo)
            .into(binding.ivDiaGrupoMuscular)
        binding.tvDiaEjercicio.text = diasRutinaModel.diaSemana

        itemView.setOnClickListener { onClickListener(diasRutinaModel) }
    }
}

 */