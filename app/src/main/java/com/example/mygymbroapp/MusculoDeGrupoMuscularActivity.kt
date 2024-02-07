package com.example.mygymbroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.isGone
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mygymbroapp.BD.AppDataBase
import com.example.mygymbroapp.BD.Ejercicio
import com.example.mygymbroapp.BD.Rutina
import com.example.mygymbroapp.adapterMusculoDeGrupoMuscular.MusculoDeGrupoMuscularAdapter
import com.example.mygymbroapp.clasesMusculos.MusculoDeGrupoMusuclar
import com.example.mygymbroapp.databinding.ActivityMusculoDeGrupoMuscularBinding
import com.example.mygymbroapp.providers.MusculosDeGrupoMuscularProvider
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MusculoDeGrupoMuscularActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMusculoDeGrupoMuscularBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusculoDeGrupoMuscularBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra("Dia_semana")){
            intent.getStringExtra("Dia_semana")?.let {
                diasSemana -> intent.getStringExtra("Grupo_Muscular")?.let {
                    binding.tvDiaSemana.visibility
                    binding.tvDiaSemana.text = diasSemana

                    initRecyclerViewCrear(diasSemana, it)
                }
            }
        } else {
            binding.tvDiaSemana.isGone
            intent.getStringExtra("Grupo_Muscular")?.let { initRecyclerView(it) }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.tool_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.home_page -> {
                startActivity(Intent(this, MainActivity::class.java))
                true
            }
            R.id.fitness_center -> {
                val intent = Intent(this, DiasRutinaActivity::class.java)
                startActivity(intent)

                true
            }
            R.id.crear_rutina -> {
                val intent = Intent(this, DiasRutinaActivity::class.java).apply { putExtra("Crear", "Si") }
                startActivity(intent)
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

    private fun initRecyclerViewCrear(diaSemana:String, grupoMuscular: String){
        val manager = GridLayoutManager(this, 3)
        binding.recyclerMusculoDeGrupoMuscular.layoutManager = manager

        when (grupoMuscular){
            "Pecho" -> binding.recyclerMusculoDeGrupoMuscular.adapter = MusculoDeGrupoMuscularAdapter(MusculosDeGrupoMuscularProvider.musculosPechoList) { musculoDeGrupo -> onItemSelectedCrear(musculoDeGrupo) }
            "Deltoides" -> binding.recyclerMusculoDeGrupoMuscular.adapter = MusculoDeGrupoMuscularAdapter(MusculosDeGrupoMuscularProvider.musculosDeltoidesList) { musculoDeGrupo -> onItemSelectedCrear(musculoDeGrupo) }
            "Biceps" -> binding.recyclerMusculoDeGrupoMuscular.adapter = MusculoDeGrupoMuscularAdapter(MusculosDeGrupoMuscularProvider.musculosBicepsList) { musculoDeGrupo -> onItemSelectedCrear(musculoDeGrupo) }
            //TODO: Falta poner que aquí lo lleve a la función o lo que sea para que se vea la pantalla de los posibles ejercicios a hacer de los 3 siguientes "cases".
            "Braquial" -> Toast.makeText(this, grupoMuscular, Toast.LENGTH_SHORT).show()
            "Bracoradial" -> Toast.makeText(this, grupoMuscular, Toast.LENGTH_SHORT).show()
            "Antebrazos" -> Toast.makeText(this, grupoMuscular, Toast.LENGTH_SHORT).show()
            "Trapecios" -> binding.recyclerMusculoDeGrupoMuscular.adapter = MusculoDeGrupoMuscularAdapter(MusculosDeGrupoMuscularProvider.musculosTrapeciosList) { musculoDeGrupo -> onItemSelectedCrear(musculoDeGrupo)}
            "Triceps" -> binding.recyclerMusculoDeGrupoMuscular.adapter = MusculoDeGrupoMuscularAdapter(MusculosDeGrupoMuscularProvider.musculosTricepsList) { musculoDeGrupo -> onItemSelectedCrear(musculoDeGrupo) }
            "Espalda" -> binding.recyclerMusculoDeGrupoMuscular.adapter = MusculoDeGrupoMuscularAdapter(MusculosDeGrupoMuscularProvider.musculosEspaldaList) { musculoDeGrupo -> onItemSelectedCrear(musculoDeGrupo) }
            "Gluteos" -> binding.recyclerMusculoDeGrupoMuscular.adapter = MusculoDeGrupoMuscularAdapter(MusculosDeGrupoMuscularProvider.musculosGluteosList) { musculoDeGrupo -> onItemSelectedCrear(musculoDeGrupo) }
            "Piernas" -> binding.recyclerMusculoDeGrupoMuscular.adapter = MusculoDeGrupoMuscularAdapter(MusculosDeGrupoMuscularProvider.musculosPiernasList) { musculoDeGrupo -> onItemSelectedCrear(musculoDeGrupo) }
        }
    }

    fun onItemSelected(musculoDeGrupoMusuclar: MusculoDeGrupoMusuclar){
        val intent = Intent(this, EjerciciosMusculoActivity::class.java). apply { putExtra("Musculo", musculoDeGrupoMusuclar.musculoDeGrupoMusuclar) }
        startActivity(intent)
    }

    fun onItemSelectedCrear(musculoDeGrupoMusuclar: MusculoDeGrupoMusuclar){
        Log.i("-->", "MusculoDeGrupoMuscularActivity -> " + "\n\tDía semana: " + intent.getStringExtra("Dia_semana"))
        val intent = Intent(this, EjerciciosMusculoActivity::class.java). apply {
            putExtra("Grupo_Muscular", intent.getStringExtra("Grupo_Muscular"))
            putExtra("Dia_semana", intent.getStringExtra("Dia_semana"))
            putExtra("Musculo", musculoDeGrupoMusuclar.musculoDeGrupoMusuclar)
        }
        startActivity(intent)
    }
}