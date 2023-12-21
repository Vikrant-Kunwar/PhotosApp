package com.vikrant_kunwar.photos.compose

import android.net.Uri
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.vikrant_kunwar.photos.isTriangularNumber

@Composable
fun ImageList(
    size: Int,
    firstImageUri: Uri?,
    secondImageUri: Uri?
){
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
    ){
        items(size){index ->
            val toShowImage = if((index+1).isTriangularNumber()) firstImageUri else secondImageUri
            SelectedImageUI(uri = toShowImage, imageNumber = "${index+1}")
        }
    }
}
