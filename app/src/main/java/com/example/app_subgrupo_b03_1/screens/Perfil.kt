package com.example.app_subgrupo_b03_1.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.app_subgrupo_b03_1.R

// --- CAMBIO: Modelo de datos ampliado ---
data class ProfileData(
    val name: String,
    val profession: String,
    val imageUri: Any?,
    val university: String,
    val experience: String,
    val programs: String
)

@Composable
fun Perfil() {
    // --- MANEJO DE ESTADO (AMPLIADO) ---
    var profileData by remember {
        mutableStateOf(
            ProfileData(
                name = "ANDREA\nLOPEZ",
                profession = "Diseñadora Grafica",
                imageUri = R.drawable.imagenperfil2,
                university = "Politecnico Gran\nColombiano - Año 2010",
                experience = "Mas de 10 años en diseños de logos para marcas independientes",
                programs = "PicMonkey\nCanva\nOpen Art"
            )
        )
    }
    var isEditing by remember { mutableStateOf(false) }

    // Estados temporales para todos los campos.
    var tempName by remember { mutableStateOf(profileData.name) }
    var tempProfession by remember { mutableStateOf(profileData.profession) }
    var tempImageUri by remember { mutableStateOf(profileData.imageUri) }
    var tempUniversity by remember { mutableStateOf(profileData.university) }
    var tempExperience by remember { mutableStateOf(profileData.experience) }
    var tempPrograms by remember { mutableStateOf(profileData.programs) }


    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { tempImageUri = it }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))

            AsyncImage(
                model = if (isEditing) tempImageUri else profileData.imageUri,
                contentDescription = "Foto de perfil",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(300.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray)
                    .clickable(enabled = isEditing) {
                        imagePickerLauncher.launch("image/*")
                    }
            )

            Spacer(modifier = Modifier.height(50.dp))

            if (isEditing) {
                // --- MODO EDICIÓN (AMPLIADO) ---
                OutlinedTextField(value = tempName, onValueChange = { tempName = it }, label = { Text("Nombre Completo") }, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(value = tempProfession, onValueChange = { tempProfession = it }, label = { Text("Profesión") }, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(32.dp))
                OutlinedTextField(value = tempUniversity, onValueChange = { tempUniversity = it }, label = { Text("Universidad") }, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(value = tempExperience, onValueChange = { tempExperience = it }, label = { Text("Experiencia") }, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(value = tempPrograms, onValueChange = { tempPrograms = it }, label = { Text("Programas Manejados") }, modifier = Modifier.fillMaxWidth())

            } else {
                // --- MODO VISTA ---
                Text(text = profileData.name, fontSize = 55.sp, textAlign = TextAlign.Center, fontFamily = FontFamily.Serif, lineHeight = 60.sp)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = profileData.profession, fontSize = 23.sp, fontFamily = FontFamily.Serif, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(50.dp))
                // Se usan los datos del estado 'profileData'.
                ProfileInfoRow(label = "UNIVERSIDAD", value = profileData.university)
                ProfileInfoRow(label = "EXPERIENCIA", value = profileData.experience)
                ProfileInfoRow(label = "PROGRAMAS\nMANEJADOS", value = profileData.programs)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.TopEnd),
            horizontalArrangement = Arrangement.End
        ) {
            if (isEditing) {
                IconButton(onClick = {
                    // --- CAMBIO: Se guardan todos los campos ---
                    profileData = ProfileData(
                        name = tempName,
                        profession = tempProfession,
                        imageUri = tempImageUri,
                        university = tempUniversity,
                        experience = tempExperience,
                        programs = tempPrograms
                    )
                    isEditing = false
                }) {
                    Icon(Icons.Default.Check, contentDescription = "Guardar")
                }
                IconButton(onClick = {
                    // --- CAMBIO: Se restauran todos los campos ---
                    tempName = profileData.name
                    tempProfession = profileData.profession
                    tempImageUri = profileData.imageUri
                    tempUniversity = profileData.university
                    tempExperience = profileData.experience
                    tempPrograms = profileData.programs
                    isEditing = false
                }) {
                    Icon(Icons.Default.Close, contentDescription = "Cancelar")
                }
            } else {
                IconButton(onClick = {
                    // --- CAMBIO: Se cargan todos los campos al modo edición ---
                    tempName = profileData.name
                    tempProfession = profileData.profession
                    tempImageUri = profileData.imageUri
                    tempUniversity = profileData.university
                    tempExperience = profileData.experience
                    tempPrograms = profileData.programs
                    isEditing = true
                }) {
                    Icon(Icons.Default.Edit, contentDescription = "Editar")
                }
            }
        }
    }
}

@Composable
fun ProfileInfoRow(label: String, value: String) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = label, modifier = Modifier.width(180.dp), fontSize = 23.sp, fontFamily = FontFamily.Serif, fontWeight = FontWeight.Bold)
            Text(text = value, fontSize = 18.sp)
        }
        HorizontalDivider(modifier = Modifier.padding(vertical = 30.dp), color = Color.LightGray, thickness = 2.dp)
    }
}
