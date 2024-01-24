package com.example.mygymbroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mygymbroapp.adapterMusculoDeGrupoMuscular.MusculoDeGrupoMuscularAdapter
import com.example.mygymbroapp.clasesMusculos.MusculoDeGrupoMusuclar
import com.example.mygymbroapp.databinding.ActivityMusculoDeGrupoMuscularBinding
import com.example.mygymbroapp.providers.MusculosDeGrupoMuscularProvider

class MusculoDeGrupoMuscularActivity : AppCompatActivity() {
    private  lateinit var  binding: ActivityMusculoDeGrupoMuscularBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusculoDeGrupoMuscularBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.getStringExtra("Grupo Muscular")?.let { initRecyclerView(it) }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.tool_bar, menu)
        return true
    }

    //TODO: Hacer que esto viaje a la Activity Rutina o a la misma MainActivity.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.home_page -> {
                Toast.makeText(this, "home_page", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.fitness_center -> {
                Toast.makeText(this, "fitness_center", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
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
        val intent = Intent(this, EjerciciosMusculoActivity::class.java). apply { putExtra("Musculo", musculoDeGrupoMusuclar.musculoDeGrupoMusuclar) }
        startActivity(intent)
    }
}