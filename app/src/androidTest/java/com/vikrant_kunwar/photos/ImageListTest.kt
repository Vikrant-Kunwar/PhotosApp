package com.vikrant_kunwar.photos

import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertContentDescriptionEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.vikrant_kunwar.photos.compose.ImageList
import org.junit.Rule
import org.junit.Test

class ImageListTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testImageList() {
        // Mock data for testing
        val size = 3
        val firstImageUri = Uri.parse("content://firstImage")
        val secondImageUri = Uri.parse("content://secondImage")

        // Launch the composable with test data
        composeTestRule.setContent {
            Surface(
                modifier = Modifier,
                color = MaterialTheme.colorScheme.background
            ) {
                ImageList(
                    size = size,
                    firstImageUri = firstImageUri,
                    secondImageUri = secondImageUri
                )
            }
        }

        // Verify that the correct number of images is displayed
        composeTestRule.onNodeWithText("3").assertExists()

        // Verify that the content description of each image is set correctly
        for (index in 0 until size) {
            composeTestRule.onNodeWithText("${index + 1}").assertExists()
        }

        // Verify that the images are displayed and visible
        for (index in 0 until size) {
            composeTestRule.onNodeWithText("${index + 1}").assertIsDisplayed()
        }
    }
}