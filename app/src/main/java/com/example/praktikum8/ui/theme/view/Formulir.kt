package com.example.praktikum8.ui.theme.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.praktikum8.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormIsian(
    navController: NavController
) {
    val jenisKList = listOf("Laki-Laki", "Perempuan")


    var nama by rememberSaveable { mutableStateOf("") }
    var alamat by rememberSaveable { mutableStateOf("") }
    var jenisKelamin by rememberSaveable { mutableStateOf(jenisKList[0]) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Formulir Isian", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700)
                )
            )
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier
                .padding(isiRuang)
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it },
                label = { Text("Nama Lengkap") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Jenis Kelamin")
            Row {
                jenisKList.forEach { item ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = jenisKelamin == item,
                            onClick = { jenisKelamin = item }
                        )
                        Text(text = item)
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = alamat,
                onValueChange = { alamat = it },
                label = { Text("Alamat") },
                singleLine = false,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navController.navigate(
                        "Detail/${nama}/${jenisKelamin}/${alamat}"
                    )
                }
            ) {
                Text(text = stringResource(id = R.string.submit))
            }
        }
    }
}