package com.salvatoreacademy.sa_android_nativo_iniciante_app1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

        // Buscar elemento pelo ID e armazenar em variável (val ou var)
        val cvCreature = findViewById<CardView>(R.id.cvCreature)

        // Criar um Listener de clique para o elemento
        cvCreature.setOnClickListener {
            // Comportamento que será executado ao clicar no elemento
            Toast.makeText(this, "CardView clicado!", Toast.LENGTH_SHORT).show()

            // Abrir uma nova Activity
            // Criamos a Intent
            val newActivityIntent = Intent(this, CreatureViewActivity::class.java)

            // Registramos a Intent com o resultado esperado (abrir activity)
            startActivity(newActivityIntent)
        }
    }
}