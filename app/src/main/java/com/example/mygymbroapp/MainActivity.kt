package com.example.mygymbroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem

import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mygymbroapp.BD.AppDataBase
import com.example.mygymbroapp.BD.Ejercicio
import com.example.mygymbroapp.BD.Rutina

import com.example.mygymbroapp.adapterGrupoMuscular.GrupoMuscualarAdapter
import com.example.mygymbroapp.adapterMusculoDeGrupoMuscular.MusculoDeGrupoMuscularAdapter
import com.example.mygymbroapp.databinding.ActivityMainBinding
import com.example.mygymbroapp.placeholder.GrupoMuscular
import com.example.mygymbroapp.providers.GrupoMuscularProvider
import com.example.mygymbroapp.providers.MusculosDeGrupoMuscularProvider
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var db: AppDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //GrupoMuscularProvider.grupoMuscularList
        //etContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //
        //setSupportActionBar(binding.myToolbar) Esto peta la app
        initRecyclerView()
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
                //Toast.makeText(this, "fitness_center", Toast.LENGTH_SHORT).show()

                //TODO: Borrar inserts cuando sea funcional.
                db = AppDataBase.getInstance(this)!!
                GlobalScope.launch {
                    db.rutinaDao().insertRutina(Rutina("Lunes", "Pecho"))
                    db.ejercicioDao().insertEjercicio(Ejercicio("Pectoral Mayor Superior", 1, null, 3, 8, 22.0))

                    val rutinasDb = db.rutinaDao().getAllRutinasEjercicios()

                    rutinasDb.forEach{ Log.i("----->", it.ejercicios.toString()) }
                }

                val intent = Intent(this, DiasRutinaActivity::class.java)
                startActivity(intent)

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initRecyclerView(){
        /*
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerGruposMusculares)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter = GrupoMuscualarAdapter(GrupoMuscularProvider.grupoMuscularList)
         */
        val manager = GridLayoutManager(this, 3)

        binding.recyclerGruposMusculares.layoutManager = manager
        binding.recyclerGruposMusculares.adapter = GrupoMuscualarAdapter(GrupoMuscularProvider.grupoMuscularList) { grupoMuscular -> onItemSelected(grupoMuscular) }
    }

    //En base a la selección del grupo muscular motrará por separado las diferentes partes del grupo muscular a poder entrenar.
    fun onItemSelected(grupoMuscular: GrupoMuscular){
        //Toast.makeText(this, grupoMuscular.grupoMuscular, Toast.LENGTH_SHORT).show()

        val intent = Intent(this, MusculoDeGrupoMuscularActivity::class.java).apply { putExtra("Grupo Muscular", grupoMuscular.grupoMuscular) }
        startActivity(intent)
    }
}