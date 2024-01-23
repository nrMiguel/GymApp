package com.example.mygymbroapp.adapterMusculoDeGrupoMuscular

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mygymbroapp.clasesMusculos.MusculoDeGrupoMusuclar
import com.example.mygymbroapp.databinding.ItemMusculoDeGrupoBinding

class MusculoDeGrupoMuscularViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemMusculoDeGrupoBinding.bind(view)

    fun render(
        musculoDeGrupoMusuclarModel: MusculoDeGrupoMusuclar,
        onClickListener: (MusculoDeGrupoMusuclar) -> Unit
    ) {
        Glide.with(binding.ivMusculoDeGrupo.context).load(musculoDeGrupoMusuclarModel.photo)
            .into(binding.ivMusculoDeGrupo)

        itemView.setOnClickListener { onClickListener(musculoDeGrupoMusuclarModel) }
    }

}