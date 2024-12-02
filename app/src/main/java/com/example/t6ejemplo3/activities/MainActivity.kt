package com.example.t6ejemplo3.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.t6ejemplo3.R
import com.example.t6ejemplo3.databinding.ActivityMainBinding
import com.example.t6ejemplo3.fragments.CorreosListener
import com.example.t6ejemplo3.fragments.DetailFragment
import com.example.t6ejemplo3.fragments.ListFragment
import com.example.t6ejemplo3.pojo.Correo

class MainActivity : AppCompatActivity(), CorreosListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val frgListado: ListFragment =
            supportFragmentManager.findFragmentById(binding.frgListado.id) as ListFragment

        frgListado.setCorreosListener(this)
    }



    override fun onCorreoSeleccionado(correo: Correo) {
        if (correo != null){
            var hayDetalle = supportFragmentManager.findFragmentById(R.id.frgDetalle) != null

            if(hayDetalle){//Se muestra el contenido en la misma Activity
                val detailFragment = DetailFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frgDetalle, detailFragment)
                transaction.commitNow()
                detailFragment.mostrarDetalle(correo.getTexto())
            }else{
                val i = Intent(this, DetailActivity::class.java)
                i.putExtra("TextoDetalle", correo.getTexto())
                startActivity(i)
            }
        }
    }
}