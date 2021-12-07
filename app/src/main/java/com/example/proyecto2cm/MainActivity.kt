package com.example.proyecto2cm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import com.example.proyecto2cm.model.Numero
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var tvBienvenida: TextView
    private lateinit var etNumber: EditText
    private lateinit var btnSave: Button
    private lateinit var tvOrden: TextView
    private lateinit var btnMaymen: Button
    private lateinit var btnMenmay: Button

    val datos = ArrayList<Numero>()
    var i = 0
    val auxlist: MutableList<Int> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Vinculaciones
        tvBienvenida = findViewById(R.id.tvBienvenida)
        etNumber = findViewById(R.id.etNumber)
        btnSave = findViewById(R.id.btnSave)
        tvOrden = findViewById(R.id.tvOrden)
        btnMaymen = findViewById(R.id.btnMaymen)
        btnMenmay = findViewById(R.id.btnMenmay)



    }

    fun clicks(view: android.view.View){
        when(view.id){
            R.id.btnSave -> {
                //Acciones al clickear el boton
                if(etNumber.text.toString().length != 0){

                    val n = etNumber.text.toString().toInt()
                    auxlist.add(n)
                    val auxelement = auxlist.last()

                    val numtmp = Numero(i.toLong(),auxelement)

                    datos.add(numtmp)
                    i = i+1

                    etNumber.setText("")

                    val lv = findViewById<ListView>(R.id.lv)
                    lv.adapter = Adaptador(this,datos)


                }else{
                    etNumber.error = getString(R.string.errormsg)
                }
            }

            R.id.btnMenmay -> {
                val aux = auxlist.sorted()
                val numelement = auxlist.size
                datos.clear()
                for(i in 0 until numelement){
                    val auxelement = aux[i]
                    val numtmp = Numero(i.toLong(),auxelement)

                    datos.add(numtmp)
                }

                val lv = findViewById<ListView>(R.id.lv)
                lv.adapter = Adaptador(this,datos)

            }

            R.id.btnMaymen -> {
                val aux = auxlist.sortedDescending()
                val numelement = auxlist.size
                datos.clear()
                for(i in 0 until numelement){
                    val auxelement = aux[i]
                    val numtmp = Numero(i.toLong(),auxelement)

                    datos.add(numtmp)
                }

                val lv = findViewById<ListView>(R.id.lv)
                lv.adapter = Adaptador(this,datos)

            }
        }
    }

}