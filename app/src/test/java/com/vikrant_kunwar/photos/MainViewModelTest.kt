package com.vikrant_kunwar.photos

import android.net.Uri
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import org.mockito.Mockito.mock


class MainViewModelTest {

    // Mocking ViewModel dependencies
    private val viewModel = MainViewModel()

    @Test
    fun testAdd() {
        // Initial size
        assertEquals(0, viewModel.listSize)

        // Call add method
        viewModel.add()

        // Check if size increased by 1
        assertEquals(1, viewModel.listSize)
    }

    @Test
    fun testSubtract() {


        // Call subtract method
        viewModel.subtract()

        // Check if size decreased by 1 (since it should not go below 0)
        assertEquals(0, viewModel.listSize)
    }

    @Test
    fun testSubtractNotBelowZero() {


        // Call subtract method
        viewModel.subtract()

        // Check if size remains 2 (it should not go below 2)
        assertEquals(0, viewModel.listSize)
    }

    @Test
    fun testSetImageUris() {
        // Create a list of URIs
        val uris = listOf(mock(Uri::class.java), mock(Uri::class.java))

        // Call setImageUris method
        viewModel.setImageUris(uris)

        // Check if firstImageUri and secondImageUri are set correctly
        assertEquals(uris[0], viewModel.firstImageUri)
        assertEquals(uris[1], viewModel.secondImageUri)
    }

    @Test
    fun testSetImageUrisNull() {
        // Create a list of null URIs
        val uris = listOf(null, null)

        // Call setImageUris method
        viewModel.setImageUris(uris)

        // Check if firstImageUri and secondImageUri are still null
        assertNull(viewModel.firstImageUri)
        assertNull(viewModel.secondImageUri)
    }

}