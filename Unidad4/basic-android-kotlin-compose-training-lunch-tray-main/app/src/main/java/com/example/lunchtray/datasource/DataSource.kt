package com.example.lunchtray.datasource

import com.example.lunchtray.model.MenuItem.AccompanimentItem
import com.example.lunchtray.model.MenuItem.EntreeItem
import com.example.lunchtray.model.MenuItem.SideDishItem

object DataSource {

    val entreeMenuItems = listOf(
        EntreeItem(
            name = "Coliflor",
            description = "Coliflor entera, en salmuera, asada y frita",
            price = 7.00,
        ),
        EntreeItem(
            name = "Chili de Tres Frijoles",
            description = "Frijoles negros, rojos y bayos, cocidos a fuego lento, con cebolla",
            price = 4.00,
        ),
        EntreeItem(
            name = "Pasta con Champiñones",
            description = "Pasta penne, champiñones, albahaca y tomates ciruela cocinados en ajo y aceite de oliva",
            price = 5.50,
        ),
        EntreeItem(
            name = "Sartén de Frijoles Negros Picantes",
            description = "Verduras de temporada, frijoles negros, mezcla de especias de la casa, servidos con aguacate y cebollas encurtidas",
            price = 5.50,
        )
    )

    val sideDishMenuItems = listOf(
        SideDishItem(
            name = "Ensalada de Verano",
            description = "Tomates heirloom, lechuga mantequilla, duraznos, aguacate, aderezo balsámico",
            price = 2.50,
        ),
        SideDishItem(
            name = "Sopa de Calabaza",
            description = "Calabaza asada, pimientos asados, aceite de chile",
            price = 3.00,
        ),
        SideDishItem(
            name = "Papas Picantes",
            description = "Papas cambray, asadas y fritas en mezcla de especias de la casa",
            price = 2.00,
        ),
        SideDishItem(
            name = "Arroz con Coco",
            description = "Arroz, leche de coco, limón y azúcar",
            price = 1.50,
        )
    )

    val accompanimentMenuItems = listOf(
        AccompanimentItem(
            name = "Pan del Almuerzo",
            description = "Pan recién horneado en casa",
            price = 0.50,
        ),
        AccompanimentItem(
            name = "Mezcla de Frutos Rojos",
            description = "Fresas, arándanos, frambuesas y moras azules",
            price = 1.00,
        ),
        AccompanimentItem(
            name = "Verduras Encurtidas",
            description = "Pepinos y zanahorias encurtidos, preparados en casa",
            price = 0.50,
        )
    )
}