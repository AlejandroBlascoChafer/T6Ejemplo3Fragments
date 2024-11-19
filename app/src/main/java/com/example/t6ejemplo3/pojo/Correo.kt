package com.example.t6ejemplo3.pojo

class Correo (private var de: String, private var asunto: String, private var texto:
String) {
    fun getDe(): String {
        return de
    }

    fun getAsunto(): String {
        return asunto
    }

    fun getTexto(): String {
        return texto
    }
}

class CorreoDatos{
    companion object{
        val CORREOS = arrayListOf<Correo>(
            Correo("Persona 1", "Asunto del correo 1", "Texto del correo 1"),
            Correo("Persona 2", "Asunto del correo 2", "Texto del correo 2"),
            Correo("Persona 3", "Asunto del correo 3", "Texto del correo 3"),
            Correo("Persona 4", "Asunto del correo 4", "Texto del correo 4"),
            Correo("Persona 5", "Asunto del correo 5", "Texto del correo 5"),
            Correo("Persona 6", "Asunto del correo 6", "Texto del correo 6")
        )
    }
}