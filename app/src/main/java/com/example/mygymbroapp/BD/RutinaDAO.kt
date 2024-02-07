package com.example.mygymbroapp.BD

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.REPLACE

@Dao
interface RutinaDAO {
    //DAO de la data class Rutina.
    @Query("SELECT * FROM rutina")
    fun getAllRutina(): List<Rutina>

    @Insert(onConflict = REPLACE)
    fun insertRutina(rutina: Rutina)

    @Delete
    fun deleteRutina(rutina: Rutina)

    @Transaction
    @Query("SELECT * FROM rutina")
    fun getAllRutinasEjercicios(): Array<EjerciciosRutina>
}

@Dao
interface EjercicioDao{
    //DAO de la data class Ejercicios.
    @Query("SELECT * FROM ejercicio")
    fun getAllEjercicio(): List<Ejercicio>

    @Insert(onConflict = REPLACE)
    fun insertEjercicio(ejercicio: Ejercicio)

    @Delete
    fun deleteEjercicio(ejercicio: Ejercicio)
}
/* TODO: Parece érroneo.
@Dao interface EjerciciosRutinaDao{
    //DAO de la relación 1 a n EjerciciosRutina
    @Query("SELECT * FROM ejerciciosrutina")
}
 */