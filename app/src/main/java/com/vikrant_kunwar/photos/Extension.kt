package com.vikrant_kunwar.photos

import kotlin.math.sqrt

fun Int.isTriangularNumber() : Boolean{
    val n = ((-1 + sqrt(1 + 8 * this.toDouble())) / 2).toInt()
    val check = n * (n + 1) / 2
    return  check == this
}