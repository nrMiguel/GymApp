package com.example.mygymbroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager

import com.example.mygymbroapp.adapterGrupoMuscular.GrupoMuscualarAdapter
import com.example.mygymbroapp.adapterMusculoDeGrupoMuscular.MusculoDeGrupoMuscularAdapter
import com.example.mygymbroapp.databinding.ActivityMainBinding
import com.example.mygymbroapp.placeholder.GrupoMuscular
import com.example.mygymbroapp.providers.GrupoMuscularProvider
import com.example.mygymbroapp.providers.MusculosDeGrupoMuscularProvider

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //GrupoMuscularProvider.grupoMuscularList
        //etContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setSupportActionBar(binding.myToolbar)
        initRecyclerView()
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