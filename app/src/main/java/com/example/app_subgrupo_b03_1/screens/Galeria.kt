package com.example.app_subgrupo_b03_1.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_subgrupo_b03_1.R

// --- CAMBIO: Se añade el campo 'description' a la estructura de datos ---
data class GalleryItem(
    val name: String,
    val imageRes: Int,
    val description: String // Nueva propiedad para la descripción
)

// --- CAMBIO: Se añaden descripciones a cada elemento de la lista ---
val galleryItems = listOf(
    GalleryItem("Hilton", R.drawable.hilton, "Logo para cadena hotelera de lujo."),
    GalleryItem("Nescafé", R.drawable.nescafe, "Diseño de marca para café instantáneo."),
    GalleryItem("Burberry", R.drawable.burberry, "Identidad visual para marca de moda."),
    GalleryItem("Heinz", R.drawable.heinz, "Emblema para empresa de alimentos."),
    GalleryItem("Dior", R.drawable.dior, "Logo de alta costura y perfumería."),
    GalleryItem("Skype", R.drawable.skype, "Icono para servicio de comunicación."),
    GalleryItem("FedEx", R.drawable.fedex, "Diseño para compañía de logística global.")
)

@Composable
fun Galeria() {
    var selectedItem by remember { mutableStateOf<GalleryItem?>(null) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "GALERIA",
                fontSize = 32.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2), // --- CAMBIO: Reducido a 2 columnas para dar espacio a la descripción ---
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(galleryItems) { item ->
                    GalleryImage(
                        item = item,
                        onClick = {
                            selectedItem = item
                        }
                    )
                }
            }
        }

        selectedItem?.let { item ->
            FullScreenImage(
                item = item,
                onClose = {
                    selectedItem = null
                }
            )
        }
    }
}

@Composable
fun GalleryImage(item: GalleryItem, onClick: () -> Unit) {
    // --- CAMBIO: La Card ahora contiene una Column para la imagen y el texto ---
    Card(
        modifier = Modifier.clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        // Column para organizar la imagen y la descripción verticalmente.
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(120.dp) // Altura fija para la imagen
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp)) // Espacio entre imagen y texto
            Text(
                text = item.description,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun FullScreenImage(item: GalleryItem, onClose: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.85f))
            .clickable(onClick = onClose),
        contentAlignment = Alignment.Center
    ) {
        // --- CAMBIO: Se añade una Column para mostrar la imagen y su descripción ---
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(32.dp)
        ) {
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = "Imagen en primer plano: ${item.name}",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = item.description,
                color = Color.White, // Texto blanco para que sea legible sobre el fondo oscuro
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}
