package com.vikrant_kunwar.photos
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
class TriangularNumberTest {

    @Test
    fun testIsTriangularNumber() {
        // Test with a triangular number (e.g., 3)
        assertTrue(3.isTriangularNumber())

        // Test with a non-triangular number (e.g., 5)
        assertFalse(5.isTriangularNumber())

        // Test with zero (0 is a triangular number)
        assertTrue(0.isTriangularNumber())

        // Test with a negative number (should always be false)
        assertFalse((-1).isTriangularNumber())

        // Test with a large triangular number (e.g., 5050)
        assertTrue(5050.isTriangularNumber())
    }
}