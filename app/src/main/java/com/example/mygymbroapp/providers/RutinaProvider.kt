package com.example.mygymbroapp.providers

import com.example.mygymbroapp.clasesMusculos.Rutina

//TODO: Esto no pinta na ya que no hay provider ya que lo coge de la BD.
class RutinaProvider {
    companion object{
        var rutinaProviderList = mutableListOf<Rutina>()
    }
}