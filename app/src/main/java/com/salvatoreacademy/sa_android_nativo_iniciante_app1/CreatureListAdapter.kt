package com.salvatoreacademy.sa_android_nativo_iniciante_app1

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CreatureListAdapter(private val items: List<Creature>) : RecyclerView.Adapter<CreatureListAdapter.CreatureViewHolder>() {

    class CreatureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Creature) {
            // Exibição do Número
            val tvNumber = itemView.findViewById<TextView>(R.id.tvNumber)
            tvNumber.text = item.number.toString()

            // Exibição do Nome
            val tvName = itemView.findViewById<TextView>(R.id.tvName)
            tvName.text = item.name

            // Carregamento da Imagem com Glide
            val ivCreature = itemView.findViewById<ImageView>(R.id.ivCreature)
            Glide.with(itemView).load(item.image).into(ivCreature)

            // Buscar elemento pelo ID e armazenar em variável (val ou var)
            val cvCreature = itemView.findViewById<CardView>(R.id.cvCreature)

            // Criar um Listener de clique para o elemento
            cvCreature.setOnClickListener {
                // Comportamento que será executado ao clicar no elemento
                Toast.makeText(itemView.context, "CardView clicado!", Toast.LENGTH_SHORT).show()

                // Abrir uma nova Activity
                // Criamos a Intent
                val newActivityIntent = Intent(itemView.context, CreatureViewActivity::class.java)

                // Registramos a Intent com o resultado esperado (abrir activity)
                itemView.context.startActivity(newActivityIntent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreatureViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_creature_item, parent, false)
        return CreatureViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CreatureViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item)
    }
}
