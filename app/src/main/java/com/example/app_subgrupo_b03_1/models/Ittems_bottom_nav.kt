package com.example.app_subgrupo_b03_1.models
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Navigation
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Photo
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.VideoLibrary
import androidx.compose.material.icons.outlined.WebAsset
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.app_subgrupo_b03_1.navegation.NavScreen

sealed class Ittems_bottom_nav (
    val icon: ImageVector,
    val title: String,
    val ruta: String
){
    object Item_bottom_nav1:Ittems_bottom_nav(
        Icons.Outlined.Person,
        "Perfil",
        NavScreen.Perfil.name
    )
    object Item_bottom_nav3: Ittems_bottom_nav(
        Icons.Outlined.VideoLibrary,
        "Video",
        NavScreen.Video.name
    )
    object Item_bottom_nav4: Ittems_bottom_nav(
        Icons.Outlined.Navigation,
        "Navegador",
        NavScreen.Navegador.name
    )
    object Item_bottom_nav2: Ittems_bottom_nav(
        Icons.Outlined.Photo,
        "Galeria",
        NavScreen.Galeria.name
    )
    object Item_bottom_nav5: Ittems_bottom_nav(
        Icons.Outlined.Settings,
        "Opciones",
        NavScreen.Opciones.name
    )
}