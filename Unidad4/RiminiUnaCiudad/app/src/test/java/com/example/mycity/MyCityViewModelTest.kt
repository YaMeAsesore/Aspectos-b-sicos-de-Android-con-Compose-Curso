package com.example.mycity

import com.example.mycity.data.Datasource
import com.example.mycity.model.MyCityScreen
import com.example.mycity.viewmodel.MyCityViewModel
import org.junit.Assert.assertEquals
import org.junit.Test

class MyCityViewModelTest {

    private val viewModel = MyCityViewModel()

    @Test
    fun updateSelectedScreen_fromWelcome_toCategories() {

        var currentScreen = viewModel.uiState.value.selectedScreen
        assertEquals(MyCityScreen.Welcome, currentScreen)


        val newScreen = MyCityScreen.Categories
        viewModel.updateSelectedScreen(newScreen)


        currentScreen = viewModel.uiState.value.selectedScreen
        assertEquals(newScreen, currentScreen)
    }

    @Test
    fun updateSelectedCategory_fromLunchAndDinner_toCulture() {

        var currentCategory = viewModel.uiState.value.selectedCategory
        assertEquals(Datasource.getCategories()[0], currentCategory)


        val newCategory = Datasource.getCategories()[5]
        viewModel.updateSelectedCategory(newCategory)


        currentCategory = viewModel.uiState.value.selectedCategory
        assertEquals(newCategory, currentCategory)
        assertEquals(Datasource.getEntries(currentCategory.id)[0], viewModel.uiState.value.selectedEntry)
        assertEquals(MyCityScreen.Entries, viewModel.uiState.value.selectedScreen)
    }

    @Test
    fun updateSelectedEntry_fromFirstEntry_toLastEntry() {

        val currentCategory = viewModel.uiState.value.selectedCategory
        var currentEntry = viewModel.uiState.value.selectedEntry
        assertEquals(Datasource.getEntries(currentCategory.id)[0], currentEntry)


        val newEntry = Datasource.getEntries(currentCategory.id)[7]
        viewModel.updateSelectedEntry(newEntry)


        currentEntry = viewModel.uiState.value.selectedEntry
        assertEquals(newEntry, currentEntry)
        assertEquals(MyCityScreen.Details, viewModel.uiState.value.selectedScreen)
    }
}