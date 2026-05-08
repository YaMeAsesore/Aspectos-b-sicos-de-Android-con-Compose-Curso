package com.example.mycity.model

data class UiState(
    val selectedCategory: Category,
    val selectedEntry: Entry,
    val selectedScreen: MyCityScreen = MyCityScreen.Welcome
)

enum class MyCityScreen {
    Welcome, Categories, Entries, Details
}
