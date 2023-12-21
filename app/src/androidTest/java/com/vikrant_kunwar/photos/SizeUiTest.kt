package com.vikrant_kunwar.photos

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.vikrant_kunwar.photos.compose.SizeUI
import org.junit.Rule
import org.junit.Test

class SizeUiTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testSizeUI() {
        // Mock data for testing
        var size by mutableStateOf(5)

        // Launch the composable with test data
        composeTestRule.setContent {
            SizeUI(
                onClickSub = { size-- },
                onClickAdd = { size++ },
                size = size
            )
        }

        // Verify that the text content is set correctly
        composeTestRule.onNodeWithText("  $size  ").assertIsDisplayed()

        // Verify the "-" button
        composeTestRule.onNodeWithText("-").assertIsDisplayed().performClick()
        assert(size == 4) // Verify that onClickSub is working correctly

        // Verify the "+" button
        composeTestRule.onNodeWithText("+").assertIsDisplayed().performClick()
        assert(size == 5) // Verify that onClickAdd is working correctly
    }
}