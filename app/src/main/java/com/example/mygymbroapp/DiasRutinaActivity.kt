package com.example.mygymbroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.marginTop
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mygymbroapp.BD.AppDataBase
import com.example.mygymbroapp.BD.Rutina
import com.example.mygymbroapp.adapterDiasRutina.DiasRutinaAdapter
import com.example.mygymbroapp.clasesMusculos.DiasRutina
import com.example.mygymbroapp.databinding.ActivityDiasRutinaBinding
import com.example.mygymbroapp.databinding.ActivityMainBinding
import com.example.mygymbroapp.databinding.ItemDiasRutinaBinding
import com.example.mygymbroapp.providers.DiasRutinaProvider
import com.example.mygymbroapp.providers.GrupoMuscularProvider
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DiasRutinaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDiasRutinaBinding

    lateinit var db: AppDataBase
    private var diasRutina: ArrayList<DiasRutina> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiasRutinaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDataBase.getInstance(this)!!

        if (intent.hasExtra("Crear")) {
            intent.getStringExtra("Crear")?.let { initRecyclerViewCrear() }
        } else {
            diasConRutina()
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

    private fun diasConRutina() {
        GlobalScope.launch {
            val diasRutinaDb = db.rutinaDao().getAllRutina()
            diasRutinaDb.forEach{
                diasDb -> diasDb.dayOfWeek.forEach {
                    DiasRutinaProvider.diasRutinaList.forEach {
                        diasProvider -> diasProvider.diaSemana.forEach {
                            if (diasDb.dayOfWeek.equals(diasProvider.diaSemana)){
                                GrupoMuscularProvider.grupoMuscularList.forEach {
                                    grupoMuscular -> grupoMuscular.grupoMuscular.forEach {
                                        if (diasDb.grupoMuscular.equals(grupoMuscular.grupoMuscular)) {
                                            Log.i("--->", "Day of week: " + diasDb.dayOfWeek + "\nDia semana Provider: " + diasProvider.diaSemana +
                                                        "\n\tGrupoDB: " + diasDb.grupoMuscular + "\n\tGrupo Provider: " + grupoMuscular.grupoMuscular + "\n\tPhotoProvider: " + grupoMuscular.photo)

                                            diasProvider.photo = grupoMuscular.photo
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        DiasRutinaProvider.diasRutinaList.forEach {
            Log.i("---->", "Dia semana: " + it.diaSemana + "\n\tPhoto: " + it.photo)
        }
        //DiasRutinaProvider.diasRutinaList[0] = DiasRutina(DiasRutinaProvider.diasRutinaList[0].diaSemana, "https://bulevip.com/blog/wp-content/uploads/2015/11/pectoral-mayor-musculos.jpg") /////////////////////////////////////////Por AQUI.
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this)

        binding.recyclerDiasRutina.layoutManager = manager
        binding.recyclerDiasRutina.adapter = DiasRutinaAdapter(DiasRutinaProvider.diasRutinaList) { diasRutina -> onItemSelected(diasRutina) }
    }

    private fun initRecyclerViewCrear() {
        val manager = LinearLayoutManager(this)

        binding.recyclerDiasRutina.layoutManager = manager
        binding.recyclerDiasRutina.adapter = DiasRutinaAdapter(DiasRutinaProvider.diasRutinaCrearList) { diasRutina -> onItemSelectedCrear(diasRutina) }
    }

    private fun onItemSelected(diasRutina: DiasRutina) {

    }

    private fun onItemSelectedCrear(diasRutina: DiasRutina) {
        GlobalScope.launch {
            db.rutinaDao().insertRutina(Rutina(diasRutina.diaSemana, ""))
        }

        val intent = Intent(this, MainActivity::class.java).apply { putExtra("Dia_semana", diasRutina.diaSemana) }
        startActivity(intent)
    }
}