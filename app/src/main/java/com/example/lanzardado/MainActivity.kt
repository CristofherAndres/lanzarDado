package com.example.lanzardado

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val lanzarDado = findViewById<MaterialButton>(R.id.btnLanzar)

        lanzarDado.setOnClickListener{
            fnLanzarDados()
        }

    }

    private fun fnLanzarDados() {

        try {
            //Generar numero aleatorio 1 al 6
            val numero: Int = (1..6).random()
            Toast.makeText(this, "Número: $numero", Toast.LENGTH_SHORT).show()

            //Obtener la imagen del dado
            val imgDado: ImageView = findViewById(R.id.imgDados)
            when (numero) {
                1 -> imgDado.setImageResource(R.drawable.dado1)
                2 -> imgDado.setImageResource(R.drawable.dado2)
                3 -> imgDado.setImageResource(R.drawable.dado3)
                4 -> imgDado.setImageResource(R.drawable.dado4)
                5 -> imgDado.setImageResource(R.drawable.dado5)
                6 -> imgDado.setImageResource(R.drawable.dado6)
            }

        } catch (e: Exception) {
            Log.e("Error LanzarDado", e.message.toString())
        }


    }
}










