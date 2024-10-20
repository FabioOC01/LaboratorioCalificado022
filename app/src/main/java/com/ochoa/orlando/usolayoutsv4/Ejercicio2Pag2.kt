package com.ochoa.orlando.usolayoutsv4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Ejercicio2Pag2 : AppCompatActivity() {
    private lateinit var btnLlamar: Button
    private lateinit var btnWSP: Button
    private lateinit var btnMaps: Button
    private lateinit var tvNombreCliente: TextView
    private lateinit var tvNumeroCliente: TextView
    private lateinit var tvProductos: TextView
    private lateinit var tvDireccion: TextView

    private lateinit var nombreCliente: String
    private lateinit var numeroCliente: String
    private lateinit var productos: String
    private lateinit var direccion: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2_pag2)

        nombreCliente = intent.getStringExtra("nombreCliente") ?: ""
        numeroCliente = intent.getStringExtra("numeroCliente") ?: ""
        productos = intent.getStringExtra("productos") ?: ""
        direccion = intent.getStringExtra("direccion") ?: ""

        tvNombreCliente = findViewById(R.id.infoNombre)
        tvNumeroCliente = findViewById(R.id.infoNumero)
        tvProductos = findViewById(R.id.infoProductos)
        tvDireccion = findViewById(R.id.infoDireccion)

        tvNombreCliente.text = "Nombre: $nombreCliente"
        tvNumeroCliente.text = "Número: $numeroCliente"
        tvProductos.text = "Productos: $productos"
        tvDireccion.text = "Dirección: $direccion"

        btnLlamar = findViewById(R.id.btnLlamar)
        btnWSP = findViewById(R.id.btnWSP)
        btnMaps = findViewById(R.id.btnMaps)

        btnLlamar.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$numeroCliente")
            startActivity(intent)
        }

        btnWSP.setOnClickListener {
            val mensaje = "Hola $nombreCliente, tus productos: $productos están en camino a la dirección: $direccion"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://wa.me/?text=${Uri.encode(mensaje)}")
            startActivity(intent)
        }

        btnMaps.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("geo:0,0?q=$direccion")
            startActivity(intent)
        }
    }
}
