package com.example.app_subgrupo_b03_1.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.net.toUri
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.app_subgrupo_b03_1.R

@Composable
fun Video() {
    val ctx = LocalContext.current

    // Se crea una sola vez
    val player = remember {
        ExoPlayer.Builder(ctx).build().apply {
            val uri = "android.resource://${ctx.packageName}/${R.raw.sample_video}".toUri()
            setMediaItem(MediaItem.fromUri(uri))
            prepare()
            playWhenReady = false
        }
    }
    // Se libera al salir
    DisposableEffect(Unit) { onDispose { player.release() } }

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Video", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(12.dp))

        AndroidView(
            factory = { PlayerView(ctx).apply { this.player = player } },
            modifier = Modifier.fillMaxWidth().height(240.dp)
        )

        Spacer(Modifier.height(12.dp))
        Row {
            Button(onClick = { player.play() }) { Text("Play") }
            Spacer(Modifier.width(8.dp))
            Button(onClick = { player.pause() }) { Text("Pause") }
            Spacer(Modifier.width(8.dp))
            Button(onClick = { player.seekTo(0) }) { Text("Reinier") }
        }
    }
}