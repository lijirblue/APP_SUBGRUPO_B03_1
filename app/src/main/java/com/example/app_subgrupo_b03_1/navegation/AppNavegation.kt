package com.example.app_subgrupo_b03_1.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.app_subgrupo_b03_1.screens.*

@Composable
fun AppNavegation(navController: NavHostController) {   // ← recibe el controller
    NavHost(navController = navController, startDestination = NavScreen.Perfil.route) {
        composable(NavScreen.Perfil.route)    { Perfil() }
        composable(NavScreen.Galeria.route)   { Galeria() }
        composable(NavScreen.Video.route)     { Video() }
        composable(NavScreen.Navegador.route) { Navegador() }
        composable(NavScreen.Opciones.route)  { Opciones() }
    }
}