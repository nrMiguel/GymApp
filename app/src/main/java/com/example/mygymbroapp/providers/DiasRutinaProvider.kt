package com.example.mygymbroapp.providers

import com.example.mygymbroapp.clasesMusculos.DiasRutina

var iconoAñadir = "https://cdn-icons-png.flaticon.com/512/189/189689.png"

class DiasRutinaProvider {
    companion object{
        val diasRutinaList = mutableListOf<DiasRutina>(
            DiasRutina("Lunes", ""),
            DiasRutina("Martes", ""),
            DiasRutina("Miercoles", ""),
            DiasRutina("Jueves", ""),
            DiasRutina("Viernes", ""),
            DiasRutina("Sábado", ""),
            DiasRutina("Domingo", "")
        )

        val diasRutinaCrearList = mutableListOf<DiasRutina>(
            DiasRutina("Lunes", iconoAñadir),
            DiasRutina("Martes", iconoAñadir),
            DiasRutina("Miercoles", iconoAñadir),
            DiasRutina("Jueves", iconoAñadir),
            DiasRutina("Viernes", iconoAñadir),
            DiasRutina("Sábado", iconoAñadir),
            DiasRutina("Domingo", iconoAñadir)
        )
    }
}