package com.example.plantapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.content.Context

class PlantAdapter(private val plants: List<Plant>) : RecyclerView.Adapter<PlantAdapter.PlantViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plantitem, parent, false)
        return PlantViewHolder(view) // Изменено: Убрана передача onItemClicked в ViewHolder
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        holder.bind(plants[position], holder.itemView.context) // Передаем контекст в bind
    }

    override fun getItemCount() = plants.size

    class PlantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) { // Убран параметр onItemClicked
        fun bind(plant: Plant, context: Context) { // Добавлен параметр context
            itemView.findViewById<TextView>(R.id.plant_name).text = plant.name
            itemView.findViewById<TextView>(R.id.plant_description).text = plant.description
            itemView.findViewById<TextView>(R.id.plant_frequency).text = plant.wateringFrequency

            itemView.setOnClickListener {
                val detailsIntent = Intent(context, DetailsActivity::class.java).apply {
                    putExtra("name", plant.name)
                    putExtra("description", plant.description)
                    putExtra("wateringFrequency", plant.wateringFrequency)
                    putExtra("lightRequirements", plant.lightRequirements)
                }
                context.startActivity(detailsIntent)
            }
        }
    }
}
