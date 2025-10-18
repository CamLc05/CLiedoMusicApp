package com.example.cliedomusicapp.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class CurrentTrack(
    val albumTitle: String = "",
    val artistName: String = "",
    val imageUrl: String = ""
)

class MusicPlayerViewModel : ViewModel() {
    var currentTrack by mutableStateOf(CurrentTrack())
        private set

    fun updateTrack(albumTitle: String, artistName: String, imageUrl: String) {
        currentTrack = CurrentTrack(albumTitle, artistName, imageUrl)
    }
}
