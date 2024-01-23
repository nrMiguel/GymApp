package com.example.mygymbroapp.adapterEjerciciosMusculo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mygymbroapp.R
import com.example.mygymbroapp.clasesMusculos.EjerciciosMusculo

class EjerciciosMusculoAdapter(private val ejerciciosMusculoList: List<EjerciciosMusculo>, private val onClickListener: (EjerciciosMusculo) -> Unit) : RecyclerView.Adapter<EjerciciosMusculoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EjerciciosMusculoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return EjerciciosMusculoViewHolder(layoutInflater.inflate(R.layout.item_ejercicios_musuclo, parent, false))
    }

    override fun onBindViewHolder(holder: EjerciciosMusculoViewHolder, position: Int) {
        val item = ejerciciosMusculoList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = ejerciciosMusculoList.size

}