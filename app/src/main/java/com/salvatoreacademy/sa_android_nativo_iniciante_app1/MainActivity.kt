package com.salvatoreacademy.sa_android_nativo_iniciante_app1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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

        // Construimos a instância do Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://devmon-api.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        
        val service = retrofit.create(CreatureApiService::class.java)
        val call = service.listCreatures()
        call.enqueue(object : Callback<List<Creature>> {
            // Caso a resposta da API seja bem sucedida, executa o onResponse
            override fun onResponse(p0: Call<List<Creature>>, response: Response<List<Creature>>) {
                Toast.makeText(
                    this@MainActivity,
                    "Lista de criaturas carregada com sucesso!",
                    Toast.LENGTH_SHORT
                ).show()

                response.body()?.let {
                    // Busca a RecyclerView pelo ID
                    val rvCreatures = findViewById<RecyclerView>(R.id.rvCreatures)

//                    val items = listOf(
//                        Creature(1, "Java", "https://www.salvatore.academy/devmon/1_java.png"),
//                        Creature(2, "Kotlin", "https://www.salvatore.academy/devmon/2_kotlin.png"),
//                        Creature(3, "Android", "https://www.salvatore.academy/devmon/3_android.png")
//                    )

                    // Adicionamos o Adapter (customizado) e o LayoutManager (fornecido pelo Android)
                    rvCreatures.adapter = CreatureListAdapter(it)
                    rvCreatures.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            // Caso a resposta da API dê erro, executa o onFailure
            override fun onFailure(p0: Call<List<Creature>>, p1: Throwable) {
                Toast.makeText(
                    this@MainActivity,
                    "Erro ao carregar criaturas.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}