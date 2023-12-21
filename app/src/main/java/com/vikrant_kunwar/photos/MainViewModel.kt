package com.vikrant_kunwar.photos

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var listSize by mutableIntStateOf(0)
        private set

    var firstImageUri by mutableStateOf<Uri?>(null)
        private set

    var secondImageUri by mutableStateOf<Uri?>(null)
        private set


    fun add(){
        listSize+= 1
    }
    fun subtract(){
        val toSubtractSize  = listSize - 1
        if(toSubtractSize >= 0){
            listSize = toSubtractSize
        }
    }
    fun setImageUris(uri: List<Uri?>){
        uri.forEach {
            it?.let {
               val index = uri.indexOf(it)
               if(index == 0){
                   firstImageUri = it
               }else{
                   secondImageUri = it
               }
            }
        }
    }
}