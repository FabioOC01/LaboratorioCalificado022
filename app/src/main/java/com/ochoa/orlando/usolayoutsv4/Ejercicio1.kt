package com.ochoa.orlando.usolayoutsv4

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ochoa.orlando.usolayoutsv4.databinding.ActivityEjercicio1Binding

class Ejercicio1 : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializa View Binding
        binding = ActivityEjercicio1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configura los botones Mostrar y Ocultar
        binding.btnMostrar.setOnClickListener {
            binding.greenView.visibility = View.VISIBLE
        }

        binding.btnOcultar.setOnClickListener {
            binding.greenView.visibility = View.GONE
        }
    }
}
