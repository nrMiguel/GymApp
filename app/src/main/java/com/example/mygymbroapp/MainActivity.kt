package com.example.mygymbroapp

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

    //En base a la selección del grupo muscular motrará por separado las diferentes partes del grupo muscular a poder entrenar.
    fun onItemSelected(grupoMuscular: GrupoMuscular){
        //Toast.makeText(this, grupoMuscular.grupoMuscular, Toast.LENGTH_SHORT).show()

        when (grupoMuscular.grupoMuscular){
            "Pecho" -> binding.recyclerGruposMusculares.adapter = MusculoDeGrupoMuscularAdapter(MusculosDeGrupoMuscularProvider.musculosPechoList) { musculoDeGrupo ->
                onItemSelected(
                    musculoDeGrupo
                )
            }
            "Deltoides" -> binding.recyclerGruposMusculares.adapter = MusculoDeGrupoMuscularAdapter(MusculosDeGrupoMuscularProvider.musculosDeltoidesList) { musculoDeGrupo ->
                onItemSelected(
                    musculoDeGrupo
                )
            }
            "Biceps" -> binding.recyclerGruposMusculares.adapter = MusculoDeGrupoMuscularAdapter(MusculosDeGrupoMuscularProvider.musculosBicepsList) { musculoDeGrupo ->
                onItemSelected(
                    musculoDeGrupo
                )
            }
            //TODO: Falta poner que aquí lo lleve a la función o lo que sea para que se vea la pantalla de los posibles ejercicios a hacer de los 3 siguientes "cases".
            "Braquial" -> Toast.makeText(this, grupoMuscular.grupoMuscular, Toast.LENGTH_SHORT).show()
            "Bracoradial" -> Toast.makeText(this, grupoMuscular.grupoMuscular, Toast.LENGTH_SHORT).show()
            "Antebrazos" -> Toast.makeText(this, grupoMuscular.grupoMuscular, Toast.LENGTH_SHORT).show()
            "Trapecios" -> binding.recyclerGruposMusculares.adapter = MusculoDeGrupoMuscularAdapter(MusculosDeGrupoMuscularProvider.musculosTrapeciosList) { musculoDeGrupo ->
                onItemSelected(
                    musculoDeGrupo
                )
            }
            "Triceps" -> binding.recyclerGruposMusculares.adapter = MusculoDeGrupoMuscularAdapter(MusculosDeGrupoMuscularProvider.musculosTricepsList) { musculoDeGrupo ->
                onItemSelected(
                    musculoDeGrupo
                )
            }
            "Espalda" -> binding.recyclerGruposMusculares.adapter = MusculoDeGrupoMuscularAdapter(MusculosDeGrupoMuscularProvider.musculosEspaldaList) { musculoDeGrupo ->
                onItemSelected(
                    musculoDeGrupo
                )
            }
            "Gluteos" -> binding.recyclerGruposMusculares.adapter = MusculoDeGrupoMuscularAdapter(MusculosDeGrupoMuscularProvider.musculosGluteosList) { musculoDeGrupo ->
                onItemSelected(
                    musculoDeGrupo
                )
            }
            "Piernas" -> binding.recyclerGruposMusculares.adapter = MusculoDeGrupoMuscularAdapter(MusculosDeGrupoMuscularProvider.musculosPiernasList) { musculoDeGrupo ->
                onItemSelected(
                    musculoDeGrupo
                )
            }
        }

    }

    // Esta función llevaría a la pantalla con todos los ejercicios posibles por musculo seleccionado.
    fun onItemSelected(musculoDeGrupoMusuclar: MusculoDeGrupoMusuclar){
        Toast.makeText(this, musculoDeGrupoMusuclar.musculoDeGrupoMusuclar, Toast.LENGTH_SHORT).show()
    }
}