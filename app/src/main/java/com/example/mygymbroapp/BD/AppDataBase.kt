package com.example.mygymbroapp.BD

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Rutina::class, Ejercicio::class], version = 4)

abstract class AppDataBase: RoomDatabase() {
    abstract fun rutinaDao(): RutinaDAO
    abstract fun ejercicioDao(): EjercicioDao

    companion object{
        private var INSTANCE: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase?{
            if (INSTANCE == null) {
                kotlin.synchronized(AppDataBase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDataBase::class.java, "rutinas.db"
                    ).fallbackToDestructiveMigration().build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance(){ INSTANCE = null }
    }
}