package com.example.mycity

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.mycity.data.Datasource
import com.example.mycity.ui.theme.MyCityTheme
import org.junit.Rule
import org.junit.Test

class WelcomeScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun myCityApp_compactSize_verifyInitialScreenAsWelcomeScreen() {

        composeTestRule.setContent {
            MyCityTheme {
                MyCityApp(widthSizeClass = WindowWidthSizeClass.Compact)
            }
        }


        composeTestRule
            .onNodeWithContentDescription(composeTestRule.activity.resources.getString(R.string.app_logo))
            .assertExists()
        composeTestRule
            .onNodeWithTag("TAG_CITY_DESCRIPTION")
            .assertExists()
        composeTestRule
            .onNodeWithText(composeTestRule.activity.resources.getString(R.string.start_exploring))
            .assertExists()
    }

    @Test
    fun myCityApp_mediumSize_verifyInitialScreenAsWelcomeScreen() {

        composeTestRule.setContent {
            MyCityTheme {
                MyCityApp(widthSizeClass = WindowWidthSizeClass.Medium)
            }
        }


        composeTestRule
            .onNodeWithContentDescription(composeTestRule.activity.resources.getString(R.string.app_logo))
            .assertExists()
        composeTestRule
            .onNodeWithTag("TAG_CITY_DESCRIPTION")
            .assertExists()
        composeTestRule
            .onNodeWithText(composeTestRule.activity.resources.getString(R.string.start_exploring))
            .assertExists()


        composeTestRule
            .onNodeWithTag("TAG_NAVIGATION_RAIL")
            .assertExists()
        composeTestRule
            .onNodeWithTag("TAG_HOME_NAVIGATION_RAIL")
            .assertIsSelected()


        for (category in Datasource.getCategories()) {
            val categoryNameTag =
                composeTestRule.activity.resources.getString(category.name).uppercase()
            composeTestRule
                .onNodeWithTag("TAG_${categoryNameTag}_NAVIGATION_RAIL")
                .assertExists()
            composeTestRule
                .onNodeWithTag("TAG_${categoryNameTag}_NAVIGATION_RAIL")
                .assertIsNotSelected()
        }
    }

    @Test
    fun myCityApp_expandedSize_verifyInitialScreenAsWelcomeScreen() {
        // GIVEN: app has been launched
        composeTestRule.setContent {
            MyCityTheme {
                MyCityApp(widthSizeClass = WindowWidthSizeClass.Expanded)
            }
        }


        composeTestRule
            .onNodeWithContentDescription(composeTestRule.activity.resources.getString(R.string.app_logo))
            .assertExists()
        composeTestRule
            .onNodeWithTag("TAG_CITY_DESCRIPTION")
            .assertExists()
        composeTestRule
            .onNodeWithText(composeTestRule.activity.resources.getString(R.string.start_exploring))
            .assertExists()


        composeTestRule
            .onNodeWithTag("TAG_NAVIGATION_DRAWER")
            .assertExists()
        composeTestRule
            .onNodeWithTag("TAG_HOME_NAVIGATION_DRAWER")
            .assertIsSelected()


        for (category in Datasource.getCategories()) {
            val categoryNameTag =
                composeTestRule.activity.resources.getString(category.name).uppercase()
            composeTestRule
                .onNodeWithTag("TAG_${categoryNameTag}_NAVIGATION_DRAWER")
                .assertExists()
            composeTestRule
                .onNodeWithTag("TAG_${categoryNameTag}_NAVIGATION_DRAWER")
                .assertIsNotSelected()
        }
    }

    @Test
    fun welcomeScreen_compactSize_noUpButtonShown() {

        composeTestRule.setContent {
            MyCityTheme {
                MyCityApp(widthSizeClass = WindowWidthSizeClass.Compact)
            }
        }


        composeTestRule
            .onNodeWithContentDescription(composeTestRule.activity.resources.getString(R.string.navigate_up_button))
            .assertDoesNotExist()
    }

    @Test
    fun welcomeScreen_mediumSize_noUpButtonShown() {

        composeTestRule.setContent {
            MyCityTheme {
                MyCityApp(widthSizeClass = WindowWidthSizeClass.Medium)
            }
        }


        composeTestRule
            .onNodeWithContentDescription(composeTestRule.activity.resources.getString(R.string.navigate_up_button))
            .assertDoesNotExist()
    }

    @Test
    fun welcomeScreen_expandedSize_noUpButtonShown() {

        composeTestRule.setContent {
            MyCityTheme {
                MyCityApp(widthSizeClass = WindowWidthSizeClass.Expanded)
            }
        }


        composeTestRule
            .onNodeWithContentDescription(composeTestRule.activity.resources.getString(R.string.navigate_up_button))
            .assertDoesNotExist()
    }

    @Test
    fun startExploringButton_compactSize_OnClick() {

        composeTestRule.setContent {
            MyCityTheme {
                MyCityApp(widthSizeClass = WindowWidthSizeClass.Compact)
            }
        }


        composeTestRule
            .onNodeWithText(composeTestRule.activity.resources.getString(R.string.start_exploring))
            .performClick()


        composeTestRule
            .onNodeWithContentDescription(composeTestRule.activity.resources.getString(R.string.app_logo))
            .assertDoesNotExist()
        composeTestRule
            .onNodeWithTag("TAG_CITY_DESCRIPTION")
            .assertDoesNotExist()


        composeTestRule
            .onNodeWithTag("TAG_CATEGORIES_GRID")
            .assertExists()
    }

    @Test
    fun startExploringButton_mediumSize_OnClick() {

        composeTestRule.setContent {
            MyCityTheme {
                MyCityApp(widthSizeClass = WindowWidthSizeClass.Medium)
            }
        }


        composeTestRule
            .onNodeWithText(composeTestRule.activity.resources.getString(R.string.start_exploring))
            .performClick()


        composeTestRule
            .onNodeWithContentDescription(composeTestRule.activity.resources.getString(R.string.app_logo))
            .assertDoesNotExist()
        composeTestRule
            .onNodeWithTag("TAG_CITY_DESCRIPTION")
            .assertDoesNotExist()


        val categoryNameTag =
            composeTestRule.activity.resources.getString(Datasource.getCategories()[0].name).uppercase()
        composeTestRule
            .onNodeWithTag("TAG_${categoryNameTag}_NAVIGATION_RAIL")
            .assertIsSelected()

        composeTestRule
            .onNodeWithTag("TAG_ENTRIES_LIST")
            .assertExists()

    }

    @Test
    fun startExploringButton_expandedSize_OnClick() {

        composeTestRule.setContent {
            MyCityTheme {
                MyCityApp(widthSizeClass = WindowWidthSizeClass.Expanded)
            }
        }


        composeTestRule
            .onNodeWithText(composeTestRule.activity.resources.getString(R.string.start_exploring))
            .performClick()


        composeTestRule
            .onNodeWithContentDescription(composeTestRule.activity.resources.getString(R.string.app_logo))
            .assertDoesNotExist()
        composeTestRule
            .onNodeWithTag("TAG_CITY_DESCRIPTION")
            .assertDoesNotExist()


        val categoryNameTag =
            composeTestRule.activity.resources.getString(Datasource.getCategories()[0].name).uppercase()
        composeTestRule
            .onNodeWithTag("TAG_${categoryNameTag}_NAVIGATION_DRAWER")
            .assertIsSelected()

        composeTestRule
            .onNodeWithTag("TAG_ENTRIES_LIST")
            .assertExists()

    }
}