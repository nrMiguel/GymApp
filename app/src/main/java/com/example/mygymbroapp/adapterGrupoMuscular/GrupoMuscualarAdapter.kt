package com.example.mygymbroapp.adapterGrupoMuscular

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mygymbroapp.R
import com.example.mygymbroapp.placeholder.GrupoMuscular

class GrupoMuscualarAdapter(private val grupoMuscularList: List<GrupoMuscular>, private val onClickListener:(GrupoMuscular) -> Unit) : RecyclerView.Adapter<GrupoMuscularViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GrupoMuscularViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return GrupoMuscularViewHolder(layoutInflater.inflate(R.layout.item_grupo_muscular, parent, false))
    }

    override fun onBindViewHolder(holder: GrupoMuscularViewHolder, position: Int) {
        val item = grupoMuscularList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = grupoMuscularList.size
}