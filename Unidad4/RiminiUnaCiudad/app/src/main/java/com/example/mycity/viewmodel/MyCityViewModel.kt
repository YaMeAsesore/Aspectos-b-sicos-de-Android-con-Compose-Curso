package com.example.mycity.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mycity.data.Datasource
import com.example.mycity.model.Category
import com.example.mycity.model.Entry
import com.example.mycity.model.MyCityScreen
import com.example.mycity.model.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MyCityViewModel: ViewModel() {


    private val _uiState = MutableStateFlow(
        UiState(
            selectedCategory = Datasource.getCategories()[0],
            selectedEntry = Datasource.getEntries(1)[0],
        )
    )
    val uiState: StateFlow<UiState> = _uiState

    fun updateSelectedScreen(screen: MyCityScreen) {
        _uiState.update {
            it.copy(
                selectedScreen = screen
            )
        }
    }

    fun updateSelectedCategory(category: Category) {
        _uiState.value = UiState(
            selectedCategory = category,
            selectedEntry = Datasource.getEntries(category.id)[0],
            selectedScreen = MyCityScreen.Entries
        )
    }

    fun updateSelectedEntry(entry: Entry) {
        _uiState.update {
            it.copy(
                selectedEntry = entry,
                selectedScreen = MyCityScreen.Details
            )
        }
    }

}