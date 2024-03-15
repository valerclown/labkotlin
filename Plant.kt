package com.example.plantapp
/**
 * Модель контакта
 */
data class Plant(
    val name: String,
    val description: String,
    val wateringFrequency: String,
    val lightRequirements: String
)
/**
 * Функция для создания списка контактов.
 */
fun planting() : List<Plant> = MutableList(20) { index ->
    Plant(
        name = "Plant $index",
        description = "Description for Plant $index" ,
        wateringFrequency = "How often for Plant $index",
        lightRequirements = "How much light for Plant $index"
    )
}
