package com.example.mygymbroapp.adapterVerRutinas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mygymbroapp.BD.Ejercicio
import com.example.mygymbroapp.clasesMusculos.Rutina
import com.example.mygymbroapp.R

class VerRutinasAdapter(private val ejerciciosRutinaList: List<Ejercicio>, private val onClickListener: (Ejercicio) -> Unit) : RecyclerView.Adapter<VerRutinasViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerRutinasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return VerRutinasViewHolder(layoutInflater.inflate(R.layout.item_ver_rutinas, parent, false))
    }

    override fun onBindViewHolder(holder: VerRutinasViewHolder, position: Int) {
        val item = ejerciciosRutinaList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = ejerciciosRutinaList.size
}