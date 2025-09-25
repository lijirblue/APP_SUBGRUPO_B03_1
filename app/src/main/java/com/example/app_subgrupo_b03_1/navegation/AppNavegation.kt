package com.example.app_subgrupo_b03_1.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.app_subgrupo_b03_1.screens.Galeria
import com.example.app_subgrupo_b03_1.screens.Navegador
import com.example.app_subgrupo_b03_1.screens.Opciones
import com.example.app_subgrupo_b03_1.screens.Perfil
import com.example.app_subgrupo_b03_1.screens.Video

@Composable
fun AppNavegation(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = NavScreen.Perfil.name
    ){
     composable(route=NavScreen.Perfil.name){
         Perfil()
     }
     composable(route=NavScreen.Galeria.name){
         Galeria()
     }
    composable(route=NavScreen.Video.name){
        Video()
    }
    composable(route=NavScreen.Navegador.name){
        Navegador()
        }
    composable(route=NavScreen.Opciones.name){
        Opciones()
        }
    }
}