package com.example.app_subgrupo_b03_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.app_subgrupo_b03_1.Components.NavegacionInferior
import com.example.app_subgrupo_b03_1.navegation.AppNavegation
// Si tienes tu propio tema, descomenta esta línea ↓
// import com.example.app_subgrupo_b03_1.ui.theme.APP_SUBGRUPO_B03_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    // 💡 Estado del tema (se guarda aunque gires la pantalla)
    var dark by rememberSaveable { mutableStateOf(false) }

    // Si tienes tu propio tema personalizado, puedes usarlo así:
    // APP_SUBGRUPO_B03_1Theme(darkTheme = dark) {
    MaterialTheme {
        Scaffold(
            bottomBar = { NavegacionInferior(navController) }
        ) { padding ->
            Box(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                // 🚀 Pasamos el estado del tema a toda la app
                AppNavegation(
                    navController = navController,
                    dark = dark,
                    onToggleDark = { dark = it }
                )
            }
        }
    }
    // }
}