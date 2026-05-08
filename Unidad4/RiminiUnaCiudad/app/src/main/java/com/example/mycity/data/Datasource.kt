package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.model.Category
import com.example.mycity.model.Entry

object Datasource {
    fun getCategories(): List<Category> = listOf(
        Category(
            id = 1,
            name = R.string.category_1_name,
            image = R.drawable.ic_restaurant
        ),
        Category(
            id = 2,
            name = R.string.category_2_name,
            image = R.drawable.ic_breakfast
        ),
        Category(
            id = 3,
            name = R.string.category_3_name,
            image = R.drawable.ic_hotel
        ),
        Category(
            id = 4,
            name = R.string.category_4_name,
            image = R.drawable.ic_beach
        ),
        Category(
            id = 5,
            name = R.string.category_5_name,
            image = R.drawable.ic_entertainment
        ),
        Category(
            id = 6,
            name = R.string.category_6_name,
            image = R.drawable.ic_culture
        )
    )

    fun getEntries(category: Int): List<Entry> = when (category) {
        1 -> listOf(
            Entry(
                id = 11,
                name = R.string.restaurant_1_name,
                rate = R.string.restaurant_1_rate,
                address = R.string.restaurant_1_address,
                description = R.string.restaurant_1_description,
                image = R.drawable.restaurant_1_image
            ),
            Entry(
                id = 12,
                name = R.string.restaurant_2_name,
                rate = R.string.restaurant_2_rate,
                address = R.string.restaurant_2_address,
                description = R.string.restaurant_2_description,
                image = R.drawable.restaurant_2_image
            ),
            Entry(
                id = 13,
                name = R.string.restaurant_3_name,
                rate = R.string.restaurant_3_rate,
                address = R.string.restaurant_3_address,
                description = R.string.restaurant_3_description,
                image = R.drawable.restaurant_3_image
            ),
            Entry(
                id = 14,
                name = R.string.restaurant_4_name,
                rate = R.string.restaurant_4_rate,
                address = R.string.restaurant_4_address,
                description = R.string.restaurant_4_description,
                image = R.drawable.restaurant_4_image
            ),
            Entry(
                id = 15,
                name = R.string.restaurant_5_name,
                rate = R.string.restaurant_5_rate,
                address = R.string.restaurant_5_address,
                description = R.string.restaurant_5_description,
                image = R.drawable.restaurant_5_image
            ),
            Entry(
                id = 16,
                name = R.string.restaurant_6_name,
                rate = R.string.restaurant_6_rate,
                address = R.string.restaurant_6_address,
                description = R.string.restaurant_6_description,
                image = R.drawable.restaurant_6_image
            ),
            Entry(
                id = 17,
                name = R.string.restaurant_7_name,
                rate = R.string.restaurant_7_rate,
                address = R.string.restaurant_7_address,
                description = R.string.restaurant_7_description,
                image = R.drawable.restaurant_7_image
            ),
            Entry(
                id = 18,
                name = R.string.restaurant_8_name,
                rate = R.string.restaurant_8_rate,
                address = R.string.restaurant_8_address,
                description = R.string.restaurant_8_description,
                image = R.drawable.restaurant_8_image
            )
        )

        2 -> listOf(
            Entry(
                id = 21,
                name = R.string.breakfast_1_name,
                rate = R.string.breakfast_1_rate,
                address = R.string.breakfast_1_address,
                description = R.string.breakfast_1_description,
                image = R.drawable.breakfast_1_image
            ),
            Entry(
                id = 22,
                name = R.string.breakfast_2_name,
                rate = R.string.breakfast_2_rate,
                address = R.string.breakfast_2_address,
                description = R.string.breakfast_2_description,
                image = R.drawable.breakfast_2_image
            ),
            Entry(
                id = 23,
                name = R.string.breakfast_3_name,
                rate = R.string.breakfast_3_rate,
                address = R.string.breakfast_3_address,
                description = R.string.breakfast_3_description,
                image = R.drawable.breakfast_3_image
            ),
            Entry(
                id = 24,
                name = R.string.breakfast_4_name,
                rate = R.string.breakfast_4_rate,
                address = R.string.breakfast_4_address,
                description = R.string.breakfast_4_description,
                image = R.drawable.breakfast_4_image
            ),
            Entry(
                id = 25,
                name = R.string.breakfast_5_name,
                rate = R.string.breakfast_5_rate,
                address = R.string.breakfast_5_address,
                description = R.string.breakfast_5_description,
                image = R.drawable.breakfast_5_image
            )
        )

        3 -> listOf(
            Entry(
                id = 31,
                name = R.string.hotel_1_name,
                rate = R.string.hotel_1_rate,
                address = R.string.hotel_1_address,
                description = R.string.hotel_1_description,
                image = R.drawable.hotel_1_image
            ),
            Entry(
                id = 32,
                name = R.string.hotel_2_name,
                rate = R.string.hotel_2_rate,
                address = R.string.hotel_2_address,
                description = R.string.hotel_2_description,
                image = R.drawable.hotel_2_image
            ),
            Entry(
                id = 33,
                name = R.string.hotel_3_name,
                rate = R.string.hotel_3_rate,
                address = R.string.hotel_3_address,
                description = R.string.hotel_3_description,
                image = R.drawable.hotel_3_image
            ),
            Entry(
                id = 34,
                name = R.string.hotel_4_name,
                rate = R.string.hotel_4_rate,
                address = R.string.hotel_4_address,
                description = R.string.hotel_4_description,
                image = R.drawable.hotel_4_image
            ),
            Entry(
                id = 35,
                name = R.string.hotel_5_name,
                rate = R.string.hotel_5_rate,
                address = R.string.hotel_5_address,
                description = R.string.hotel_5_description,
                image = R.drawable.hotel_5_image
            ),
            Entry(
                id = 36,
                name = R.string.hotel_6_name,
                rate = R.string.hotel_6_rate,
                address = R.string.hotel_6_address,
                description = R.string.hotel_6_description,
                image = R.drawable.hotel_6_image
            )
        )

        4 -> listOf(
            Entry(
                id = 41,
                name = R.string.beach_1_name,
                rate = R.string.beach_1_rate,
                address = R.string.beach_1_address,
                description = R.string.beach_1_description,
                image = R.drawable.beach_1_image
            ),
            Entry(
                id = 42,
                name = R.string.beach_2_name,
                rate = R.string.beach_2_rate,
                address = R.string.beach_2_address,
                description = R.string.beach_2_description,
                image = R.drawable.beach_2_image
            ),
            Entry(
                id = 43,
                name = R.string.beach_3_name,
                rate = R.string.beach_3_rate,
                address = R.string.beach_3_address,
                description = R.string.beach_3_description,
                image = R.drawable.beach_3_image
            ),
            Entry(
                id = 44,
                name = R.string.beach_4_name,
                rate = R.string.beach_4_rate,
                address = R.string.beach_4_address,
                description = R.string.beach_4_description,
                image = R.drawable.beach_4_image
            ),
            Entry(
                id = 45,
                name = R.string.beach_5_name,
                rate = R.string.beach_5_rate,
                address = R.string.beach_5_address,
                description = R.string.beach_5_description,
                image = R.drawable.beach_5_image
            )
        )

        5 -> listOf(
            Entry(
                id = 51,
                name = R.string.entertainment_1_name,
                rate = R.string.entertainment_1_rate,
                address = R.string.entertainment_1_address,
                description = R.string.entertainment_1_description,
                image = R.drawable.entertainment_1_image
            ),
            Entry(
                id = 52,
                name = R.string.entertainment_2_name,
                rate = R.string.entertainment_2_rate,
                address = R.string.entertainment_2_address,
                description = R.string.entertainment_2_description,
                image = R.drawable.entertainment_2_image
            ),
            Entry(
                id = 53,
                name = R.string.entertainment_3_name,
                rate = R.string.entertainment_3_rate,
                address = R.string.entertainment_3_address,
                description = R.string.entertainment_3_description,
                image = R.drawable.entertainment_3_image
            ),
            Entry(
                id = 54,
                name = R.string.entertainment_4_name,
                rate = R.string.entertainment_4_rate,
                address = R.string.entertainment_4_address,
                description = R.string.entertainment_4_description,
                image = R.drawable.entertainment_4_image
            ),
            Entry(
                id = 55,
                name = R.string.entertainment_5_name,
                rate = R.string.entertainment_5_rate,
                address = R.string.entertainment_5_address,
                description = R.string.entertainment_5_description,
                image = R.drawable.entertainment_5_image
            ),
            Entry(
                id = 56,
                name = R.string.entertainment_6_name,
                rate = R.string.entertainment_6_rate,
                address = R.string.entertainment_6_address,
                description = R.string.entertainment_6_description,
                image = R.drawable.entertainment_6_image
            )
        )

        6 -> listOf(
            Entry(
                id = 61,
                name = R.string.culture_1_name,
                rate = R.string.culture_1_rate,
                address = R.string.culture_1_address,
                description = R.string.culture_1_description,
                image = R.drawable.culture_1_image
            ),
            Entry(
                id = 62,
                name = R.string.culture_2_name,
                rate = R.string.culture_2_rate,
                address = R.string.culture_2_address,
                description = R.string.culture_2_description,
                image = R.drawable.culture_2_image
            ),
            Entry(
                id = 63,
                name = R.string.culture_3_name,
                rate = R.string.culture_3_rate,
                address = R.string.culture_3_address,
                description = R.string.culture_3_description,
                image = R.drawable.culture_3_image
            ),
            Entry(
                id = 64,
                name = R.string.culture_4_name,
                rate = R.string.culture_4_rate,
                address = R.string.culture_4_address,
                description = R.string.culture_4_description,
                image = R.drawable.culture_4_image
            ),
            Entry(
                id = 65,
                name = R.string.culture_5_name,
                rate = R.string.culture_5_rate,
                address = R.string.culture_5_address,
                description = R.string.culture_5_description,
                image = R.drawable.culture_5_image
            ),
            Entry(
                id = 66,
                name = R.string.culture_6_name,
                rate = R.string.culture_6_rate,
                address = R.string.culture_6_address,
                description = R.string.culture_6_description,
                image = R.drawable.culture_6_image
            ),
            Entry(
                id = 67,
                name = R.string.culture_7_name,
                rate = R.string.culture_7_rate,
                address = R.string.culture_7_address,
                description = R.string.culture_7_description,
                image = R.drawable.culture_7_image
            ),
        )

        else -> listOf()
    }
}