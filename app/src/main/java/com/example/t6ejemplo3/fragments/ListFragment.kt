package com.example.t6ejemplo3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t6ejemplo3.adapters.CorreoAdapter
import com.example.t6ejemplo3.adapters.OnClickListener
import com.example.t6ejemplo3.databinding.FragmentListBinding
import com.example.t6ejemplo3.pojo.Correo
import com.example.t6ejemplo3.pojo.CorreoDatos

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment(), OnClickListener {
    private lateinit var correoAdapter: CorreoAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var itemDecoration: DividerItemDecoration

    private lateinit var binding: FragmentListBinding

    private lateinit var listener: CorreosListener

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)

        correoAdapter = CorreoAdapter(CorreoDatos.CORREOS, this)
        linearLayoutManager = LinearLayoutManager(context)
        itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.recyclerIdList.apply{
            layoutManager = linearLayoutManager
            adapter = correoAdapter
            addItemDecoration(itemDecoration)
        }
        return binding.root
    }

    override fun onClick(correo: Correo) {
        if (listener != null){
            listener.onCorreoSeleccionado(correo)
        }

    }
    fun setCorreosListener(listener: CorreosListener){
        this.listener=listener
    }



}