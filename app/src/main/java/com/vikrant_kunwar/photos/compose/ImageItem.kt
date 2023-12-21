package com.vikrant_kunwar.photos.compose

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.vikrant_kunwar.photos.R

@Composable
fun SelectedImageUI(
    uri: Uri?,
    imageNumber: String,
    onClick: () -> Unit = {}
) {
    Box(
        Modifier
            .size(100.dp)
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.TopStart
    ) {
        Column {
            Text(text = imageNumber, fontSize = 24.sp, color = Color.Black)

            AsyncImage(
                model = uri ?: R.drawable.placeholder,
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.size(100.dp),
                filterQuality = FilterQuality.Medium
            )

        }
    }
}
