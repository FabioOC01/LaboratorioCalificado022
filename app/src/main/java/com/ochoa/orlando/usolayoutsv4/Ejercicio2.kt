package com.ochoa.orlando.usolayoutsv4

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ochoa.orlando.usolayoutsv4.databinding.ActivityEjercicio2Binding

class Ejercicio2 : AppCompatActivity() {


    private lateinit var binding: ActivityEjercicio2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEjercicio2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegistrar.setOnClickListener {
            val nombre = binding.nombreCliente.text.toString()
            val numero = binding.numeroCliente.text.toString()

            if (validarInputs()) {
                val intent = Intent(this, Ejercicio2Pag2::class.java)
                intent.putExtra("nombreCliente", binding.nombreCliente.text.toString())
                intent.putExtra("numeroCliente", binding.numeroCliente.text.toString())
                intent.putExtra("productos", binding.productos.text.toString())
                intent.putExtra("ciudad", binding.ciudad.text.toString())
                intent.putExtra("direccion", binding.direccion.text.toString())
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, complete todos los campos.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validarInputs(): Boolean {
        return binding.nombreCliente.text.isNotEmpty() &&
                binding.numeroCliente.text.isNotEmpty() &&
                binding.productos.text.isNotEmpty() &&
                binding.ciudad.text.isNotEmpty() &&
                binding.direccion.text.isNotEmpty()
    }
}
