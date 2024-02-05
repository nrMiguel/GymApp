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
import androidx.core.view.isGone
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mygymbroapp.BD.AppDataBase
import com.example.mygymbroapp.BD.Ejercicio
import com.example.mygymbroapp.BD.Rutina
import com.example.mygymbroapp.adapterDiasRutina.DiasRutinaAdapter

import com.example.mygymbroapp.adapterGrupoMuscular.GrupoMuscualarAdapter
import com.example.mygymbroapp.adapterMusculoDeGrupoMuscular.MusculoDeGrupoMuscularAdapter
import com.example.mygymbroapp.databinding.ActivityMainBinding
import com.example.mygymbroapp.placeholder.GrupoMuscular
import com.example.mygymbroapp.providers.DiasRutinaProvider
import com.example.mygymbroapp.providers.GrupoMuscularProvider
import com.example.mygymbroapp.providers.MusculosDeGrupoMuscularProvider
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var db: AppDataBase
    lateinit var diaSemana: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //GrupoMuscularProvider.grupoMuscularList
        //etContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setSupportActionBar(binding.myToolbar) Esto peta la app+
        //if (intent.hasExtra("Crear")) intent.getStringExtra("Crear")?.let { initRecyclerViewCrear() } else initRecyclerView()
        if(intent.hasExtra("Dia_semana")) intent.getStringExtra("Dia_semana")?.let {
            db = AppDataBase.getInstance(this)!!

            diaSemana = it
            binding.tvDiaSemana.visibility
            binding.tvDiaSemana.text = diaSemana

            initRecyclerViewCrear()
        } else {
            binding.tvDiaSemana.isGone
            initRecyclerView()
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
                //TODO: Borrar inserts cuando sea funcional.
                db = AppDataBase.getInstance(this)!!
                GlobalScope.launch {
                    db.rutinaDao().insertRutina(Rutina("Lunes", "Pecho"))
                    db.ejercicioDao().insertEjercicio(Ejercicio("Pectoral Mayor Superior", "Lunes", null, 3, 8, 22.0))

                    val rutinasDb = db.rutinaDao().getAllRutinasEjercicios()

                    rutinasDb.forEach{ Log.i("----->", it.ejercicios.toString()) }
                }

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

    private fun initRecyclerViewCrear() {
        val manager = GridLayoutManager(this, 3)

        binding.recyclerGruposMusculares.layoutManager = manager
        binding.recyclerGruposMusculares.adapter = GrupoMuscualarAdapter(GrupoMuscularProvider.grupoMuscularList) { grupoMuscular -> onItemSelectedCrear(grupoMuscular) }
    }

    //En base a la selección del grupo muscular motrará por separado las diferentes partes del grupo muscular a poder entrenar.
    fun onItemSelected(grupoMuscular: GrupoMuscular){
        val intent = Intent(this, MusculoDeGrupoMuscularActivity::class.java).apply {
            putExtra("Grupo_Muscular", grupoMuscular.grupoMuscular)
            //putExtra("Dia_semana", "")
        }
        startActivity(intent)
    }

    fun onItemSelectedCrear(grupoMuscular: GrupoMuscular){
        //TODO: voy por aquí, ahora tocaría ir hacía los músculos para añadir a las rutinas. Aunque probablemente primero debería crear la Activity para que se pueda poner los pesos, sets y tal.
        GlobalScope.launch {
            db.rutinaDao().insertRutina(Rutina(diaSemana, grupoMuscular.grupoMuscular))
        }
        val intent = Intent(this, MusculoDeGrupoMuscularActivity::class.java).apply {
            putExtra("Grupo_Muscular", grupoMuscular.grupoMuscular)
            putExtra("Dia_semana", diaSemana)
        }
        startActivity(intent)
    }
}