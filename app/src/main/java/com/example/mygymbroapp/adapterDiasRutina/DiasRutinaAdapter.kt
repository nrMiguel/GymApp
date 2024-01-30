package com.example.mygymbroapp.adapterDiasRutina

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mygymbroapp.R
import com.example.mygymbroapp.clasesMusculos.DiasRutina

class DiasRutinaAdapter (private val diasRutinaList: List<DiasRutina>, private val onClickListener: (DiasRutina) -> Unit) : RecyclerView.Adapter<DiasRutinaViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiasRutinaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DiasRutinaViewHolder(layoutInflater.inflate(R.layout.item_dias_rutina, parent, false))
    }

    override fun onBindViewHolder(holder: DiasRutinaViewHolder, position: Int) {
        val item = diasRutinaList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = diasRutinaList.size
}