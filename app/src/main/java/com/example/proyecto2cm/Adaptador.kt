package com.example.proyecto2cm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.proyecto2cm.model.Numero

class Adaptador(private val contexto: Context, val datos: ArrayList<Numero>): BaseAdapter() {

    private val inflater: LayoutInflater = LayoutInflater.from(contexto)

    override fun getCount(): Int {
        return datos.size
    }

    override fun getItem(position: Int): Any {
        return datos[position]
    }

    override fun getItemId(position: Int): Long {
        return datos[position].id
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val vista = inflater!!.inflate(R.layout.elemento_lista,null)

        val tvNumb = vista.findViewById<TextView>(R.id.tvNumb)

        tvNumb.text = datos[position].num.toString()

        return vista

    }
}