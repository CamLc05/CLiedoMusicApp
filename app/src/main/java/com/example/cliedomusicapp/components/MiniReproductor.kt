package com.example.cliedomusicapp.components

import com.example.cliedomusicapp.ui.theme.Purple40

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun MiniPlayer(
    albumTitle: String,
    artistName: String,
    imageUrl: String,
    modifier: Modifier
) {


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 50.dp)
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .height(80.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Purple40)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = albumTitle,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
                Spacer(Modifier.width(12.dp))
                Column {
                    Text(
                        text = albumTitle,
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge,
                        maxLines = 1,
                        modifier = Modifier
                            .padding(bottom = 5.dp)
                    )
                    Text(
                        text = artistName,
                        color = Color.White.copy(alpha = 0.7f),
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 1
                    )
                }
            }

            IconButton(modifier = Modifier
                .clip(RoundedCornerShape(50.dp))
                .background(Color.White),
                onClick = { }) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Reproducir",
                    tint = Purple40,
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}