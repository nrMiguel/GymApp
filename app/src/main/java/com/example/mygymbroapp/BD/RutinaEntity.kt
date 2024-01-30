package com.example.mygymbroapp.BD

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.time.DayOfWeek

@Entity
data class Rutina(
    @PrimaryKey val dayOfWeek: String,
    val grupoMuscular: String
)
@Entity
data class Ejercicio (
    @PrimaryKey val musculo: String,
    val rutinaDayOfWeek: Int,
    val photo: String?, //TODO: Puede que esto lo pueda suprimir buscando directamente en los providers por el nombre del músculo y del grupo muscular.
    val sets: Int?,
    val reps: Int?,
    val weight: Double?
)

data class EjerciciosRutina(
    @Embedded val day: Rutina,
    @Relation(
        parentColumn = "dayOfWeek",
        entityColumn = "rutinaDayOfWeek"
    )
    val ejercicios: List<Ejercicio>
)