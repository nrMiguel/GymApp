package com.example.mygymbroapp.adapterGrupoMuscular

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.mygymbroapp.databinding.ItemGrupoMuscularBinding
import com.example.mygymbroapp.placeholder.GrupoMuscular

class GrupoMuscularViewHolder(view: View) : ViewHolder(view) {

    val binding = ItemGrupoMuscularBinding.bind(view)

    /*
    val grupoMuscular = view.findViewById<TextView>(R.id.tvGrupoMuscular)
    val photo = view.findViewById<ImageView>(R.id.ivGrupoMuscular)
     */

    fun render(grupoMuscularModel: GrupoMuscular, onClickListener:(GrupoMuscular) -> Unit) {
        /*
        grupoMuscular.text = grupoMuscularModel.grupoMuscular
        Glide.with(photo.context).load(grupoMuscularModel.photo).into(photo)
         */
        //binding.tvGrupoMuscular.text = grupoMuscularModel.grupoMuscular
        Glide.with(binding.ivGrupoMuscular.context).load(grupoMuscularModel.photo)
            .into(binding.ivGrupoMuscular)
        itemView.setOnClickListener { onClickListener(grupoMuscularModel) }
    }
}