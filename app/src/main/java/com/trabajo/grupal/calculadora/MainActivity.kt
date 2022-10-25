package com.trabajo.grupal.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var numero: Double = 0.0
    lateinit var textView1: TextView
    lateinit var textView2: TextView
    var operacion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView2)
    }

    fun oprimirNumero(view: View){
        var numeroDos: String = textView2.text.toString()

        when(view.id){
            R.id.but_0 -> textView2.setText(numeroDos + "0")
            R.id.but_1 -> textView2.setText(numeroDos + "1")
            R.id.but_2 -> textView2.setText(numeroDos + "2")
            R.id.but_3 -> textView2.setText(numeroDos + "3")
            R.id.but_4 -> textView2.setText(numeroDos + "4")
            R.id.but_5 -> textView2.setText(numeroDos + "5")
            R.id.but_6 -> textView2.setText(numeroDos + "6")
            R.id.but_7 -> textView2.setText(numeroDos + "7")
            R.id.but_8 -> textView2.setText(numeroDos + "8")
            R.id.but_9 -> textView2.setText(numeroDos + "9")
            R.id.but_decimal -> textView2.setText(numeroDos + ".")
        }
    }

    fun oprimirOperacion(view: View){
        numero = textView2.text.toString().toDouble()
        textView2.setText("")
        var numeroDosTexto: String = textView2.text.toString()

        when(view.id){
            R.id.but_suma -> {
                textView1.setText(numeroDosTexto + "+")
                operacion = 1;
            }
            R.id.but_restar -> {
                textView1.setText(numeroDosTexto + "-")
                operacion = 2;
            }
            R.id.but_multiplicar -> {
                textView1.setText(numeroDosTexto + "*")
                operacion = 3;
            }
            R.id.but_dividir -> {
                textView1.setText(numeroDosTexto + "/")
                operacion = 4;
            }
        }
    }

    fun oprimirBorrar(view: View){
        val borrar: Button = findViewById(R.id.but_borrar)
        textView1.setText("")
        textView2.setText("")
    }
}