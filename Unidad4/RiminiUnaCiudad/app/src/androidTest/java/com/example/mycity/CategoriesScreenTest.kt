package com.example.mycity

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.test.assertAny
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.mycity.data.Datasource
import com.example.mycity.ui.theme.MyCityTheme
import com.example.mycity.viewmodel.MyCityViewModel
import org.junit.Rule
import org.junit.Test

class CategoriesScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun navigateToCategoriesScreen_compactSize_inspectContent() {

        composeTestRule.setContent {
            MyCityTheme {
                MyCityApp(widthSizeClass = WindowWidthSizeClass.Compact)
            }
        }


        composeTestRule
            .onNodeWithText(composeTestRule.activity.resources.getString(R.string.start_exploring))
            .performClick()


        composeTestRule
            .onNodeWithTag("TAG_CATEGORIES_GRID")
            .assertExists()
        composeTestRule
            .onNodeWithTag("TAG_APP_BAR")
            .assertExists()
        composeTestRule
            .onNodeWithTag("TAG_APP_BAR")
            .onChildren()
            .assertAny(hasText(composeTestRule.activity.resources.getString(R.string.start_exploring)))
    }

    @Test
    fun navigateToCategoriesScreen_mediumSize_inspectContent() {

        composeTestRule.setContent {
            MyCityTheme {
                MyCityApp(widthSizeClass = WindowWidthSizeClass.Medium)
            }
        }
        val viewModel = MyCityViewModel()
        val currentCategory = viewModel.uiState.value.selectedCategory


        composeTestRule
            .onNodeWithText(composeTestRule.activity.resources.getString(R.string.start_exploring))
            .performClick()


        composeTestRule
            .onNodeWithTag("TAG_ENTRIES_LIST")
            .assertExists()
        composeTestRule
            .onNodeWithTag("TAG_APP_BAR")
            .assertExists()
        composeTestRule
            .onNodeWithTag("TAG_APP_BAR")
            .onChildren()
            .assertAny(hasText(composeTestRule.activity.resources.getString(
                currentCategory.name
            )))


        val currentFirstEntry = Datasource.getEntries(currentCategory.id)[0]
        composeTestRule
            .onNodeWithText(composeTestRule.activity.resources.getString(currentFirstEntry.name))
            .assertExists()


        val categoryName = composeTestRule.activity.resources.getString(currentCategory.name)
        composeTestRule
            .onNodeWithTag("TAG_${categoryName.uppercase()}_NAVIGATION_RAIL")
            .assertIsSelected()
    }

    @Test
    fun navigateToCategoriesScreen_expandedSize_inspectContent() {

        composeTestRule.setContent {
            MyCityTheme {
                MyCityApp(widthSizeClass = WindowWidthSizeClass.Expanded)
            }
        }
        val viewModel = MyCityViewModel()
        val currentCategory = viewModel.uiState.value.selectedCategory
        val currentEntry = viewModel.uiState.value.selectedEntry


        composeTestRule
            .onNodeWithText(composeTestRule.activity.resources.getString(R.string.start_exploring))
            .performClick()


        composeTestRule
            .onNodeWithTag("TAG_ENTRIES_LIST")
            .assertExists()
        composeTestRule
            .onNodeWithText(composeTestRule.activity.resources.getString(
                R.string.general_address,
                composeTestRule.activity.resources.getString(currentEntry.address))
            )
            .assertExists()


        val categoryName = composeTestRule.activity.resources.getString(currentCategory.name)
        composeTestRule
            .onNodeWithTag("TAG_${categoryName.uppercase()}_NAVIGATION_DRAWER")
            .assertIsSelected()
    }

    @Test
    fun categoriesScreen_compactSize_upButtonShown() {

        composeTestRule.setContent {
            MyCityTheme {
                MyCityApp(widthSizeClass = WindowWidthSizeClass.Compact)
            }
        }

        // WHEN
        composeTestRule
            .onNodeWithText(composeTestRule.activity.resources.getString(R.string.start_exploring))
            .performClick()

        // THEN
        composeTestRule
            .onNodeWithContentDescription(composeTestRule.activity.resources.getString(R.string.navigate_up_button))
            .assertExists()
    }

    @Test
    fun categoriesScreen_mediumSize_upButtonShown() {

        composeTestRule.setContent {
            MyCityTheme {
                MyCityApp(widthSizeClass = WindowWidthSizeClass.Medium)
            }
        }


        composeTestRule
            .onNodeWithText(composeTestRule.activity.resources.getString(R.string.start_exploring))
            .performClick()


        composeTestRule
            .onNodeWithContentDescription(composeTestRule.activity.resources.getString(R.string.navigate_up_button))
            .assertExists()
    }

    @Test
    fun categoriesScreen_expandedSize_NoUpButtonShown() {

        composeTestRule.setContent {
            MyCityTheme {
                MyCityApp(widthSizeClass = WindowWidthSizeClass.Expanded)
            }
        }


        composeTestRule
            .onNodeWithText(composeTestRule.activity.resources.getString(R.string.start_exploring))
            .performClick()

        // THEN
        composeTestRule
            .onNodeWithContentDescription(composeTestRule.activity.resources.getString(R.string.navigate_up_button))
            .assertDoesNotExist()
    }
}