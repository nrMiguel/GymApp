package com.example.mygymbroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mygymbroapp.adapterEjerciciosMusculo.EjerciciosMusculoAdapter
import com.example.mygymbroapp.clasesMusculos.EjerciciosMusculo
import com.example.mygymbroapp.databinding.ActivityEjerciciosMusculoBinding
import com.example.mygymbroapp.providers.EjerciciosMusculoProvider

class EjerciciosMusculoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEjerciciosMusculoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjerciciosMusculoBinding.inflate((layoutInflater))
        setContentView(binding.root)

        intent.getStringExtra("Musculo")?.let { initReyclerView(it) }
    }

    private fun initReyclerView(musculo: String) {
        val manager = LinearLayoutManager(this)
        binding.recyclerEjerciciosMusculo.layoutManager = manager

        when (musculo){
            //Pectoral.
            "Pectoral Mayor Superior" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.pectoralSuperiorList) { ejerciciosMusculo -> onItemSelected(ejerciciosMusculo) }
            "Pectoral Mayor" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.pectoralMayorList) { ejerciciosMusculo -> onItemSelected(ejerciciosMusculo) }
            "Pectoral Inferior" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.pectoralInferiorList) { ejerciciosMusculo -> onItemSelected(ejerciciosMusculo) }
            "Pectoral Superior interior" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.pectoralSuperiorInteriorList) { ejerciciosMusculo -> onItemSelected(ejerciciosMusculo) }
            "Pectoral Medio interior" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.pectoralMayorInteriorList) { ejerciciosMusculo -> onItemSelected(ejerciciosMusculo) }
            "Pectoral Inferior interior" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.pectoralInferiorInteriorList) { ejerciciosMusculo -> onItemSelected(ejerciciosMusculo) }

            //Deltoides.

        }
    }

    private fun onItemSelected(ejerciciosMusculo: EjerciciosMusculo) {
        Toast.makeText(this, ejerciciosMusculo.musculo, Toast.LENGTH_SHORT).show() //Test.
    }
}