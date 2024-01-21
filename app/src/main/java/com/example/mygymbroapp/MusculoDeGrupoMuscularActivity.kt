package com.example.mygymbroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mygymbroapp.adapterMusculoDeGrupoMuscular.MusculoDeGrupoMuscularAdapter
import com.example.mygymbroapp.databinding.ActivityMusculoDeGrupoMuscularBinding
import com.example.mygymbroapp.providers.MusculosDeGrupoMuscularProvider

class MusculoDeGrupoMuscularActivity : AppCompatActivity() {
    private  lateinit var  binding: ActivityMusculoDeGrupoMuscularBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusculoDeGrupoMuscularBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.getStringExtra("Grupo_Muscular")?.let { initRecyclerView(it) }
    }

    private fun initRecyclerView(grupoMuscular: String){
        val manager = GridLayoutManager(this, 3)
        binding.recyclerMusculoDeGrupoMuscular.layoutManager = manager

        when (grupoMuscular){
            "Pecho" -> binding.recyclerMusculoDeGrupoMuscular.adapter = MusculoDeGrupoMuscularAdapter(MusculosDeGrupoMuscularProvider.musculosPechoList) { musculoDeGrupo -> onItemSelected(musculoDeGrupo) }
            "Deltoides" -> binding.recyclerMusculoDeGrupoMuscular.adapter = MusculoDeGrupoMuscularAdapter(MusculosDeGrupoMuscularProvider.musculosDeltoidesList) { musculoDeGrupo -> onItemSelected(musculoDeGrupo) }
            "Biceps" -> binding.recyclerMusculoDeGrupoMuscular.adapter = MusculoDeGrupoMuscularAdapter(MusculosDeGrupoMuscularProvider.musculosBicepsList) { musculoDeGrupo -> onItemSelected(musculoDeGrupo) }
            //TODO: Falta poner que aquí lo lleve a la función o lo que sea para que se vea la pantalla de los posibles ejercicios a hacer de los 3 siguientes "cases".
            "Braquial" -> Toast.makeText(this, grupoMuscular, Toast.LENGTH_SHORT).show()
            "Bracoradial" -> Toast.makeText(this, grupoMuscular, Toast.LENGTH_SHORT).show()
            "Antebrazos" -> Toast.makeText(this, grupoMuscular, Toast.LENGTH_SHORT).show()
            "Trapecios" -> binding.recyclerMusculoDeGrupoMuscular.adapter = MusculoDeGrupoMuscularAdapter(MusculosDeGrupoMuscularProvider.musculosTrapeciosList) { musculoDeGrupo -> onItemSelected(musculoDeGrupo)}
            "Triceps" -> binding.recyclerMusculoDeGrupoMuscular.adapter = MusculoDeGrupoMuscularAdapter(MusculosDeGrupoMuscularProvider.musculosTricepsList) { musculoDeGrupo -> onItemSelected(musculoDeGrupo) }
            "Espalda" -> binding.recyclerMusculoDeGrupoMuscular.adapter = MusculoDeGrupoMuscularAdapter(MusculosDeGrupoMuscularProvider.musculosEspaldaList) { musculoDeGrupo -> onItemSelected(musculoDeGrupo) }
            "Gluteos" -> binding.recyclerMusculoDeGrupoMuscular.adapter = MusculoDeGrupoMuscularAdapter(MusculosDeGrupoMuscularProvider.musculosGluteosList) { musculoDeGrupo -> onItemSelected(musculoDeGrupo) }
            "Piernas" -> binding.recyclerMusculoDeGrupoMuscular.adapter = MusculoDeGrupoMuscularAdapter(MusculosDeGrupoMuscularProvider.musculosPiernasList) { musculoDeGrupo -> onItemSelected(musculoDeGrupo) }
        }
    }


    //TODO: Esta función llevaría a la pantalla con todos los ejercicios posibles por musculo seleccionado.
    fun onItemSelected(musculoDeGrupoMusuclar: MusculoDeGrupoMusuclar){
        Toast.makeText(this, musculoDeGrupoMusuclar.musculoDeGrupoMusuclar, Toast.LENGTH_SHORT).show()
    }
}