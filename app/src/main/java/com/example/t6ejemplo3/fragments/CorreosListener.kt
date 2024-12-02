package com.example.t6ejemplo3.fragments

import com.example.t6ejemplo3.pojo.Correo

interface CorreosListener {
    fun onCorreoSeleccionado(correo: Correo)
}