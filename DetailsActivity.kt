package com.example.plantapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.MenuItem

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        // Установка Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Показ кнопки возврата
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")
        val watering = intent.getStringExtra("wateringFrequency")
        val light = intent.getStringExtra("lightRequirements")
        val formattedName = "Название растения: $name"
        val formattedDescription = "Описание растения: $description"
        val formattedWatering = "Частота полива: $watering"
        val formattedLight = "Требования к освещению: $light"


        findViewById<TextView>(R.id.details_name).text = formattedName
        findViewById<TextView>(R.id.details_description).text = formattedDescription
        findViewById<TextView>(R.id.details_frequency).text = formattedWatering
        findViewById<TextView>(R.id.details_light).text = formattedLight

        findViewById<Button>(R.id.search_button).setOnClickListener {
            // Неявный Intent для поиска информации о растении в интернете
            val searchIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=$name"))
            startActivity(searchIntent)
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Обработка нажатия на кнопку возврата
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
