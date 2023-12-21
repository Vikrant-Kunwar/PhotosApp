package com.vikrant_kunwar.photos.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SizeUI(
    onClickSub: () -> Unit,
    onClickAdd: () -> Unit,
    size: Int
) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        actionButton(onClickSub, "-", Color.Red)

        Text(text = "  $size  ",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold)
        actionButton(onClickAdd, "+",Color.Green)



    }
}

@Composable
private fun actionButton(onClickSub: () -> Unit, s: String, color:Color) {
    Box(

        Modifier
            .background(
                color = color,
                shape = RoundedCornerShape(15.dp)
            )
            .size(40.dp)
            .clickable {
                onClickSub()
            },
        contentAlignment = Alignment.Center
    ) {

        Text(text = s, fontSize = 24.sp, color = Color.White, fontWeight = FontWeight.Bold)
    }
}