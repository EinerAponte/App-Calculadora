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
    lateinit var textView3: TextView
    var operacion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val oprimirResultado: Button = findViewById(R.id.but_resultado)
        val oprimirBorrar: Button = findViewById(R.id.but_borrar)
        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView2)
        textView3 = findViewById(R.id.textView)

        oprimirResultado.setOnClickListener{
            var num2 = textView2.text.toString().toDouble()
            var res = 0.0
            when(operacion){
                1-> res = numero + num2
                2-> res = numero - num2
                3-> res = numero * num2
                4-> {
                    if(num2 == 0.0){
                        textView3.setText("[Error] No se puede dividir por 0")
                        return@setOnClickListener
                    } else{
                        textView3.setText("")
                        res = numero / num2
                    }

                }
            }
            textView2.setText(res.toString())
            textView1.setText("")
        }

        oprimirBorrar.setOnClickListener{
            textView1.setText("")
            textView2.setText("")
            operacion = 0
        }
    }

    fun oprimirNumero(view: View){
        var numeroDos: String = textView2.text.toString()
        var bandera: Boolean = false;

        when(view.id){
            R.id.but_0 -> numeroInicialCero(numeroDos, "0")
            R.id.but_1 -> numeroInicialCero(numeroDos, "1")
            R.id.but_2 -> numeroInicialCero(numeroDos, "2")
            R.id.but_3 -> numeroInicialCero(numeroDos, "3")
            R.id.but_4 -> numeroInicialCero(numeroDos, "4")
            R.id.but_5 -> numeroInicialCero(numeroDos, "5")
            R.id.but_6 -> numeroInicialCero(numeroDos, "6")
            R.id.but_7 -> numeroInicialCero(numeroDos, "7")
            R.id.but_8 -> numeroInicialCero(numeroDos, "8")
            R.id.but_9 -> numeroInicialCero(numeroDos, "9")
            R.id.but_decimal -> {
                for (caracter in numeroDos){
                    if (caracter == '.'){
                        bandera = true
                    }
                }
                if (bandera == true){
                    textView3.setText("[Error] No puedes insertar mas de un punto decimal")
                } else{
                    textView2.setText(numeroDos+".")
                }
            }
        }
        bandera = false;
    }

    fun numeroInicialCero(numeroString: String, indicador: String){
        if (numeroString == "0"){
            textView2.setText(indicador)
            textView3.setText("")
        } else{
            textView2.setText(numeroString + indicador)
            textView3.setText("")
        }
    }
    fun oprimirOperacion(view: View){
        var num2 = textView2.text.toString()
        numero = num2.toString().toDouble()
        textView2.setText("")

        when(view.id){
            R.id.but_suma -> {
                textView1.setText(num2 + "+")
                operacion = 1;
            }
            R.id.but_restar -> {
                textView1.setText(num2 + "-")
                operacion = 2;
            }
            R.id.but_multiplicar -> {
                textView1.setText(num2 + "*")
                operacion = 3;
            }
            R.id.but_dividir -> {
                textView1.setText(num2 + "/")
                operacion = 4;
            }
        }
    }

}