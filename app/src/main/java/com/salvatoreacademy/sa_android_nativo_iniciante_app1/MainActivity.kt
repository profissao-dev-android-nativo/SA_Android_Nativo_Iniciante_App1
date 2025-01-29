package com.salvatoreacademy.sa_android_nativo_iniciante_app1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

        // Busca a RecyclerView pelo ID
        val rvCreatures = findViewById<RecyclerView>(R.id.rvCreatures)

        val items = listOf(
            Creature(1, "Java", "https://www.salvatore.academy/devmon/1_java.png"),
            Creature(2, "Kotlin", "https://www.salvatore.academy/devmon/2_kotlin.png"),
            Creature(3, "Android", "https://www.salvatore.academy/devmon/3_android.png")
        )

        // Adicionamos o Adapter (customizado) e o LayoutManager (fornecido pelo Android)
        rvCreatures.adapter = CreatureListAdapter(items)
        rvCreatures.layoutManager = LinearLayoutManager(this)
    }
}