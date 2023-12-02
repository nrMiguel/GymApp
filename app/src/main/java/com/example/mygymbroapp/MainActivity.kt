package com.example.mygymbroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager

import com.example.mygymbroapp.adapterGrupoMuscular.GrupoMuscualarAdapter
import com.example.mygymbroapp.databinding.ActivityMainBinding
import com.example.mygymbroapp.placeholder.GrupoMuscular

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //GrupoMuscularProvider.grupoMuscularList
        //etContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        /*
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerGruposMusculares)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter = GrupoMuscualarAdapter(GrupoMuscularProvider.grupoMuscularList)
         */
        val manager = GridLayoutManager(this, 3)
        //val decoration = DividerItemDecoration(this, manager.orientation)
        binding.recyclerGruposMusculares.layoutManager = manager
        binding.recyclerGruposMusculares.adapter = GrupoMuscualarAdapter(GrupoMuscularProvider.grupoMuscularList) { grupoMuscular ->
            onItemSelected(
                grupoMuscular
            )
        }
        //binding.recyclerGruposMusculares.addItemDecoration(decoration)
    }

    fun onItemSelected(grupoMuscular: GrupoMuscular){
        Toast.makeText(this, grupoMuscular.grupoMuscular, Toast.LENGTH_SHORT).show()
    }
}