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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mygymbroapp.BD.AppDataBase
import com.example.mygymbroapp.BD.Ejercicio
import com.example.mygymbroapp.adapterEjerciciosMusculo.EjerciciosMusculoAdapter
import com.example.mygymbroapp.clasesMusculos.EjerciciosMusculo
import com.example.mygymbroapp.databinding.ActivityEjerciciosMusculoBinding
import com.example.mygymbroapp.providers.EjerciciosMusculoProvider
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EjerciciosMusculoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEjerciciosMusculoBinding
    lateinit var db: AppDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjerciciosMusculoBinding.inflate((layoutInflater))
        setContentView(binding.root)

        Log.i("----->", "EjerciciosMusuculoActivity") // Test.

        if (intent.hasExtra("Dia_semana")) {
            db = AppDataBase.getInstance(this)!!

            intent.getStringExtra("Dia_semana")?.let { diasSemana ->
                intent.getStringExtra("Musculo")?.let {
                    binding.tvDiaSemana.visibility
                    binding.tvDiaSemana.text = diasSemana

                    initReyclerViewCrear(it)
                }
            }
        } else {
            binding.tvDiaSemana.isGone
            intent.getStringExtra("Musculo")?.let { initReyclerView(it) }
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
            "Deltoides Anterior" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.deltoidesAnteriorList) { ejerciciosMusculo -> onItemSelected(ejerciciosMusculo) }
            "Deltoides Medio" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.deltoidesMedioList) { ejerciciosMusculo -> onItemSelected(ejerciciosMusculo) }
            "Deltoides Posterior" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.deltoidesPosteriorList) { ejerciciosMusculo -> onItemSelected(ejerciciosMusculo) }

            //Biceps.
            "Cabeza Larga Biceps" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.bicepsCabezaLargaList) { ejerciciosMusculo -> onItemSelected(ejerciciosMusculo) }
            "Cabeza Corta" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.bicepsCabezaCortaList) { ejerciciosMusculo -> onItemSelected(ejerciciosMusculo) }

            //Trapecios
            "Trapecio Superior" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.trapecioSuperiorList) { ejerciciosMusculo -> onItemSelected(ejerciciosMusculo) }
            "Trapecio Medio" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.trapecioMedioList) { ejerciciosMusculo -> onItemSelected(ejerciciosMusculo) }
            "Trapecio Inferior" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.trapecioInferiorList) { ejerciciosMusculo -> onItemSelected(ejerciciosMusculo) }

            //Triceps
            "Cabeza Lateral" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.tricepsCabezaLateralList) { ejerciciosMusculo -> onItemSelected(ejerciciosMusculo) }
            "Cabeza Larga Triceps" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.tricepsCabezaLargaList) { ejerciciosMusculo -> onItemSelected(ejerciciosMusculo) }
            "Cabeza Medial" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.tricepsCabezaMedialList) { ejerciciosMusculo -> onItemSelected(ejerciciosMusculo) }

            //Espalda
            /* TODO: Esto puede que no deba ponerlo aquí.
            "Redondo Mayor" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.espaldaRedondoMayor) { ejerciciosMusculo -> onItemSelected(ejerciciosMusculo) }
            "Redondo Menor" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.espaldaRedondoMenor) { ejerciciosMusculo -> onItemSelected(ejerciciosMusculo) }
             */
            "Dorsales" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.espaldaDorsalList) { ejerciciosMusculo -> onItemSelected(ejerciciosMusculo) }
            "Espalda baja" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.espaldaBajaList) { ejerciciosMusculo -> onItemSelected(ejerciciosMusculo) }

            //Glúteos.
            "Gluteo Superior" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.gluteoSuperiorList) { ejerciciosMusculo -> onItemSelected(ejerciciosMusculo) }
            "Gluteo Mayor" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.gluteoMayorList) { ejerciciosMusculo -> onItemSelected(ejerciciosMusculo) }

            //Piernas.
            "Cuadriceps" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.cuadricepsList) { ejerciciosMusculo -> onItemSelected(ejerciciosMusculo) }
            "Esquiotibiales" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.esquiotibialesList) { ejerciciosMusculo -> onItemSelected(ejerciciosMusculo) }
            "Aductores" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.aductoresList) { ejerciciosMusculo -> onItemSelected(ejerciciosMusculo) }
            "Gemelos" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.gemelosList) { ejerciciosMusculo -> onItemSelected(ejerciciosMusculo) }
        }
    }

    private fun initReyclerViewCrear(musculo: String) {
        val manager = LinearLayoutManager(this)
        binding.recyclerEjerciciosMusculo.layoutManager = manager

        when (musculo){
            //Pectoral.
            "Pectoral Mayor Superior" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.pectoralSuperiorList) { ejerciciosMusculo -> onItemSelectedCrear(ejerciciosMusculo) }
            "Pectoral Mayor" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.pectoralMayorList) { ejerciciosMusculo -> onItemSelectedCrear(ejerciciosMusculo) }
            "Pectoral Inferior" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.pectoralInferiorList) { ejerciciosMusculo -> onItemSelectedCrear(ejerciciosMusculo) }
            "Pectoral Superior interior" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.pectoralSuperiorInteriorList) { ejerciciosMusculo -> onItemSelectedCrear(ejerciciosMusculo) }
            "Pectoral Medio interior" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.pectoralMayorInteriorList) { ejerciciosMusculo -> onItemSelectedCrear(ejerciciosMusculo) }
            "Pectoral Inferior interior" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.pectoralInferiorInteriorList) { ejerciciosMusculo -> onItemSelectedCrear(ejerciciosMusculo) }

            //Deltoides.
            "Deltoides Anterior" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.deltoidesAnteriorList) { ejerciciosMusculo -> onItemSelectedCrear(ejerciciosMusculo) }
            "Deltoides Medio" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.deltoidesMedioList) { ejerciciosMusculo -> onItemSelectedCrear(ejerciciosMusculo) }
            "Deltoides Posterior" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.deltoidesPosteriorList) { ejerciciosMusculo -> onItemSelectedCrear(ejerciciosMusculo) }

            //Biceps.
            "Cabeza Larga Biceps" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.bicepsCabezaLargaList) { ejerciciosMusculo -> onItemSelectedCrear(ejerciciosMusculo) }
            "Cabeza Corta" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.bicepsCabezaCortaList) { ejerciciosMusculo -> onItemSelectedCrear(ejerciciosMusculo) }

            //Trapecios
            "Trapecio Superior" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.trapecioSuperiorList) { ejerciciosMusculo -> onItemSelectedCrear(ejerciciosMusculo) }
            "Trapecio Medio" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.trapecioMedioList) { ejerciciosMusculo -> onItemSelectedCrear(ejerciciosMusculo) }
            "Trapecio Inferior" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.trapecioInferiorList) { ejerciciosMusculo -> onItemSelectedCrear(ejerciciosMusculo) }

            //Triceps
            "Cabeza Lateral" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.tricepsCabezaLateralList) { ejerciciosMusculo -> onItemSelectedCrear(ejerciciosMusculo) }
            "Cabeza Larga Triceps" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.tricepsCabezaLargaList) { ejerciciosMusculo -> onItemSelectedCrear(ejerciciosMusculo) }
            "Cabeza Medial" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.tricepsCabezaMedialList) { ejerciciosMusculo -> onItemSelectedCrear(ejerciciosMusculo) }

            //Espalda
            /* TODO: Esto puede que no deba ponerlo aquí.
            "Redondo Mayor" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.espaldaRedondoMayor) { ejerciciosMusculo -> onItemSelectedCrear(ejerciciosMusculo) }
            "Redondo Menor" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.espaldaRedondoMenor) { ejerciciosMusculo -> onItemSelectedCrear(ejerciciosMusculo) }
             */
            "Dorsales" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.espaldaDorsalList) { ejerciciosMusculo -> onItemSelectedCrear(ejerciciosMusculo) }
            "Espalda baja" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.espaldaBajaList) { ejerciciosMusculo -> onItemSelectedCrear(ejerciciosMusculo) }

            //Glúteos.
            "Gluteo Superior" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.gluteoSuperiorList) { ejerciciosMusculo -> onItemSelectedCrear(ejerciciosMusculo) }
            "Gluteo Mayor" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.gluteoMayorList) { ejerciciosMusculo -> onItemSelectedCrear(ejerciciosMusculo) }

            //Piernas.
            "Cuadriceps" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.cuadricepsList) { ejerciciosMusculo -> onItemSelectedCrear(ejerciciosMusculo) }
            "Esquiotibiales" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.esquiotibialesList) { ejerciciosMusculo -> onItemSelectedCrear(ejerciciosMusculo) }
            "Aductores" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.aductoresList) { ejerciciosMusculo -> onItemSelectedCrear(ejerciciosMusculo) }
            "Gemelos" -> binding.recyclerEjerciciosMusculo.adapter = EjerciciosMusculoAdapter(EjerciciosMusculoProvider.gemelosList) { ejerciciosMusculo -> onItemSelectedCrear(ejerciciosMusculo) }
        }
    }

    private fun onItemSelected(ejerciciosMusculo: EjerciciosMusculo) {
        Toast.makeText(this, ejerciciosMusculo.musculo, Toast.LENGTH_SHORT).show() //Test.
    }

    private fun onItemSelectedCrear(ejerciciosMusculo: EjerciciosMusculo) {
        //GlobalScope.launch {
            //db.ejercicioDao().insertEjercicio(Ejercicio(ejerciciosMusculo.musculo, intent.getStringExtra("Dia_semana")!!, null, null, null, null))
        //}
        // Log.i("-->", "EjercicioMusculoActivity -> " + "\n\tDía semana: " + intent.getStringExtra("Dia_semana")) // Test.
        intent = Intent(this, AnadirMusculoActivity::class.java).apply {
            putExtra("Grupo_Muscular", intent.getStringExtra("Grupo_Muscular"))
            putExtra("Dia_semana", intent.getStringExtra("Dia_semana"))
            putExtra("Musculo", ejerciciosMusculo.musculo)
            putExtra("Photo", ejerciciosMusculo.photo)
        }
        startActivity(intent)
    }
}