package com.example.mygymbroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mygymbroapp.BD.AppDataBase
import com.example.mygymbroapp.BD.Ejercicio
import com.example.mygymbroapp.BD.Rutina
import com.example.mygymbroapp.adapterVerRutinas.VerRutinasAdapter
import com.example.mygymbroapp.databinding.ActivityVerRutinasBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class VerRutinasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVerRutinasBinding
    private lateinit var db: AppDataBase
    lateinit var rutinaList: List<Ejercicio>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerRutinasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i("----->", "VerRutinasActivity") // Test.

        db = AppDataBase.getInstance(this)!!

        GlobalScope.launch {
            rutinaList = db.ejercicioDao().getEjerciciosByDay(intent.getStringExtra("Dia_semana")!!)

            Log.i("----->", "VerRutinasActivity") // Test.
            // rutinaList.forEach { Log.i("----->", "\t$it") } // Test.

            initRecyclerView(rutinaList)
        }

        //TODO: Voy por aquí, faltaría poner que cargue el adapter, clickOnSet, OptionsMenú u algo para poder modificar desde esta misma vista los Sets Repts Peso o mismo ejericicio
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
                startActivity(Intent(this, DiasRutinaActivity::class.java))
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

    private fun initRecyclerView(rutinaList: List<Ejercicio>) {
        val manager = LinearLayoutManager(this)
        binding.recyclerVerRutina.layoutManager = manager

        binding.recyclerVerRutina.adapter = VerRutinasAdapter(rutinaList) { ejercicio -> onItemSelected(ejercicio) }
    }

    private fun onItemSelected(ejercicio: Ejercicio){
        val intent = Intent(this, AnadirMusculoActivity::class.java).apply {
            putExtra("Editar", "Si")
            putExtra("Musculo", ejercicio.musculo)
            putExtra("RutinaDayOfWeek", ejercicio.rutinaDayOfWeek)
            putExtra("Photo", ejercicio.photo)
            putExtra("Sets", ejercicio.sets.toString())
            putExtra("Reps", ejercicio.reps.toString())
            putExtra("Peso", ejercicio.weight.toString())
        }
        startActivity(intent)
    }
}