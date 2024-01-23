package com.example.mygymbroapp.adapterEjerciciosMusculo

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mygymbroapp.clasesMusculos.EjerciciosMusculo
import com.example.mygymbroapp.databinding.ItemEjerciciosMusucloBinding

class EjerciciosMusculoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemEjerciciosMusucloBinding.bind(view)

    fun render(
        ejerciciosMusculoModel: EjerciciosMusculo,
        onClickListener: (EjerciciosMusculo) -> Unit
    ) {
        Glide.with(binding.ivEjercicioMusculo.context).load(ejerciciosMusculoModel.photo)
            .into(binding.ivEjercicioMusculo)

        itemView.setOnClickListener { onClickListener(ejerciciosMusculoModel) }

        binding.tvEjercicioMusculo.text = ejerciciosMusculoModel.musculo
    }
}