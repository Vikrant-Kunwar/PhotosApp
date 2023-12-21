package com.vikrant_kunwar.photos.compose

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vikrant_kunwar.photos.MainViewModel

@Composable
fun PhotosAppUI(
) {
    val mainViewModel = viewModel<MainViewModel>()
    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickMultipleVisualMedia(2),
        onResult = {
            mainViewModel.setImageUris(it)
        }
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            photoPickerLauncher.launch(
                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
            )
        }) {
            Text(text = "Pick 2 Image")
        }
        SizeUI(
            onClickSub = {
                mainViewModel.subtract()
            }, onClickAdd = {
                mainViewModel.add()
            },
            size = mainViewModel.listSize
        )

        ImageList(
            size = mainViewModel.listSize,
            firstImageUri = mainViewModel.firstImageUri,
            secondImageUri = mainViewModel.secondImageUri
        )
    }
}