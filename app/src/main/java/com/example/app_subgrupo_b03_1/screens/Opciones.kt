package com.example.app_subgrupo_b03_1.screens

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri

@Composable
fun Opciones(
    dark: Boolean, // indica si está activado el tema oscuro
    onToggleDark: (Boolean) -> Unit // cambia el estado del switch
) {
    val ctx = LocalContext.current // el contexto sirve para abrir apps externas
    var notifications by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Opciones", style = MaterialTheme.typography.headlineMedium)

        // 🌙 Tema oscuro / claro
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Tema oscuro")
            Switch(checked = dark, onCheckedChange = onToggleDark)
        }

        // 🔔 Activar / desactivar notificaciones
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Notificaciones")
            Switch(checked = notifications, onCheckedChange = { notifications = it })
        }

        HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)

        // 📤 Compartir proyecto
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val share = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_SUBJECT, "Proyecto Android")
                    putExtra(
                        Intent.EXTRA_TEXT,
                        "Mira nuestro proyecto: https://github.com/lijirblue/APP_SUBGRUPO_B03_1"
                    )
                }
                ctx.startActivity(Intent.createChooser(share, "Compartir con"))
            }
        ) {
            Text("Compartir proyecto")
        }

        // 📧 Enviar correo de feedback
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = "mailto:soporte@appsubgrupo.com".toUri()
                    putExtra(Intent.EXTRA_SUBJECT, "Sugerencias o comentarios")
                }
                ctx.startActivity(intent)
            }
        ) {
            Text("Enviar sugerencia por correo")
        }

        // 🌐 Abrir sitio web o política de privacidad
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW, "https://www.canva.com".toUri())
                ctx.startActivity(intent)
            }
        ) {
            Text("Abrir sitio web")
        }

        // 👥 Acerca de la app
        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val about = Intent(Intent.ACTION_VIEW, "https://github.com/lijirblue".toUri())
                ctx.startActivity(about)
            }
        ) {
            Text("Acerca de los desarrolladores")
        }

        HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)

        // 🚪 Cerrar sesión (simulado)
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.errorContainer),
            onClick = {
                // Aquí podrías limpiar datos o navegar a pantalla de login
                val logout = Intent(Intent.ACTION_MAIN).apply {
                    addCategory(Intent.CATEGORY_HOME)
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                }
                ctx.startActivity(logout)
            }
        ) {
            Text("Cerrar sesión", color = MaterialTheme.colorScheme.onErrorContainer)
        }
    }
}