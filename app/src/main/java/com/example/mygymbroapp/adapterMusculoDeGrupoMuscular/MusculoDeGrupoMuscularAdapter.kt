package com.example.mygymbroapp.adapterMusculoDeGrupoMuscular

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mygymbroapp.MusculoDeGrupoMusuclar
import com.example.mygymbroapp.R

class MusculoDeGrupoMuscularAdapter(private val musculoDeGrupoList: List<MusculoDeGrupoMusuclar>, private val onClickListener: (MusculoDeGrupoMusuclar) -> Unit) : RecyclerView.Adapter<MusculoDeGrupoMuscularViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusculoDeGrupoMuscularViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MusculoDeGrupoMuscularViewHolder(layoutInflater.inflate(R.layout.item_musculo_de_grupo, parent, false))
    }

    override fun onBindViewHolder(holder: MusculoDeGrupoMuscularViewHolder, position: Int) {
        val item = musculoDeGrupoList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = musculoDeGrupoList.size
}