package com.example.cliedomusicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.cliedomusicapp.components.MiniPlayer
import com.example.cliedomusicapp.models.DetalleAlbumScreenRoute
import com.example.cliedomusicapp.screens.DetalleAlbumScreen
import com.example.cliedomusicapp.models.HomeScreenRoute
import com.example.cliedomusicapp.models.MusicPlayerViewModel
import com.example.cliedomusicapp.screens.HomeScreen
import com.example.cliedomusicapp.ui.theme.CLiedoMusicAppTheme
import com.example.cliedomusicapp.ui.theme.fondoDegradado
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()
            val musicPlayerViewModel = viewModel<MusicPlayerViewModel>()

            CLiedoMusicAppTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(brush = fondoDegradado)
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = HomeScreenRoute,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        composable<HomeScreenRoute> {
                            HomeScreen(navController, musicPlayerViewModel)
                        }
                        composable<DetalleAlbumScreenRoute> { backEntry ->
                            val args = backEntry.toRoute<DetalleAlbumScreenRoute>()
                            DetalleAlbumScreen(args.id, navController)
                        }
                    }

                    val track = musicPlayerViewModel.currentTrack
                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .padding(bottom = 10.dp)
                        ) {
                            MiniPlayer(
                                albumTitle = track.albumTitle,
                                artistName = track.artistName,
                                imageUrl = track.imageUrl,
                                modifier = Modifier.align(Alignment.BottomCenter)
                            )

                    }
                }
            }
        }
    }
}





@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CLiedoMusicAppTheme {
        Greeting("Android")
    }
}