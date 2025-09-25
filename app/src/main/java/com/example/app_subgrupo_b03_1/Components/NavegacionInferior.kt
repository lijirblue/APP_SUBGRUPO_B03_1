package com.example.app_subgrupo_b03_1.Components

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.app_subgrupo_b03_1.models.Ittems_bottom_nav.*
import com.example.app_subgrupo_b03_1.navegation.currentRoute


@Composable
fun NavegacionInferior(
    navController: NavHostController
){
    val menu_items = listOf(
        Item_bottom_nav1,
        Item_bottom_nav2,
        Item_bottom_nav3,
        Item_bottom_nav4,
        Item_bottom_nav5,
    )
    BottomAppBar {
        NavigationBar {
            menu_items.forEach {item->
                val selected = currentRoute(navController) == item.ruta
                NavigationBarItem(
                    selected = selected,
                    onClick = {navController.navigate(item.ruta)  },
                    icon = {
                        Icon(imageVector = item.icon,
                            contentDescription = item.title
                        )
                    },
                    label = {
                        Text(text = item.title)
                    }

                )

            }
        }
    }
}