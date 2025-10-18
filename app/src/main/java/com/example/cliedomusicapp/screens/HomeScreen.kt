package com.example.cliedomusicapp.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cliedomusicapp.components.CarruselAlbum
import com.example.cliedomusicapp.components.Header
import com.example.cliedomusicapp.components.ListaAlbums
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.cliedomusicapp.models.Album
import com.example.cliedomusicapp.models.DetalleAlbumScreenRoute
import com.example.cliedomusicapp.models.MusicPlayerViewModel
import com.example.cliedomusicapp.ui.theme.CLiedoMusicAppTheme
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.cliedomusicapp.services.AlbumService
@Composable
fun HomeScreen(
    navController: NavController,
    musicPlayerViewModel: MusicPlayerViewModel
) {
    val BASE_URL = "https://music.juanfrausto.com/"
    var albums by remember { mutableStateOf(listOf<Album>()) }
    var loading by remember { mutableStateOf(true) }

    LaunchedEffect(true) {
        try {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(AlbumService::class.java)
            val result = withContext(Dispatchers.IO) { service.getAllAlbums() }
            albums = result
        } catch (e: Exception) {
            Log.e("HomeScreen", "Algo falló: ${e}")
        } finally {
            loading = false
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Header()

        if (loading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = Color(0xFF4C06A6))
            }
        } else {
            CarruselAlbum(navController)

            LazyColumn(
                modifier = Modifier.padding(vertical = 15.dp)
            ) {
                items(albums) { album ->
                    ListaAlbums(album, onClick = {
                        musicPlayerViewModel.updateTrack(
                            albumTitle = album.title,
                            artistName = album.artist,
                            imageUrl = album.image
                        )

                        navController.navigate(DetalleAlbumScreenRoute(album.id))
                    })
                }
            }
        }
    }
}

