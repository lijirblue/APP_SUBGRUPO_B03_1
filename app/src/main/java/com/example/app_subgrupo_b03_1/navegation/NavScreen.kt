package com.example.app_subgrupo_b03_1.navegation

sealed class NavScreen(val route: String) {
    object Perfil : NavScreen("perfil")
    object Galeria : NavScreen("galeria")
    object Video : NavScreen("video")
    object Navegador : NavScreen("navegador")
    object Opciones : NavScreen("opciones")
}