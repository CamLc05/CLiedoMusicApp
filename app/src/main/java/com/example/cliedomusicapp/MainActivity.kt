package com.example.cliedomusicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.cliedomusicapp.components.MiniPlayer
import com.example.cliedomusicapp.models.DetalleAlbumScreenRoute
import com.example.cliedomusicapp.screens.DetalleAlbumScreen
import com.example.cliedomusicapp.models.HomeScreenRoute
import com.example.cliedomusicapp.screens.HomeScreen
import com.example.cliedomusicapp.ui.theme.CLiedoMusicAppTheme
import com.example.cliedomusicapp.ui.theme.fondoDegradado
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val StaticAlbumTitle = "Tales of Ithiria • Track 3"
        val StaticArtistName = "Haggard"
        val StaticImageUrl =
            "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEj7ugde1AEMq01vmC8BVEpLdF0Xek6AY9bGlBiOU5KnDJwkIfGTjfPDgNDzOdO_IiigYdzctv_esbkP2J-Q4A7KczJJMotAnqNg7hRCCQYD5Ej8Q4gWq3FidTimmOG79GXLx3jiHwI-hA0/w1200-h630-p-k-no-nu/51TLuWZMYeL._SS500_-tn-600x470-0-FFFFFF.jpg"

        setContent {
            val navController = rememberNavController()

            CLiedoMusicAppTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(brush = fondoDegradado)
                ) {
                    // 🧭 Contenido principal
                    NavHost(
                        navController = navController,
                        startDestination = HomeScreenRoute,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        composable<HomeScreenRoute> {
                            HomeScreen(navController)
                        }
                        composable<DetalleAlbumScreenRoute> { backEntry ->
                            val args = backEntry.toRoute<DetalleAlbumScreenRoute>()
                            DetalleAlbumScreen(args.id, navController)
                        }
                    }

                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 10.dp) // 👈 aquí tu padding
                    ) {
                        MiniPlayer(
                            albumTitle = StaticAlbumTitle,
                            artistName = StaticArtistName,
                            imageUrl = StaticImageUrl
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