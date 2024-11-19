package com.example.t6ejemplo3.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.t6ejemplo3.R
import com.example.t6ejemplo3.databinding.ListItemCorreoBinding
import com.example.t6ejemplo3.fragments.ListFragment
import com.example.t6ejemplo3.pojo.Correo

class CorreoAdapter(private val correos: List<Correo>, private val listener: OnClickListener):
    RecyclerView.Adapter<CorreoAdapter.ViewHolder>(){
    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_correo,
            parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int = correos.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val correo = correos.get(position)
        with(holder){
            setListener(correo)
            binding.tvDe.text = correo.getDe()
            binding.tvAsunto.text = correo.getAsunto()
        }
    }
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val binding = ListItemCorreoBinding.bind(view)
        fun setListener(correo:Correo){
            binding.root.setOnClickListener {
                listener.onClick(correo)
            }
        }
    }
}