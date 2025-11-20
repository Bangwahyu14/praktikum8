package com.example.praktikum8.ui.theme.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.praktikum8.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilData(
    navController: NavController,
    nama: String?,
    jenisKelamin: String?,
    alamat: String?
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Data Terkirim", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700)
                )
            )
        }
    ){ isiRuang ->
        Column(
            modifier = Modifier
                .padding(isiRuang)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Nama Lengkap:", fontSize = 16.sp)
            Text(
                text = nama ?: "-",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive,
                fontSize = 22.sp
            )

            Text("Jenis Kelamin:", fontSize = 16.sp)
            Text(
                text = jenisKelamin ?: "-",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive,
                fontSize = 22.sp
            )

            Text("Alamat:", fontSize = 16.sp)
            Text(
                text = alamat ?: "-",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive,
                fontSize = 22.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { navController.navigate("Beranda") }
            ) {
                Text(text = "Kembali ke Beranda")
            }
        }
    }
}