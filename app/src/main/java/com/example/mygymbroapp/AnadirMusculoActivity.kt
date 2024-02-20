package com.example.mygymbroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.mygymbroapp.BD.AppDataBase
import com.example.mygymbroapp.BD.Ejercicio
import com.example.mygymbroapp.databinding.ActivityAnadirMusculoBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class AnadirMusculoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnadirMusculoBinding
    lateinit var db: AppDataBase

    lateinit var sets: String
    lateinit var reps: String
    lateinit var peso: String

    //TODO: voy por aquí -> debo poner los bindings, el intent para conseguir los params, asignar imagen al layout, poner el botón para conseguir los datos y luego poner las cosas en BD y volver para poder seleccionar más ejercicios.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnadirMusculoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i("----->", "AnadirMusculoActivity") // Test.

        if (intent.hasExtra("Editar")){
            initViewEditar()
        } else {
            initView()
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

    private fun initViewEditar() {
        sets = intent.getStringExtra("Sets")!!
        reps = intent.getStringExtra("Reps")!!
        peso = intent.getStringExtra("Peso")!!

        Glide.with(binding.ivEjercicioMusculo.context).load(intent.getStringExtra("Photo")).into(binding.ivEjercicioMusculo)

        binding.etSets.setText(sets)
        binding.etReps.setText(reps)
        binding.etPeso.setText(peso)


        // Cambiamos el texto del botón Añadir por Actualizar.
        binding.btnAAdir.text = "Actualizar"

        db = AppDataBase.getInstance(this)!!

        binding.btnAAdir.setOnClickListener {
            runBlocking {
                GlobalScope.launch {
                    if (binding.etSets.text.isNotEmpty() && binding.etReps.text.isNotEmpty() && binding.etPeso.text.isNotEmpty()) {
                        Log.i("-->", "Primer if comprobando que los datos no estén vacíos")
                        if (binding.etSets.text.toString().toIntOrNull() != null) {
                            Log.i("-->", "Segundo if comprobando que Sets sea Int")
                            if (binding.etReps.text.toString().toIntOrNull() != null) {
                                Log.i("-->", "Segundo if comprobando que los Reps sea Int")
                                if (binding.etPeso.text.toString().toDoubleOrNull() != null) {
                                    Log.i("-->", "Segundo if comprobando que los Peso sea Double")

                                    db.ejercicioDao().insertEjercicio(
                                        Ejercicio(
                                            intent.getStringExtra("Musculo")!!,
                                            intent.getStringExtra("RutinaDayOfWeek")!!,
                                            intent.getStringExtra("Photo")!!,
                                            binding.etSets.text.toString().toIntOrNull(),
                                            binding.etReps.text.toString().toIntOrNull(),
                                            binding.etPeso.text.toString().toDoubleOrNull()
                                        )
                                    )
                                } else {
                                    //TODO: No sé como cambiar el color de texto por si está érroneo usando binding.
                                    //TODO: Ahora de momento podría poner simples Toast. Aunque creo que este no va dentro de hilos.
                                    //Toast.makeText(this@AnadirMusculoActivity, "No has introducido un número Peso", Toast.LENGTH_SHORT).show()
                                }
                                //Toast.makeText(this@AnadirMusculoActivity, "No has introducido un número Reps", Toast.LENGTH_SHORT).show()
                            }
                            //Toast.makeText(this@AnadirMusculoActivity, "No has introducido un número Sets", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }

            //TODO: No tengo claro como haré para poder volver desde donde llamé a esta Activity para editar.
            val intent = Intent(this, VerRutinasActivity::class.java).apply {
                //putExtra("Grupo_Muscular", intent.getStringExtra("Grupo_Muscular"))
                putExtra("Dia_semana", intent.getStringExtra("RutinaDayOfWeek"))
                //putExtra("Musculo", intent.getStringExtra("Musculo"))
            }
            startActivity(intent)
        }
    }

    private fun initView() {
        Glide.with(binding.ivEjercicioMusculo.context).load(intent.getStringExtra("Photo")).into(binding.ivEjercicioMusculo)

        db = AppDataBase.getInstance(this)!!

        binding.btnAAdir.setOnClickListener {
            runBlocking {
                GlobalScope.launch {
                    if (binding.etSets.text.isNotEmpty() && binding.etReps.text.isNotEmpty() && binding.etPeso.text.isNotEmpty()) {
                        Log.i("-->", "Primer if comprobando que los datos no estén vacíos")
                        if (binding.etSets.text.toString().toIntOrNull() != null) {
                            Log.i("-->", "Segundo if comprobando que Sets sea Int")
                            if (binding.etReps.text.toString().toIntOrNull() != null) {
                                Log.i("-->", "Segundo if comprobando que los Reps sea Int")
                                if (binding.etPeso.text.toString().toDoubleOrNull() != null) {
                                    Log.i("-->", "Segundo if comprobando que los Peso sea Double")

                                    db.ejercicioDao().insertEjercicio(
                                        Ejercicio(
                                            intent.getStringExtra("Musculo")!!,
                                            intent.getStringExtra("Dia_semana")!!,
                                            intent.getStringExtra("Photo")!!,
                                            binding.etSets.text.toString().toIntOrNull(),
                                            binding.etReps.text.toString().toIntOrNull(),
                                            binding.etPeso.text.toString().toDoubleOrNull()
                                        )
                                    )
                                } else {
                                    //TODO: No sé como cambiar el color de texto por si está érroneo usando binding.
                                }
                            }
                        }
                    }

                    /*
                Test
                var listEje = db.ejercicioDao().getAllEjercicio()

                listEje.forEach {
                    Log.i("-------->", it.musculo + "\n\t" + it.photo + "\n\t" + it.rutinaDayOfWeek + "\n\t" + it.reps + "\n\t" + it.sets + "\n\t" + it.weight)
                }
                 */

                    Log.i(
                        "-->",
                        intent.getStringExtra("Musculo")!! + "\n\t" +
                                intent.getStringExtra("Dia_semana")!! + "\n\t" +
                                intent.getStringExtra("Photo")!! + "\n\t" +
                                binding.etSets.text.toString().toIntOrNull() + "\n\t" +
                                binding.etReps.text.toString().toIntOrNull() + "\n\t" +
                                binding.etPeso.text.toString().toDoubleOrNull()
                    )

                }
            }

            //TODO: Voy por aquí -> no consigue hacer el registerForActivityResult así que volveré a probar con Intent normal y corriente, suponemos que el Intent que me manda aquí debería mandarle los datos necesarios para poder volver a visualizar  el grupo muscular y no el músculo en sí que creo que es lo que estaba haciendo...
            val intent = Intent(this, MusculoDeGrupoMuscularActivity::class.java).apply {
                putExtra("Grupo_Muscular", intent.getStringExtra("Grupo_Muscular"))
                putExtra("Dia_semana", intent.getStringExtra("Dia_semana"))
                //putExtra("Musculo", intent.getStringExtra("Musculo"))
            }
            startActivity(intent)
        }
    }
}