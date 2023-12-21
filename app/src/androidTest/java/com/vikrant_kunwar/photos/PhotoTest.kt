package com.vikrant_kunwar.photos

import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.vikrant_kunwar.photos.compose.PhotosAppUI
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Rule
import org.junit.Test

class PhotoTest {
    @get:Rule
    val rule = createComposeRule()
    
    private val viewModel: MainViewModel
        get() = mockk()

    val plusButton = hasText("+") and hasClickAction()
    val minusButton = hasText("-") and hasClickAction()
    @Test
    fun enterPlus_showsAddedData(){
        rule.setContent { PhotosAppUI() }

        //do action
        rule.onNode(plusButton).performClick()
        rule.onNode(plusButton).performClick()

        //check
        rule.onNodeWithText("2").assertExists()


    }

    @Test
    fun enterPlusAndMinus_showsCorrectData(){
        rule.setContent { PhotosAppUI() }

        //do action
        rule.onNode(plusButton).performClick()
        rule.onNode(plusButton).performClick()
        rule.onNode(plusButton).performClick()
        rule.onNode(plusButton).performClick()
        rule.onNode(minusButton).performClick()
        rule.onNode(minusButton).performClick()

        //check
        rule.onNodeWithText("2").assertExists()
    }
}