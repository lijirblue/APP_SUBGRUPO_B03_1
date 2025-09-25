package com.example.app_subgrupo_b03_1.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun currentRoute(navController: NavHostController) : String? =
    navController.currentBackStackEntryAsState().value?.destination?.route